package lwq.com.utildemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lwq.com.utildemo.Utlis.SnackbarUtils;

public class SnackbarActivity extends AppCompatActivity {

    @BindView(R.id.btn_short_snackbar)
    Button btnShortSnackbar;
    @BindView(R.id.btn_short_snackbar_with_action)
    Button btnShortSnackbarWithAction;
    @BindView(R.id.btn_long_snackbar)
    Button btnLongSnackbar;
    @BindView(R.id.btn_long_snackbar_with_action)
    Button btnLongSnackbarWithAction;
    @BindView(R.id.btn_indefinite_snackbar)
    Button btnIndefiniteSnackbar;
    @BindView(R.id.btn_indefinite_snackbar_with_action)
    Button btnIndefiniteSnackbarWithAction;
    @BindView(R.id.btn_add_view)
    Button btnAddView;
    @BindView(R.id.btn_add_view_with_action)
    Button btnAddViewWithAction;
    @BindView(R.id.btn_cancel_snackbar)
    Button btnCancelSnackbar;
    private View snackBarRootView;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        ButterKnife.bind(this);
        mContext = this;
        snackBarRootView = findViewById(android.R.id.content);
    }

    @OnClick({R.id.btn_short_snackbar, R.id.btn_short_snackbar_with_action, R.id.btn_long_snackbar, R.id.btn_long_snackbar_with_action, R.id.btn_indefinite_snackbar, R.id.btn_indefinite_snackbar_with_action, R.id.btn_add_view, R.id.btn_add_view_with_action, R.id.btn_cancel_snackbar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_short_snackbar:
                SnackbarUtils.showShortSnackbar(snackBarRootView, "short snackbar", Color.YELLOW, Color.BLUE);
                break;
            case R.id.btn_short_snackbar_with_action:
                SnackbarUtils.showShortSnackbar(snackBarRootView, "short snackbar", Color.YELLOW, Color.BLUE,
                        "Short", Color.YELLOW, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(mContext, "Click Short", Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            case R.id.btn_long_snackbar:
                SnackbarUtils.showLongSnackbar(snackBarRootView, "long snackbar", Color.YELLOW, Color.GREEN);
                break;
            case R.id.btn_long_snackbar_with_action:
                SnackbarUtils.showLongSnackbar(snackBarRootView, "long snackbar", Color.YELLOW, Color.GREEN,
                        "Long", Color.YELLOW, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(mContext, "Click Long", Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            case R.id.btn_indefinite_snackbar:
                SnackbarUtils.showIndefiniteSnackbar(snackBarRootView, "Indefinite snackbar", Color.WHITE, Color.RED);
                break;
            case R.id.btn_indefinite_snackbar_with_action:
                SnackbarUtils.showIndefiniteSnackbar(snackBarRootView, "Indefinite snackbar", Color.WHITE, Color.RED,
                        "Indefinite", Color.YELLOW, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(mContext, "Click Indefinite", Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            case R.id.btn_add_view:
                SnackbarUtils.showShortSnackbar(snackBarRootView, "short snackbar", Color.WHITE, Color.BLUE);
                SnackbarUtils.addView(R.layout.snackbar_add, 0);
                break;
            case R.id.btn_add_view_with_action:
                SnackbarUtils.showLongSnackbar(snackBarRootView, "short snackbar", Color.WHITE, Color.BLUE,
                        "Short", Color.YELLOW, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(mContext, "Click Short", Toast.LENGTH_SHORT).show();
                            }
                        });
                SnackbarUtils.addView(R.layout.snackbar_add, 0);
                break;
            case R.id.btn_cancel_snackbar:
                SnackbarUtils.dismissSnackbar();
                break;
        }
    }
}
