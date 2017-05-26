package lwq.com.utildemo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import lwq.com.utildemo.Utlis.LocationUtils;

public class LocationService extends Service {

    private boolean isSuccess;
    private String lastLatitude = "loading...";
    private String lastLongitude = "loading...";
    private String latitude = "loading...";
    private String longitude = "loading...";
    private String country = "loading...";
    private String locality = "loading...";
    private String street = "loading...";
    private OnGetLocationListener mOnGetLocationListener;
    private Context mContext;

    public void setOnGetLocationListener(OnGetLocationListener onGetLocationListener) {
        mOnGetLocationListener = onGetLocationListener;
    }

    private LocationUtils.OnLocationChangeListener mOnLocationChangeListener = new LocationUtils.OnLocationChangeListener() {
        @Override
        public void getLastKnownLocation(Location location) {
            lastLatitude = String.valueOf(location.getLatitude());
            lastLongitude = String.valueOf(location.getLongitude());
            if (mOnGetLocationListener != null) {
                mOnGetLocationListener.getLocation(lastLatitude, lastLongitude, latitude, longitude, country, locality, street);
            }
        }

        @Override
        public void onLocationChanged(final Location location) {
            latitude = String.valueOf(location.getLatitude());
            longitude = String.valueOf(location.getLongitude());
            if (mOnGetLocationListener != null) {
                mOnGetLocationListener.getLocation(lastLatitude, lastLongitude, latitude, longitude, country, locality, street);
            }
            country = LocationUtils.getCountryName(mContext, Double.parseDouble(latitude), Double.parseDouble(longitude));
            locality = LocationUtils.getLocality(mContext, Double.parseDouble(latitude), Double.parseDouble(longitude));
            street = LocationUtils.getStreet(mContext, Double.parseDouble(latitude), Double.parseDouble(longitude));
            if (mOnGetLocationListener != null) {
                mOnGetLocationListener.getLocation(lastLatitude, lastLongitude, latitude, longitude, country, locality, street);
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
    };

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                isSuccess = LocationUtils.register(mContext, 0, 0, mOnLocationChangeListener);
                if (isSuccess)
                    Toast.makeText(mContext, "init success", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new LocationBinder();
    }

    public class LocationBinder extends Binder {
        public LocationService getService() {
            return LocationService.this;
        }
    }

    @Override
    public void onDestroy() {
        LocationUtils.unregister();
        // 一定要制空，否则内存泄漏
        mOnGetLocationListener = null;
        super.onDestroy();
    }

    /**
     * 获取位置监听器
     */
    public interface OnGetLocationListener {
        void getLocation(
                String lastLatitude, String lastLongitude,
                String latitude, String longitude,
                String country, String locality, String street
        );
    }
}

