package com.bw.movie.app;

import android.app.Application;
import android.content.Context;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * data:2020/3/28
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class App extends Application {

    public static Context mContext;
    public static IWXAPI sIWXAPI;

    public static Context getmContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        registToWX();

    }

    private void registToWX() {
        //AppConst.WEIXIN.APP_ID是指你应用在微信开放平台上的AppID，记得替换。
        sIWXAPI = WXAPIFactory.createWXAPI(this, "wxb3852e6a6b7d9516", false);
        // 将该app注册到微信
        sIWXAPI.registerApp("wxb3852e6a6b7d9516");
    }
}
