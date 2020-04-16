package com.bw.movie.util;

import android.widget.ImageView;

import com.bawei.mymovie.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.api.API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * data:2020/3/16
 * author:王江伟(DJ慢羊羊)
 * function: 网络工具类
 */
public class NetUtils {
    private static NetUtils sNetUtils;
    private final Retrofit mRetrofit;

    private NetUtils() {
        //日志拦截器
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        mRetrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static NetUtils getInstance() {
        //双重检验锁
        if (sNetUtils == null) {
            synchronized (NetUtils.class){
                if (sNetUtils == null) {
                    sNetUtils = new NetUtils();
                }
            }
        }
        return sNetUtils;
    }

    public <T>T getClear(Class<T> tClass){
        return mRetrofit.create(tClass);
    }
    public void getpho(String phoUrl, ImageView imageView){
        Glide.with(imageView).load(phoUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
//                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(10)))
                .into(imageView);
    }
}
