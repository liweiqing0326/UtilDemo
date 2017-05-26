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
import lwq.com.utildemo.Utlis.PhoneUtils;

public class PhoneActivity extends AppCompatActivity {

    @BindView(R.id.btn_dial)
    Button btnDial;
    @BindView(R.id.btn_call)
    Button btnCall;
    @BindView(R.id.btn_send_sms)
    Button btnSendSms;
    @BindView(R.id.btn_send_sms_silent)
    Button btnSendSmsSilent;
    @BindView(R.id.tv_about_phone)
    TextView tvAboutPhone;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        ButterKnife.bind(this);

        mContext = this;
        tvAboutPhone.setText("isPhone: " + PhoneUtils.isPhone(mContext)
                + "\ngetIMEI: " + PhoneUtils.getIMEI(mContext)
                + "\ngetIMSI: " + PhoneUtils.getIMSI(mContext)
                + "\ngetPhoneType: " + PhoneUtils.getPhoneType(mContext)
                + "\nisSimCardReady: " + PhoneUtils.isSimCardReady(mContext)
                + "\ngetSimOperatorName: " + PhoneUtils.getSimOperatorName(mContext)
                + "\ngetSimOperatorByMnc: " + PhoneUtils.getSimOperatorByMnc(mContext)
                + "\n获取手机状态信息: " + PhoneUtils.getPhoneStatus(mContext)
        );
    }

    @OnClick({R.id.btn_dial, R.id.btn_call, R.id.btn_send_sms, R.id.btn_send_sms_silent})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_dial:
                PhoneUtils.dial(mContext, "10000");
                break;
            case R.id.btn_call:
                PhoneUtils.call(mContext, "10000");
                break;
            case R.id.btn_send_sms:
                PhoneUtils.sendSms(mContext, "10000", "test");
                break;
            case R.id.btn_send_sms_silent:
                PhoneUtils.sendSmsSilent(mContext, "10000", "test");
                break;
        }
    }
}
