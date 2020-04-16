package com.bw.movie.contract;

import com.bw.movie.base.mvp.IBaseModel;
import com.bw.movie.base.mvp.IBaseView;
import com.bw.movie.model.adapter.DetailAdapter.BuyBean;
import com.bw.movie.model.adapter.DetailAdapter.PayBean;
import com.bw.movie.model.entity.GuanzhuEntity;
import com.bw.movie.model.entity.SoonMoiveEntity;
import com.bw.movie.model.entity.UserFollowMovieEntity;
import com.bw.movie.model.entity.detailEntity.CommentEntity;
import com.bw.movie.model.entity.detailEntity.CommentsEntity;
import com.bw.movie.model.entity.detailEntity.DetialEntity;
import com.bw.movie.model.entity.detailEntity.FindCinemasEntity;
import com.bw.movie.model.entity.detailEntity.FindDataEntity;
import com.bw.movie.model.entity.detailEntity.FindcinemasPriceEntity;
import com.bw.movie.model.entity.detailEntity.RegionCityEntity;
import com.bw.movie.model.entity.seat.ChooseActivityBean;
import com.bw.movie.model.entity.seat.SeatBean;

import retrofit2.http.Query;

/**
 * data:2020/3/26
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface DetailContract {
    interface IModel extends IBaseModel {
        void getDetailData(int userId, String sessionId, int movieId, DetailModelCallback detailModelCallback);
        void getCommentData(int userId, String sessionId, int movieId, int page, int count, DetailModelCallback detailModelCallback);
        void getCommentsData(int userId, String sessionId, int movieId, String commentContent, double score, DetailModelCallback detailModelCallback);
        void getRegionCityData(DetailModelCallback detailModelCallback);
        void getfindDataData(DetailModelCallback detailModelCallback);
        void getfindcinemasData(int movieId,int regionId,int page,int count,DetailModelCallback detailModelCallback);
        void getfindcinemasPriceData(int movieId,int page,int count,DetailModelCallback detailModelCallback);
        void getchooseData(int movieId,int cinemaId,DetailModelCallback detailModelCallback);
        void getseatData(int hallId,DetailModelCallback detailModelCallback);
        void getSoonMovieData(int cinemaId,int page,int count,DetailModelCallback detailModelCallback);
        void getFollowMovieData(int userId, String sessionId, int movieId,DetailModelCallback detailModelCallback);
        void getUnFollowMovieData(int userId, String sessionId, int movieId,DetailModelCallback detailModelCallback);
        void getUserFollowMovieData(int userId, String sessionId, int page,int count,DetailModelCallback detailModelCallback);
        void getBuyData(int userId, String sessionId,int scheduleId, String seat,String sign,DetailModelCallback detailModelCallback );
        void getPayData(int userId, String sessionId,int payType, String orderId,DetailModelCallback detailModelCallback );

        interface DetailModelCallback{
            void DetaileSuccess(DetialEntity detialEntity);
            void DetailError(Throwable throwable);
            void CommentSuccess(CommentEntity commentEntity);
            void CommentError(Throwable throwable);
            void CommentsSuccess(CommentsEntity commentsEntity);
            void CommentsError(Throwable throwable);
            void regionCitySuccess(RegionCityEntity regionCityEntity);
            void regionCity(Throwable throwable);
            void findDataSuccess(FindDataEntity findDataEntity);
            void findDataError(Throwable throwable);
            void findcinemasSuccess(FindCinemasEntity findCinemasEntity);
            void findcinemasError(Throwable throwable);
            void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity);
            void findcinemasPriceError(Throwable throwable);
            void chooseSuccess(ChooseActivityBean chooseActivityBean);
            void chooseError(Throwable throwable);
            void seatSuccess(SeatBean seatBean);
            void seatError(Throwable throwable);
            void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity);
            void soonMovieError(Throwable throwable);
            void followMovieSuccess(GuanzhuEntity guanzhuEntity);
            void folloeMovieError(Throwable throwable);
            void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity);
            void unfolloeMovieError(Throwable throwable);
            void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity);
            void userfollowMovieError(Throwable throwable);
            void BuySuccess(BuyBean buyBean);
            void BuyError(Throwable throwable);
            void PaySuccess(PayBean payBean);
            void PayError(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void DetaileSuccess(DetialEntity detialEntity);
        void DetailError(Throwable throwable);
        void CommentSuccess(CommentEntity commentEntity);
        void CommentError(Throwable throwable);
        void CommentsSuccess(CommentsEntity commentsEntity);
        void CommentsError(Throwable throwable);
        void regionCitySuccess(RegionCityEntity regionCityEntity);
        void regionCity(Throwable throwable);
        void findDataSuccess(FindDataEntity findDataEntity);
        void findDataError(Throwable throwable);
        void findcinemasSuccess(FindCinemasEntity findCinemasEntity);
        void findcinemasError(Throwable throwable);
        void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity);
        void findcinemasPriceError(Throwable throwable);
        void chooseSuccess(ChooseActivityBean chooseActivityBean);
        void chooseError(Throwable throwable);
        void seatSuccess(SeatBean seatBean);
        void seatError(Throwable throwable);
        void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity);
        void soonMovieError(Throwable throwable);
        void followMovieSuccess(GuanzhuEntity guanzhuEntity);
        void folloeMovieError(Throwable throwable);
        void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity);
        void unfolloeMovieError(Throwable throwable);
        void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity);
        void userfollowMovieError(Throwable throwable);
        void BuySuccess(BuyBean buyBean);
        void BuyError(Throwable throwable);
        void PaySuccess(PayBean payBean);
        void PayError(Throwable throwable);
    }
    interface IPresenter{
        void getDetailData(int userId, String sessionId, int movieId);
        void getCommentData(int userId, String sessionId, int movieId, int page, int count);
        void getCommentsData(int userId, String sessionId, int movieId, String commentContent, double score);
        void getRegionCityData();
        void getfindDataData();
        void getfindcinemasData(int movieId,int regionId,int page,int count);
        void getfindcinemasPriceData(int movieId,int page,int count);
        void getchooseData(int movieId,int cinemaId);
        void getseatData(int hallId);
        void getSoonMovieData(int cinemaId,int page,int count);
        void getFollowMovieData(int userId, String sessionId, int movieId);
        void getUnFollowMovieData(int userId, String sessionId, int movieId);
        void getUserFollowMovieData(int userId, String sessionId, int page,int count);
        void getBuyData(int userId, String sessionId,int scheduleId, String seat,String sign);
        void getPayData(int userId, String sessionId,int payType, String orderId);

    }
}
