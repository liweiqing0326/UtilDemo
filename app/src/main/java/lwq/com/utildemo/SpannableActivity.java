package lwq.com.utildemo;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import lwq.com.utildemo.Utlis.SpannableStringUtils;

public class SpannableActivity extends AppCompatActivity {

    @BindView(R.id.tv_about_spannable)
    TextView tvAboutSpannable;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable);
        ButterKnife.bind(this);

        mContext=this;
        // 响应点击事件的话必须设置以下属性
        tvAboutSpannable.setMovementMethod(LinkMovementMethod.getInstance());
        tvAboutSpannable.setText(SpannableStringUtils
                .getBuilder("测试SpannableStringUtils\n")
                .setBold().setForegroundColor(Color.YELLOW).setBackgroundColor(Color.GRAY).setAlign(Layout.Alignment.ALIGN_CENTER)
                .append(mContext,"测试")
                .append(mContext,"前景色").setForegroundColor(Color.GREEN)
                .append(mContext,"背景色\n").setBackgroundColor(Color.RED)
                .append(mContext,"测试首行缩进\n").setLeadingMargin(30, 50)
                .append(mContext,"测试引用\n").setQuoteColor(Color.YELLOW)
                .append(mContext,"测试列表项\n").setBullet(30, Color.YELLOW)
                .append(mContext,"测试")
                .append(mContext,"2倍字体\n").setProportion(2)
                .append(mContext,"横向2倍字体\n").setXProportion(2)
                .append(mContext,"测试")
                .append(mContext,"删除线").setStrikethrough()
                .append(mContext,"下划线\n").setUnderline()
                .append(mContext,"测试")
                .append(mContext,"上标").setSuperscript()
                .append(mContext,"下标\n").setSubscript()
                .append(mContext,"测试")
                .append(mContext,"粗体").setBold()
                .append(mContext,"斜体").setItalic()
                .append(mContext,"粗斜体\n").setBoldItalic()
                .append(mContext,"monospace font\n").setFontFamily("monospace")
                .append(mContext,"serif font\n").setFontFamily("serif")
                .append(mContext,"sans-serif font\n").setFontFamily("sans-serif")
                .append(mContext,"测试正常对齐\n").setAlign(Layout.Alignment.ALIGN_NORMAL)
                .append(mContext,"测试居中对齐\n").setAlign(Layout.Alignment.ALIGN_CENTER)
                .append(mContext,"测试相反对齐\n").setAlign(Layout.Alignment.ALIGN_OPPOSITE)
                .append(mContext,"测试")
                .append(mContext,"图片\n").setResourceId(R.mipmap.ic_launcher)
                .append(mContext,"测试")
                .append(mContext,"点击事件\n").setClickSpan(clickableSpan)
                .append(mContext,"测试")
                .append(mContext,"Url\n").setUrl("https://github.com/Blankj/AndroidUtilCode")
                .append(mContext,"测试")
                .append(mContext,"模糊字体\n").setBlur(3, BlurMaskFilter.Blur.NORMAL)
                .create(mContext)
        );
    }

    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            Toast.makeText(mContext,"事件触发了",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Color.BLUE);
            ds.setUnderlineText(false);
        }
    };
}
