package lwq.com.utildemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lwq.com.utildemo.Utlis.ProcessUtils;

public class ProcessActivity extends AppCompatActivity {

    @BindView(R.id.btn_kill_all_background_processes)
    Button btnKillAllBackgroundProcesses;
    @BindView(R.id.tv_about_process)
    TextView tvAboutProcess;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        ButterKnife.bind(this);
        mContext = this;
        Set<String> set = ProcessUtils.getAllBackgroundProcesses(mContext);
        tvAboutProcess.setText("getForegroundProcessName: " + ProcessUtils.getForegroundProcessName(mContext)
                + "\n\ngetAllBackgroundProcesses: " + getSetItems(set)
                + "\nsize: " + set.size());
    }

    @OnClick(R.id.btn_kill_all_background_processes)
    public void onViewClicked() {
        Set<String> set = ProcessUtils.getAllBackgroundProcesses(mContext);
        Set<String> set1 = ProcessUtils.killAllBackgroundProcesses(mContext);
        tvAboutProcess.setText("getForegroundProcessName: " + ProcessUtils.getForegroundProcessName(mContext)
                + "\n\ngetAllBackgroundProcesses: " + getSetItems(set)
                + "\nsize: " + set.size()
                + "\n\nkillAllBackgroundProcesses: " + getSetItems(set1)
                + "\nsize: " + set1.size());
    }

    private String getSetItems(Set<String> set) {
        Iterator<String> iterator = set.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append("\n");
        }
        return sb.toString();
    }
}
