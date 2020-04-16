package com.bw.movie.api;

import com.bw.movie.model.entity.yingyuanEntity.FujinEntity;
import com.bw.movie.model.entity.yingyuanEntity.TuijianEntity;
import com.bw.movie.model.entity.yingyuanEntity.TwoItemEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * data:2020/3/24
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface YingyuanApiServise {
    @GET("movieApi/cinema/v1/findNearbyCinemas")
    Observable<FujinEntity> fujin(@Header("userId") int userId, @Header("sessionId") String sessionId,
                                  @Query("longitude") String longitude, @Query("latitude") String latitude,
                                  @Query("page") int page, @Query("count") int count);

    @GET("movieApi/cinema/v1/findRecommendCinemas")
    Observable<TuijianEntity> tuijian(@Header("userId") int userId, @Header("sessionId") String sessionId,
                                      @Query("page") int page, @Query("count") int count);

    @GET("movieApi/tool/v2/findRegionList")
    Observable<TwoItemEntity> twoItem();


}
