package com.bw.movie.util;

import android.util.Log;
import android.widget.Toast;

import com.bw.movie.app.App;

/**
 * author : Eaves
 * desc   : 功能描述
 * date   : 2019/12/27
 */
public class TUtils {

    public static void toastInfo(String str){

        Toast.makeText(App.mContext, str, Toast.LENGTH_SHORT).show();
    }

    public static void logInfo(String str){

        Log.e("MyMessage",str);
    }
}
