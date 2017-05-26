package lwq.com.utildemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.btn7)
    Button btn7;
    @BindView(R.id.btn8)
    Button btn8;
    @BindView(R.id.btn9)
    Button btn9;
    @BindView(R.id.btn10)
    Button btn10;
    @BindView(R.id.btn11)
    Button btn11;
    @BindView(R.id.btn12)
    Button btn12;
    @BindView(R.id.btn13)
    Button btn13;
    @BindView(R.id.btn14)
    Button btn14;
    @BindView(R.id.btn15)
    Button btn15;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContext=this;
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10, R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(mContext,AppActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(mContext,CleanActivity.class));
                break;
            case R.id.btn3:
                int err = 1 / 0;
                break;
            case R.id.btn4:
                startActivity(new Intent(mContext,DeviceActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(mContext,HandlerActivity.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(mContext,ImageActivity.class));
                break;
            case R.id.btn7:
                startActivity(new Intent(mContext,KeyboardActivity.class));
                break;
            case R.id.btn8:
                startActivity(new Intent(mContext,LocationActivity.class));
                break;
            case R.id.btn9:
                startActivity(new Intent(mContext,NetworkActivity.class));
                break;
            case R.id.btn10:
                startActivity(new Intent(mContext,PhoneActivity.class));
                break;
            case R.id.btn11:
                startActivity(new Intent(mContext,PinyinActivity.class));
                break;
            case R.id.btn12:
                startActivity(new Intent(mContext,ProcessActivity.class));
                break;
            case R.id.btn13:
                startActivity(new Intent(mContext,SDCardActivity.class));
                break;
            case R.id.btn14:
                startActivity(new Intent(mContext,SnackbarActivity.class));
                break;
            case R.id.btn15:
                startActivity(new Intent(mContext,SpannableActivity.class));
                break;
        }
    }
}
