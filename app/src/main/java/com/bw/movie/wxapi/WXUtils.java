package com.bw.movie.wxapi;

import android.content.Context;

import com.bw.movie.app.App;


/**
 * date:2020/3/19 0019
 * author:胡锦涛(Administrator)
 * function:微信工具类
 */
public class WXUtils {
    //判断是否安装过微信
    public static boolean success(Context context) {
        if (App.sIWXAPI.isWXAppInstalled()) {
            return true;
        } else {
            return false;
        }
    }
}
