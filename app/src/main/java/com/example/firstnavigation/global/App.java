package com.example.firstnavigation.global;

import android.app.Application;

import com.example.firstnavigation.typeface.PreferencesHelper;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public class App extends Application {
    private PreferencesHelper ph;
    private static App sApp;

    // 单例模式获取唯一的Application实例
    public static Application getInstance() {
        return sApp.getApplication();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        ph = new PreferencesHelper(getApplication(), "test");
        UMConfigure.setLogEnabled(true);
        UMConfigure.init(this, "5b248738a40fa37c010000a3", "MyYouMeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

        CrashReport.initCrashReport(getApplicationContext(), "f0bbfccb2a", false);

        /**
         注意: 即使您
         已经在AndroidManifest.xml中配置过appkey和channel值，也需要在App代码中调用初始化接口
         （如需要使用AndroidManifest.xml中配置好的appkey和channel值，UMConfigure.init调用中appkey和channel参数请置为null）。
         */
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE,"");

    }

    public static App getApp() {
        return sApp;
    }

    private Application getApplication(){
        return  this;
    }

    public PreferencesHelper getPreferencesHelper() {
        return ph;
    }

    /**
     *
     * @return 获取字体缩放比例
     */
    public float getFontScale(){
        int currentIndex= ph.getValueInt("currentIndex",1);
        return 1+currentIndex*0.1f;
    }
}
