package lwq.com.utildemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lwq.com.utildemo.Utlis.ImageUtils;
import lwq.com.utildemo.Utlis.SizeUtils;

public class ImageActivity extends AppCompatActivity {

    @BindView(R.id.iv_src)
    ImageView ivSrc;
    @BindView(R.id.iv_view2Bitmap)
    ImageView ivView2Bitmap;
    @BindView(R.id.iv_round)
    ImageView ivRound;
    @BindView(R.id.iv_round_corner)
    ImageView ivRoundCorner;
    @BindView(R.id.iv_fast_blur)
    ImageView ivFastBlur;
    @BindView(R.id.iv_render_script_blur)
    ImageView ivRenderScriptBlur;
    @BindView(R.id.iv_stack_blur)
    ImageView ivStackBlur;
    @BindView(R.id.iv_add_frame)
    ImageView ivAddFrame;
    @BindView(R.id.iv_add_reflection)
    ImageView ivAddReflection;
    @BindView(R.id.iv_add_text_watermark)
    ImageView ivAddTextWatermark;
    @BindView(R.id.iv_add_image_watermark)
    ImageView ivAddImageWatermark;
    @BindView(R.id.iv_gray)
    ImageView ivGray;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);

        mContext=this;

        Bitmap src = ImageUtils.getBitmap(getResources(), R.drawable.lena);
        Bitmap watermark = ImageUtils.getBitmap(getResources(), R.mipmap.ic_launcher);

        SizeUtils.forceGetViewSize(ivSrc, new SizeUtils.onGetSizeListener() {
            @Override
            public void onGetSize(View view) {
                ivView2Bitmap.setImageBitmap(ImageUtils.view2Bitmap(ivSrc));
            }
        });
        ivRound.setImageBitmap(ImageUtils.toRound(src));
        ivRoundCorner.setImageBitmap(ImageUtils.toRoundCorner(src, 60));
        ivFastBlur.setImageBitmap(ImageUtils.fastBlur(mContext,src, 0.1f, 5));
        ivRenderScriptBlur.setImageBitmap(ImageUtils.renderScriptBlur(this, src, 10));
        src = ImageUtils.getBitmap(getResources(), R.drawable.lena);
        ivStackBlur.setImageBitmap(ImageUtils.stackBlur(src, 10, false));
        ivAddFrame.setImageBitmap(ImageUtils.addFrame(src, 16, Color.GREEN));
        ivAddReflection.setImageBitmap(ImageUtils.addReflection(src, 80));
        ivAddTextWatermark.setImageBitmap(ImageUtils.addTextWatermark(src, "blankj", 40, 0x8800ff00, 0, 0));
        ivAddImageWatermark.setImageBitmap(ImageUtils.addImageWatermark(src, watermark, 0, 0, 0x88));
        ivGray.setImageBitmap(ImageUtils.toGray(src));
    }
}
