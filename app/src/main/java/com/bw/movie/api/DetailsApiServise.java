package com.bw.movie.api;

import com.bw.movie.model.adapter.DetailAdapter.BuyBean;
import com.bw.movie.model.adapter.DetailAdapter.PayBean;
import com.bw.movie.model.entity.GuanzhuEntity;
import com.bw.movie.model.entity.SoonMoiveEntity;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.UserFollowMovieEntity;
import com.bw.movie.model.entity.detailEntity.CinemaDetailEntity;
import com.bw.movie.model.entity.detailEntity.CinemaPinglunEntity;
import com.bw.movie.model.entity.detailEntity.CommentEntity;
import com.bw.movie.model.entity.detailEntity.CommentsEntity;
import com.bw.movie.model.entity.detailEntity.DetialEntity;
import com.bw.movie.model.entity.detailEntity.FindCinemasEntity;
import com.bw.movie.model.entity.detailEntity.FindDataEntity;
import com.bw.movie.model.entity.detailEntity.FindcinemasPriceEntity;
import com.bw.movie.model.entity.detailEntity.RegionCityEntity;
import com.bw.movie.model.entity.seat.ChooseActivityBean;
import com.bw.movie.model.entity.seat.SeatBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * data:2020/3/26
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface DetailsApiServise {

    @GET("movieApi/movie/v2/findMoviesDetail")
    Observable<DetialEntity> detail(@Header("userId") int userId,
                                    @Header("sessionId") String sessionId,
                                    @Query("movieId") int movieId);

    @GET("movieApi/movie/v2/findAllMovieComment")
    Observable<CommentEntity> comment(@Header("userId") int userId,
                                      @Header("sessionId") String sessionId,
                                      @Query("movieId") int movieId,
                                      @Query("page") int page,
                                      @Query("count") int count);

    @POST("movieApi/movie/v1/verify/movieComment")
    @FormUrlEncoded
    Observable<CommentsEntity> comments(@Header("userId") int userId,
                                        @Header("sessionId") String sessionId,
                                        @Field("movieId") int movieId,
                                        @Field("commentContent") String commentContent,
                                        @Field("score") double score);

    @GET("movieApi/cinema/v1/findCinemaInfo")
    Observable<CinemaDetailEntity> cinemaDetail(@Header("userId") int userId,
                                                @Header("sessionId") String sessionId,
                                                @Query("cinemaId") int cinemaId);

    @GET("movieApi/cinema/v1/findAllCinemaComment")
    Observable<CinemaPinglunEntity> cinemaPinglun(@Header("userId") int userId,
                                                  @Header("sessionId") String sessionId,
                                                  @Query("cinemaId") int cinemaId,
                                                  @Query("page") int page,
                                                  @Query("count") int count);

    @POST("movieApi/cinema/v1/verify/cinemaComment")
    @FormUrlEncoded
    Observable<CommentsEntity> cinemaWrityPinglun(@Header("userId") int userId,
                                                  @Header("sessionId") String sessionId,
                                                  @Field("cinemaId") int cinemaId,
                                                  @Field("commentContent") String commentContent);

    @GET("movieApi/tool/v2/findRegionList")
    Observable<RegionCityEntity> regionCity();

    @GET("movieApi/tool/v2/findDateList")
    Observable<FindDataEntity> findData();

    @GET("movieApi/movie/v2/findCinemasInfoByRegion")
    Observable<FindCinemasEntity> findcinemas(@Query("movieId") int movieId,
                                              @Query("regionId") int regionId,
                                              @Query("page") int page,
                                              @Query("count") int count);

    @GET("movieApi/movie/v2/findCinemasInfoByPrice")
    Observable<FindcinemasPriceEntity> findcinemasPrice(@Query("movieId") int movieId,
                                                        @Query("page") int page,
                                                        @Query("count") int count);

    @GET("movieApi/movie/v2/findMovieSchedule")
    Observable<ChooseActivityBean> choose(@Query("movieId") int movieId,
                                          @Query("cinemaId") int cinemaId);

    @GET("movieApi/movie/v2/findSeatInfo")
    Observable<SeatBean> seat(@Query("hallId") int hallId);

    @GET("movieApi/cinema/v2/findCinemaScheduleList")
    Observable<SoonMoiveEntity> soonMovie(@Query("cinemaId") int cinemaId,
                                          @Query("page") int page,
                                          @Query("count") int count);

    @GET("movieApi/movie/v1/verify/followMovie")
    Observable<GuanzhuEntity> followMovie(@Header("userId") int userId,
                                          @Header("sessionId") String sessionId,
                                          @Query("movieId") int movieId);

    @GET("movieApi/movie/v1/verify/cancelFollowMovie")
    Observable<GuanzhuEntity> unFollowMovie(@Header("userId") int userId,
                                               @Header("sessionId") String sessionId,
                                               @Query("movieId") int movieId);

    @GET("movieApi/cinema/v1/verify/followCinema")
    Observable<GuanzhuEntity> followCinema(@Header("userId") int userId,
                                                 @Header("sessionId") String sessionId,
                                                 @Query("cinemaId") int cinemaId);

    @GET("movieApi/cinema/v1/verify/cancelFollowCinema")
    Observable<GuanzhuEntity> unfollowCinema(@Header("userId") int userId,
                                                @Header("sessionId") String sessionId,
                                                @Query("cinemaId") int cinemaId);

    @GET("movieApi/user/v2/verify/findUserFollowMovieList")
    Observable<UserFollowMovieEntity> userfollowMovie(@Header("userId") int userId,
                                                      @Header("sessionId") String sessionId,
                                                      @Query("page") int page,
                                                      @Query("count") int count);

    @GET("movieApi/user/v2/verify/findUserFollowCinemaList")
    Observable<UserFollowCinemaEntity> userfollowCinema(@Header("userId") int userId,
                                                        @Header("sessionId") String sessionId,
                                                        @Query("page") int page,
                                                        @Query("count") int count);

    @POST("movieApi/movie/v2/verify/buyMovieTickets")
    @FormUrlEncoded
    Observable<BuyBean> buy(@Header("userId") int userId,
                            @Header("sessionId") String sessionId,
                            @Field("scheduleId") int scheduleId,
                            @Field("seat")String seat,
                            @Field("sign")String sign);

    @POST("movieApi/movie/v2/verify/pay")
    @FormUrlEncoded
    Observable<PayBean> pay(@Header("userId") int userId,
                            @Header("sessionId") String sessionId,
                            @Field("payType") int payType,
                            @Field("orderId")String orderId);


}
