package lwq.com.utildemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lwq.com.utildemo.Utlis.HandlerUtils;

public class HandlerActivity extends AppCompatActivity {

    @BindView(R.id.btn_send_msg_after_3s)
    Button btnSendMsgAfter3s;
    @BindView(R.id.tv_about_handler)
    TextView tvAboutHandler;
    private HandlerUtils.HandlerHolder handlerHolder;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);
        mContext = this;
        handlerHolder = new HandlerUtils.HandlerHolder(new HandlerUtils.OnReceiveMessageListener() {
            @Override
            public void handlerMessage(Message msg) {
                tvAboutHandler.setText("get_msg_after_3s");
            }
        });
    }

    @OnClick(R.id.btn_send_msg_after_3s)
    public void onViewClicked() {
        handlerHolder.sendEmptyMessageDelayed(0, 3000);
    }
}
