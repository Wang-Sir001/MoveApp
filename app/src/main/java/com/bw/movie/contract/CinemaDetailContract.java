package com.bw.movie.contract;

import com.bw.movie.base.mvp.IBaseModel;
import com.bw.movie.base.mvp.IBaseView;
import com.bw.movie.model.entity.GuanzhuEntity;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.UserFollowMovieEntity;
import com.bw.movie.model.entity.detailEntity.CinemaDetailEntity;
import com.bw.movie.model.entity.detailEntity.CinemaPinglunEntity;
import com.bw.movie.model.entity.detailEntity.CommentsEntity;

import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * data:2020/4/2
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface CinemaDetailContract {
    interface IModel extends IBaseModel {
        void getCinemaDetailData(int userId,String sessionId,int cinemaId,CinemaDetailModelCallback cinemaDetailModelCallback);
        void getCinemaPinglunData(int userId,String sessionId,int cinemaId,int page,int count,CinemaDetailModelCallback cinemaDetailModelCallback);
        void getCinemaWitryPinglunData(int userId,String sessionId,int cinemaId,String commentContent,CinemaDetailModelCallback cinemaDetailModelCallback);
        void getFollowCinemaData(int userId, String sessionId, int cinemaId,CinemaDetailModelCallback cinemaDetailModelCallback);
        void getUnFollowCinemaData(int userId, String sessionId, int cinemaId,CinemaDetailModelCallback cinemaDetailModelCallback);
        void getUserFollowCinemaData(int userId, String sessionId, int page,int count,CinemaDetailModelCallback cinemaDetailModelCallback);

        interface CinemaDetailModelCallback{
            void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity);
            void cinemaDetailError(Throwable throwable);
            void cinemaPinglunSuccess(CinemaPinglunEntity cinemaPinglunEntity);
            void cinemaPinglunError(Throwable throwable);
            void cinemaWitryPinglunSuccess(CommentsEntity commentsEntity);
            void cinemaWitryPinglunError(Throwable throwable);
            void followCinemaSuccess(GuanzhuEntity guanzhuEntity);
            void folloeCinemaError(Throwable throwable);
            void unfollowCinemaSuccess(GuanzhuEntity guanzhuEntity);
            void unfolloeCinemaError(Throwable throwable);
            void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity);
            void userfollowCinemaError(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity);
        void cinemaDetailError(Throwable throwable);
        void cinemaPinglunSuccess(CinemaPinglunEntity cinemaPinglunEntity);
        void cinemaPinglunError(Throwable throwable);
        void cinemaWitryPinglunSuccess(CommentsEntity commentsEntity);
        void cinemaWitryPinglunError(Throwable throwable);
        void followCinemaSuccess(GuanzhuEntity guanzhuEntity);
        void folloeCinemaError(Throwable throwable);
        void unfollowCinemaSuccess(GuanzhuEntity guanzhuEntity);
        void unfolloeCinemaError(Throwable throwable);
        void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity);
        void userfollowCinemaError(Throwable throwable);
    }
    interface IPresenter{
        void getCinemaDetailData(int userId,String sessionId,int cinemaId);
        void getCinemaPinglunData(int userId,String sessionId,int cinemaId,int page,int count);
        void getCinemaWitryPinglunData(int userId,String sessionId,int cinemaId,String commentContent);
        void getFollowCinemaData(int userId, String sessionId, int cinemaId);
        void getUnFollowCinemaData(int userId, String sessionId, int cinemaId);
        void getUserFollowCinemaData(int userId, String sessionId, int page,int count);
    }
}
