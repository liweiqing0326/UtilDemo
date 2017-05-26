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
import lwq.com.utildemo.Utlis.DeviceUtils;

public class DeviceActivity extends AppCompatActivity {

    @BindView(R.id.btn_shutdown)
    Button btnShutdown;
    @BindView(R.id.btn_reboot)
    Button btnReboot;
    @BindView(R.id.btn_reboot_to_recovery)
    Button btnRebootToRecovery;
    @BindView(R.id.btn_reboot_to_bootloader)
    Button btnRebootToBootloader;
    @BindView(R.id.tv_about_device)
    TextView tvAboutDevice;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        ButterKnife.bind(this);

        mContext = this;

        tvAboutDevice.setText("isRoot: " + DeviceUtils.isDeviceRooted()
                + "\ngetSDKVersion: " + DeviceUtils.getSDKVersion()
                + "\ngetAndroidID: " + DeviceUtils.getAndroidID(mContext)
                + "\ngetMacAddress: " + DeviceUtils.getMacAddress(mContext)
                + "\ngetManufacturer: " + DeviceUtils.getManufacturer()
                + "\ngetModel: " + DeviceUtils.getModel());
    }

    @OnClick({R.id.btn_shutdown, R.id.btn_reboot, R.id.btn_reboot_to_recovery, R.id.btn_reboot_to_bootloader})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_shutdown:
                DeviceUtils.shutdown(mContext);
                break;
            case R.id.btn_reboot:
                DeviceUtils.reboot(mContext);
                break;
            case R.id.btn_reboot_to_recovery:
                DeviceUtils.reboot2Recovery();
                break;
            case R.id.btn_reboot_to_bootloader:
                DeviceUtils.reboot2Bootloader();
                break;
        }
    }
}
