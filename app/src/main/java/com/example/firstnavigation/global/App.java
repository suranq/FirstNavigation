package com.example.firstnavigation.global;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public class App extends Application {

    private static App sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;

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
//        UMConfigure.init(getApp(), "5c43ddddf1f556a9e4000570", String channel, MobclickAgent.EScenarioType.E_UM_NORMAL, String pushSecret);

    }

    public static App getApp() {
        return sApp;
    }
}
