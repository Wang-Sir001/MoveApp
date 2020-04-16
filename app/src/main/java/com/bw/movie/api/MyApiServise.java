package com.bw.movie.api;

import com.bw.movie.model.entity.UserFollowMovieEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.myEntity.AllSysMshEntity;
import com.bw.movie.model.entity.myEntity.MyCinemaCommentEntity;
import com.bw.movie.model.entity.myEntity.MyMovieCommentEntity;
import com.bw.movie.model.entity.myEntity.MyxinxiEntity;
import com.bw.movie.model.entity.myEntity.UserBuyTicketEntity;
import com.bw.movie.model.entity.myEntity.UserReserveEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * data:2020/4/10
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface MyApiServise {

    //用户预约
    @GET("movieApi/user/v2/verify/findUserReserve")
    Observable<UserReserveEntity> UserReserve(@Header("userId") int userId,
                                              @Header("sessionId") String sessionId);

    //电影评论列表
    @GET("movieApi/user/v2/verify/findMyMovieCommentList")
    Observable<MyMovieCommentEntity> MyMovieComment(@Header("userId") int userId,
                                                    @Header("sessionId") String sessionId,
                                                    @Query("page") int page,
                                                    @Query("count") int count);

    //影院评论列表
    @GET("movieApi/user/v2/verify/findMyCinemaCommentList")
    Observable<MyCinemaCommentEntity> MyCinemaComment(@Header("userId") int userId,
                                                      @Header("sessionId") String sessionId,
                                                      @Query("longitude") String longitude,
                                                      @Query("latitude") String latitude,
                                                      @Query("page") int page,
                                                      @Query("count") int count);

    //反馈
    @POST("movieApi/tool/v1/verify/recordFeedBack")
    @FormUrlEncoded
    Observable<RegEntity> feedBack(@Header("userId") int userId,
                                   @Header("sessionId") String sessionId,
                                   @Field("content") String content);

    //系统息息
    @GET("movieApi/tool/v1/verify/findAllSysMsgList")
    Observable<AllSysMshEntity> allSysMsg(@Header("userId") int userId,
                                          @Header("sessionId") String sessionId,
                                          @Query("page") int page,
                                          @Query("count") int count);

    //改变系统息息
    @GET("movieApi/tool/v1/verify/changeSysMsgStatus")
    Observable<RegEntity> changeSysMsg(@Header("userId") int userId,
                                          @Header("sessionId") String sessionId,
                                          @Query("id") int id);

    //个人信息
    @GET("movieApi/user/v1/verify/getUserInfoByUserId")
    Observable<MyxinxiEntity> UserInfo(@Header("userId") int userId,
                                       @Header("sessionId") String sessionId);

    //购票记录
    @GET("movieApi/user/v2/verify/findUserBuyTicketRecord")
    Observable<UserBuyTicketEntity> UserBuyTicket(@Header("userId") int userId,
                                                  @Header("sessionId") String sessionId,
                                                  @Query("page") int page,
                                                  @Query("count") int count,
                                                  @Query("status") int status);
}
