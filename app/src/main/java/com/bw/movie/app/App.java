package com.bw.movie.app;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.liys.doubleclicklibrary.ViewDoubleHelper;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class App extends Application {
    //全局上下文
    private static App sContext;
    // APP_ID 替换为你的应用从官方网站申请到的合法appID
    public static final String APP_ID = "wxb3852e6a6b7d9516";

    // IWXAPI 是第三方app和微信通信的openApi接口
    public static IWXAPI api;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        ViewDoubleHelper.init(this); //默认时间：1秒
        Fresco.initialize(this);

        // 通过WXAPIFactory工厂，获取IWXAPI的实例
            api = WXAPIFactory.createWXAPI(this, APP_ID, true);

            // 将应用的appId注册到微信
            api.registerApp(APP_ID);

            //建议动态监听微信启动广播进行注册到微信
            registerReceiver(new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

                    // 将该app注册到微信
                    api.registerApp(sContext.APP_ID);
                }
            }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
        }
    public static App getAppContext() {
        return sContext;
    }

}
