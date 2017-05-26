package lwq.com.utildemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lwq.com.utildemo.Utlis.NetworkUtils;

public class NetworkActivity extends AppCompatActivity {

    @BindView(R.id.btn_open_wireless_settings)
    Button btnOpenWirelessSettings;
    @BindView(R.id.btn_set_data_enabled)
    Button btnSetDataEnabled;
    @BindView(R.id.btn_set_wifi_enabled)
    Button btnSetWifiEnabled;
    @BindView(R.id.tv_about_network)
    TextView tvAboutNetwork;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        ButterKnife.bind(this);

        mContext = this;
        setAboutNetwork();
    }

    /**
     * 设置网络状态
     */
    private void setAboutNetwork() {
        tvAboutNetwork.setText("isConnected: " + NetworkUtils.isConnected(mContext)
                + "\nisAvailableByPing: " + NetworkUtils.isAvailableByPing()
                + "\ngetDataEnabled: " + NetworkUtils.getDataEnabled(mContext)
                + "\nis4G: " + NetworkUtils.is4G(mContext)
                + "\ngetWifiEnabled: " + NetworkUtils.getWifiEnabled(mContext)
                + "\nisWifiConnected: " + NetworkUtils.isWifiConnected(mContext)
                + "\nisWifiAvailable: " + NetworkUtils.isWifiAvailable(mContext)
                + "\nisAvailableByPing: " + NetworkUtils.isAvailableByPing()
                + "\ngetNetworkOperatorName: " + NetworkUtils.getNetworkOperatorName(mContext)
                + "\ngetNetworkTypeName: " + NetworkUtils.getNetworkType(mContext)
                + "\ngetIPAddress: " + NetworkUtils.getIPAddress(true)
                + "\ngetDomainAddress: " + NetworkUtils.getDomainAddress("baidu.com")
        );
    }

    @OnClick({R.id.btn_open_wireless_settings, R.id.btn_set_data_enabled, R.id.btn_set_wifi_enabled})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_open_wireless_settings:
                NetworkUtils.openWirelessSettings(mContext);
                break;
            case R.id.btn_set_data_enabled:
                NetworkUtils.setDataEnabled(mContext, !NetworkUtils.getDataEnabled(mContext));
                break;
            case R.id.btn_set_wifi_enabled:
                NetworkUtils.setWifiEnabled(mContext, !NetworkUtils.getWifiEnabled(mContext));
                break;
        }
        setAboutNetwork();
    }
}
