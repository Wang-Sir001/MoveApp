package com.bw.movie.contract;

import com.bw.movie.base.mvp.IBaseModel;
import com.bw.movie.base.mvp.IBaseView;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.UserFollowMovieEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.myEntity.AllSysMshEntity;
import com.bw.movie.model.entity.myEntity.MyCinemaCommentEntity;
import com.bw.movie.model.entity.myEntity.MyMovieCommentEntity;
import com.bw.movie.model.entity.myEntity.MyxinxiEntity;
import com.bw.movie.model.entity.myEntity.UserReserveEntity;

import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * data:2020/4/10
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface MyContract {
    interface IModel extends IBaseModel {
        void getUserFollowMovieData(int userId, String sessionId, int page,int count,MyModelCallback myModelCallback);
        void getUserFollowCinemaData(int userId, String sessionId, int page,int count,MyModelCallback myModelCallback);
        void getUserReserveData(int userId, String sessionId,MyModelCallback myModelCallback);
        void getMyMovieCommentData(int userId, String sessionId, int page,int count,MyModelCallback myModelCallback);
        void getMyCinemaCommentData(int userId, String sessionId, String longitude,String latitude, int page, int count, MyModelCallback myModelCallback);
        void getfeedBackData(int userId,String sessionId,String content,MyModelCallback myModelCallback);
        void getallSysMsgData(int userId, String sessionId, int page,int count,MyModelCallback myModelCallback);
        void getchangeSysMsgData(int userId, String sessionId,int id,MyModelCallback myModelCallback);
        void getUserInfoData(int userId, String sessionId,MyModelCallback myModelCallback);


        interface MyModelCallback{
            void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity);
            void userfollowMovieError(Throwable throwable);
            void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity);
            void userfollowCinemaError(Throwable throwable);
            void UserReserveSuccess(UserReserveEntity userReserveEntity);
            void UserReserveError(Throwable throwable);
            void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity);
            void MyMovieCommentError(Throwable throwable);
            void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity);
            void MyCinemaCommentError(Throwable throwable);
            void feedBackSuccess(RegEntity regEntity);
            void feedBackError(Throwable throwable);
            void allSysMsgSuccess(AllSysMshEntity allSysMshEntity);
            void allSysMsgError(Throwable throwable);
            void changeSysMsgSuccess(RegEntity regEntity);
            void changeSysMsgError(Throwable throwable);
            void UserInfoSuccess(MyxinxiEntity myxinxiEntity);
            void UserInfoError(Throwable throwable);
        }
    }

    interface IView extends IBaseView {
        void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity);
        void userfollowMovieError(Throwable throwable);
        void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity);
        void userfollowCinemaError(Throwable throwable);
        void UserReserveSuccess(UserReserveEntity userReserveEntity);
        void UserReserveError(Throwable throwable);
        void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity);
        void MyMovieCommentError(Throwable throwable);
        void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity);
        void MyCinemaCommentError(Throwable throwable);
        void feedBackSuccess(RegEntity regEntity);
        void feedBackError(Throwable throwable);
        void allSysMsgSuccess(AllSysMshEntity allSysMshEntity);
        void allSysMsgError(Throwable throwable);
        void changeSysMsgSuccess(RegEntity regEntity);
        void changeSysMsgError(Throwable throwable);
        void UserInfoSuccess(MyxinxiEntity myxinxiEntity);
        void UserInfoError(Throwable throwable);
    }

    interface IPresenter{
        void getUserFollowMovieData(int userId, String sessionId, int page,int count);
        void getUserFollowCinemaData(int userId, String sessionId, int page,int count);
        void getUserReserveData(int userId, String sessionId);
        void getMyMovieCommentData(int userId, String sessionId, int page,int count);
        void getMyCinemaCommentData(int userId, String sessionId, String longitude,String latitude, int page, int count);
        void getfeedBackData(int userId,String sessionId,String content);
        void getallSysMsgData(int userId, String sessionId, int page,int count);
        void getchangeSysMsgData(int userId, String sessionId,int id);
        void getUserInfoData(int userId, String sessionId);
    }

}
