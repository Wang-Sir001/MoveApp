package com.bw.movie.presenter;

import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.model.CinemaDetailModel;
import com.bw.movie.model.entity.GuanzhuEntity;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.detailEntity.CinemaDetailEntity;
import com.bw.movie.model.entity.detailEntity.CinemaPinglunEntity;
import com.bw.movie.model.entity.detailEntity.CommentsEntity;

/**
 * data:2020/4/2
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class CinemaDetailPresenter extends BasePresenter<CinemaDetailModel, CinemaDetailContract.IView> implements CinemaDetailContract.IPresenter {
    @Override
    protected CinemaDetailModel initModel() {
        return new CinemaDetailModel();
    }

    @Override
    public void getCinemaDetailData(int userId, String sessionId, int cinemaId) {
        model.getCinemaDetailData(userId, sessionId, cinemaId, new CinemaDetailContract.IModel.CinemaDetailModelCallback() {
            @Override
            public void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity) {
                getView().cinemaDetailSuccess(cinemaDetailEntity);
            }

            @Override
            public void cinemaDetailError(Throwable throwable) {
                getView().cinemaDetailError(throwable);
            }

            @Override
            public void cinemaPinglunSuccess(CinemaPinglunEntity cinemaPinglunEntity) {

            }

            @Override
            public void cinemaPinglunError(Throwable throwable) {

            }

            @Override
            public void cinemaWitryPinglunSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void cinemaWitryPinglunError(Throwable throwable) {

            }

            @Override
            public void followCinemaSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeCinemaError(Throwable throwable) {

            }

            @Override
            public void unfollowCinemaSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeCinemaError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getCinemaPinglunData(int userId, String sessionId, int cinemaId, int page, int count) {
        model.getCinemaPinglunData(userId, sessionId, cinemaId, page, count, new CinemaDetailContract.IModel.CinemaDetailModelCallback() {
            @Override
            public void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity) {

            }

            @Override
            public void cinemaDetailError(Throwable throwable) {

            }

            @Override
            public void cinemaPinglunSuccess(CinemaPinglunEntity cinemaPinglunEntity) {
                getView().cinemaPinglunSuccess(cinemaPinglunEntity);
            }

            @Override
            public void cinemaPinglunError(Throwable throwable) {
                getView().cinemaPinglunError(throwable);
            }

            @Override
            public void cinemaWitryPinglunSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void cinemaWitryPinglunError(Throwable throwable) {

            }

            @Override
            public void followCinemaSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeCinemaError(Throwable throwable) {

            }

            @Override
            public void unfollowCinemaSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeCinemaError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }
        });
    }


    @Override
    public void getCinemaWitryPinglunData(int userId, String sessionId, int cinemaId, String commentContent) {
        model.getCinemaWitryPinglunData(userId, sessionId, cinemaId, commentContent, new CinemaDetailContract.IModel.CinemaDetailModelCallback() {
            @Override
            public void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity) {

            }

            @Override
            public void cinemaDetailError(Throwable throwable) {

            }

            @Override
            public void cinemaPinglunSuccess(CinemaPinglunEntity cinemaPinglunEntity) {

            }

            @Override
            public void cinemaPinglunError(Throwable throwable) {

            }

            @Override
            public void cinemaWitryPinglunSuccess(CommentsEntity commentsEntity) {
                getView().cinemaWitryPinglunSuccess(commentsEntity);
            }

            @Override
            public void cinemaWitryPinglunError(Throwable throwable) {
                getView().cinemaWitryPinglunError(throwable);
            }

            @Override
            public void followCinemaSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeCinemaError(Throwable throwable) {

            }

            @Override
            public void unfollowCinemaSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeCinemaError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getFollowCinemaData(int userId, String sessionId, int cinemaId) {
        model.getFollowCinemaData(userId, sessionId, cinemaId, new CinemaDetailContract.IModel.CinemaDetailModelCallback() {
            @Override
            public void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity) {

            }

            @Override
            public void cinemaDetailError(Throwable throwable) {

            }

            @Override
            public void cinemaPinglunSuccess(CinemaPinglunEntity cinemaPinglunEntity) {

            }

            @Override
            public void cinemaPinglunError(Throwable throwable) {

            }

            @Override
            public void cinemaWitryPinglunSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void cinemaWitryPinglunError(Throwable throwable) {

            }

            @Override
            public void followCinemaSuccess(GuanzhuEntity guanzhuEntity) {
                getView().followCinemaSuccess(guanzhuEntity);
            }

            @Override
            public void folloeCinemaError(Throwable throwable) {
                getView().folloeCinemaError(throwable);
            }

            @Override
            public void unfollowCinemaSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeCinemaError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getUnFollowCinemaData(int userId, String sessionId, int cinemaId) {
        model.getUnFollowCinemaData(userId, sessionId, cinemaId, new CinemaDetailContract.IModel.CinemaDetailModelCallback() {
            @Override
            public void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity) {

            }

            @Override
            public void cinemaDetailError(Throwable throwable) {

            }

            @Override
            public void cinemaPinglunSuccess(CinemaPinglunEntity cinemaPinglunEntity) {

            }

            @Override
            public void cinemaPinglunError(Throwable throwable) {

            }

            @Override
            public void cinemaWitryPinglunSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void cinemaWitryPinglunError(Throwable throwable) {

            }

            @Override
            public void followCinemaSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeCinemaError(Throwable throwable) {

            }

            @Override
            public void unfollowCinemaSuccess(GuanzhuEntity guanzhuEntity) {
                getView().unfollowCinemaSuccess(guanzhuEntity);
            }

            @Override
            public void unfolloeCinemaError(Throwable throwable) {
                getView().unfolloeCinemaError(throwable);
            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getUserFollowCinemaData(int userId, String sessionId, int page, int count) {
        model.getUserFollowCinemaData(userId, sessionId, page, count, new CinemaDetailContract.IModel.CinemaDetailModelCallback() {
            @Override
            public void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity) {

            }

            @Override
            public void cinemaDetailError(Throwable throwable) {

            }

            @Override
            public void cinemaPinglunSuccess(CinemaPinglunEntity cinemaPinglunEntity) {

            }

            @Override
            public void cinemaPinglunError(Throwable throwable) {

            }

            @Override
            public void cinemaWitryPinglunSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void cinemaWitryPinglunError(Throwable throwable) {

            }

            @Override
            public void followCinemaSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeCinemaError(Throwable throwable) {

            }

            @Override
            public void unfollowCinemaSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeCinemaError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {
                getView().userfollowCinemaSuccess(userFollowCinemaEntity);
            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {
                getView().userfollowCinemaError(throwable);
            }
        });
    }
}
