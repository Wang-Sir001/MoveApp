package com.bw.movie.api;

import com.bw.movie.model.entity.CityBean;
import com.bw.movie.model.entity.XBannerEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.JjsyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.RmdyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.ZzsyEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface HomeApiServise {
    @GET("movieApi/movie/v2/findReleaseMovieList")
    Observable<ZzsyEntity> zzsy(@Query("page") int page, @Query("count") int count);

    @GET("movieApi/movie/v2/findComingSoonMovieList")
    Observable<JjsyEntity> jjsy(@Query("page") int page, @Query("count") int count);

    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<RmdyEntity> rmdy(@Query("page") int page, @Query("count") int count);

    @GET("movieApi/tool/v2/banner")
    Observable<XBannerEntity> xBanners();
//    location,output,key

    @GET("http://api.map.baidu.com/geocoder?")
    Observable<CityBean> city(@Query("location") String location,
                              @Query("output")String output,
                              @Query("key")String key
                              );

    @POST("movieApi/movie/v2/verify/reserve")
    @FormUrlEncoded
    Observable<RegEntity> reserve(@Header("userId") int userId,
                                  @Header("sessionId") String sessionId,
                                  @Field("movieId") int movieId);
}
