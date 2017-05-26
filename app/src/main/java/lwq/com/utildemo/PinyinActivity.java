package lwq.com.utildemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lwq.com.utildemo.Utlis.PinyinUtils;

public class PinyinActivity extends AppCompatActivity {

    @BindView(R.id.tv_about_pinyin)
    TextView tvAboutPinyin;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinyin);
        ButterKnife.bind(this);

        mContext=this;
        tvAboutPinyin.setText("测试拼音工具类"
                + "\n转拼音: " + PinyinUtils.ccs2Pinyin("测试拼音工具类", " ")
                + "\n获取首字母: " + PinyinUtils.getPinyinFirstLetters("测试拼音工具类", " ")
                + "\n澹台: " + PinyinUtils.getSurnamePinyin("澹台"));
    }
}
