package com.bw.movie.api;

import com.bw.movie.model.entity.dengluEntity.LogEntity;
import com.bw.movie.model.entity.dengluEntity.WeixinEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dengluEntity.YzmEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * data:2020/3/20
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface UserApiServise {
    @POST("movieApi/user/v2/sendOutEmailCode")
    @FormUrlEncoded
    Observable<YzmEntity> yzm(@Field("email") String email);

    @POST("movieApi/user/v2/register")
    @FormUrlEncoded
    Observable<RegEntity> reg(@Field("nickName") String nickName,
                              @Field("pwd") String pwd,
                              @Field("email") String email,
                              @Field("code") String code);

    @POST("movieApi/user/v2/login")
    @FormUrlEncoded
    Observable<LogEntity> log(@Field("email") String email,
                              @Field("pwd") String pwd);

    @POST("movieApi/user/v1/weChatBindingLogin")
    @FormUrlEncoded
    Observable<WeixinEntity> weixin(@Field("code") String code);

}
