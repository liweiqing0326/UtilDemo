package lwq.com.utildemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lwq.com.utildemo.Utlis.CleanUtils;

public class CleanActivity extends AppCompatActivity {

    @BindView(R.id.btn_clean_internal_cache)
    Button btnCleanInternalCache;
    @BindView(R.id.btn_clean_internal_files)
    Button btnCleanInternalFiles;
    @BindView(R.id.btn_clean_internal_databases)
    Button btnCleanInternalDatabases;
    @BindView(R.id.btn_clean_internal_sp)
    Button btnCleanInternalSp;
    @BindView(R.id.btn_clean_external_cache)
    Button btnCleanExternalCache;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);
        ButterKnife.bind(this);

        mContext = this;

        btnCleanInternalCache.setText(getCacheDir().getPath());
        btnCleanInternalFiles.setText(getFilesDir().getPath());
        btnCleanInternalDatabases.setText(getFilesDir().getParent() + File.separator + "databases");
        btnCleanInternalSp.setText(getFilesDir().getParent() + File.separator + "shared_prefs");
        btnCleanExternalCache.setText(getExternalCacheDir().getPath());
    }

    @OnClick({R.id.btn_clean_internal_cache, R.id.btn_clean_internal_files, R.id.btn_clean_internal_databases, R.id.btn_clean_internal_sp, R.id.btn_clean_external_cache})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_clean_internal_cache:
                Log.d("liweiqing", "cleanInternalCache" + CleanUtils.cleanInternalCache(mContext));
                break;
            case R.id.btn_clean_internal_files:
                Log.d("liweiqing", "cleanInternalFiles" + CleanUtils.cleanInternalFiles(mContext));
                break;
            case R.id.btn_clean_internal_databases:
                Log.d("liweiqing", "cleanInternalDbs" + CleanUtils.cleanInternalDbs(mContext));
                break;
            case R.id.btn_clean_internal_sp:
                Log.d("liweiqing", "cleanInternalSP" + CleanUtils.cleanInternalSP(mContext));
                break;
            case R.id.btn_clean_external_cache:
                Log.d("liweiqing", "cleanExternalCache" + CleanUtils.cleanExternalCache(mContext));
                break;
        }
    }
}
