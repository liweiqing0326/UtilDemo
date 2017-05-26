package lwq.com.utildemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lwq.com.utildemo.Utlis.KeyboardUtils;

public class KeyboardActivity extends AppCompatActivity {

    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.btn_hide_soft_input)
    Button btnHideSoftInput;
    @BindView(R.id.btn_show_soft_input)
    Button btnShowSoftInput;
    @BindView(R.id.btn_toggle_soft_input)
    Button btnToggleSoftInput;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        ButterKnife.bind(this);

        mContext = this;
    }

    @OnClick({R.id.btn_hide_soft_input, R.id.btn_show_soft_input, R.id.btn_toggle_soft_input})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_hide_soft_input:
                KeyboardUtils.hideSoftInput((Activity) mContext);
                break;
            case R.id.btn_show_soft_input:
                KeyboardUtils.showSoftInput(mContext, (EditText) findViewById(R.id.et));
                break;
            case R.id.btn_toggle_soft_input:
                KeyboardUtils.toggleSoftInput(mContext);
                break;
        }
        Log.d("liweiqing", "" + isKeyboardShown(getWindow().getDecorView().findViewById(android.R.id.content)));
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }

    /**
     * 是否显示键盘
     *
     * @param rootView
     * @return
     */
    private boolean isKeyboardShown(View rootView) {
        final int softKeyboardHeight = 100;
        Rect frame = new Rect();
        rootView.getWindowVisibleDisplayFrame(frame);
        DisplayMetrics dm = rootView.getResources().getDisplayMetrics();
        int heightDiff = rootView.getBottom() - frame.bottom;
        Log.d("liweiqing","" + rootView.getBottom() + ", " + frame.bottom + ", " + heightDiff);
        return heightDiff > softKeyboardHeight * dm.density;
    }
}
