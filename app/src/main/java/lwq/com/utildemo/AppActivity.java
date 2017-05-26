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
import lwq.com.utildemo.Utlis.AppUtils;

public class AppActivity extends AppCompatActivity {

    @BindView(R.id.btn_install_app)
    Button btnInstallApp;
    @BindView(R.id.btn_install_app_silent)
    Button btnInstallAppSilent;
    @BindView(R.id.btn_uninstall_app)
    Button btnUninstallApp;
    @BindView(R.id.btn_uninstall_app_silent)
    Button btnUninstallAppSilent;
    @BindView(R.id.btn_launch_app)
    Button btnLaunchApp;
    @BindView(R.id.btn_get_app_details_settings)
    Button btnGetAppDetailsSettings;
    @BindView(R.id.tv_about_app)
    TextView tvAboutApp;

    private Context mContext;
    private String appPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        ButterKnife.bind(this);

        mContext=this;
        appPath = AppUtils.getAppPath(mContext);

        tvAboutApp.setText(AppUtils.getAppInfo(mContext).toString()
                + "\nisInstallWeiXin: " + AppUtils.isInstallApp(mContext, "com.tencent.mm")
                + "\nisAppRoot: " + AppUtils.isAppRoot()
                + "\nisAppDebug: " + AppUtils.isAppDebug(mContext)
                + "\nisWeiXinAppDebug: " + AppUtils.isAppDebug(mContext, "com.tencent.mm")
                + "\nAppSignatureSHA1: " + AppUtils.getAppSignatureSHA1(mContext)
                + "\nisAppForeground: " + AppUtils.isAppForeground(mContext)
                + "\nisWeiXinForeground: " + AppUtils.isAppForeground(mContext, "com.tencent.mm")
        );
    }

    @OnClick({R.id.btn_install_app, R.id.btn_install_app_silent, R.id.btn_uninstall_app, R.id.btn_uninstall_app_silent, R.id.btn_launch_app, R.id.btn_get_app_details_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_install_app:
                AppUtils.installApp(mContext, appPath);
                break;
            case R.id.btn_install_app_silent:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AppUtils.installAppSilent(mContext,appPath);
                    }
                }).start();
                break;
            case R.id.btn_uninstall_app:
                AppUtils.uninstallApp(mContext, getPackageName());
                break;
            case R.id.btn_uninstall_app_silent:
                AppUtils.uninstallAppSilent(mContext,getPackageName(), false);
                break;
            case R.id.btn_launch_app:
                AppUtils.launchApp(mContext,getPackageName());
                break;
            case R.id.btn_get_app_details_settings:
                AppUtils.getAppDetailsSettings(mContext);
                break;
        }
    }
}
