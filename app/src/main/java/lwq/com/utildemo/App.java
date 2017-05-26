package lwq.com.utildemo;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

import lwq.com.utildemo.Utlis.CrashUtils;

public class App extends Application {
    private Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        // 内存泄露检查工具
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        appContext = this;
        CrashUtils.getInstance()
                .init(appContext);
    }
}
