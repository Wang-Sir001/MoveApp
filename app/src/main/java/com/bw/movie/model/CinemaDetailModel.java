package com.bw.movie.model;

import com.bw.movie.api.DetailsApiServise;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.model.entity.GuanzhuEntity;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.detailEntity.CinemaDetailEntity;
import com.bw.movie.model.entity.detailEntity.CinemaPinglunEntity;
import com.bw.movie.model.entity.detailEntity.CommentsEntity;
import com.bw.movie.util.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * data:2020/4/2
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class CinemaDetailModel implements CinemaDetailContract.IModel {
    @Override
    public void getCinemaDetailData(int userId, String sessionId, int cinemaId, CinemaDetailModelCallback cinemaDetailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .cinemaDetail(userId,sessionId,cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaDetailEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaDetailEntity cinemaDetailEntity) {
                        cinemaDetailModelCallback.cinemaDetailSuccess(cinemaDetailEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cinemaDetailModelCallback.cinemaDetailError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getCinemaPinglunData(int userId, String sessionId, int cinemaId, int page, int count, CinemaDetailModelCallback cinemaDetailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .cinemaPinglun(userId,sessionId,cinemaId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaPinglunEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaPinglunEntity cinemaPinglunEntity) {
                        cinemaDetailModelCallback.cinemaPinglunSuccess(cinemaPinglunEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cinemaDetailModelCallback.cinemaPinglunError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getCinemaWitryPinglunData(int userId, String sessionId, int cinemaId, String commentContent, CinemaDetailModelCallback cinemaDetailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .cinemaWrityPinglun(userId,sessionId,cinemaId,commentContent)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentsEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommentsEntity commentsEntity) {
                        cinemaDetailModelCallback.cinemaWitryPinglunSuccess(commentsEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cinemaDetailModelCallback.cinemaWitryPinglunError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getFollowCinemaData(int userId, String sessionId, int cinemaId, CinemaDetailModelCallback cinemaDetailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .followCinema(userId,sessionId,cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GuanzhuEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GuanzhuEntity guanzhuEntity) {
                        cinemaDetailModelCallback.followCinemaSuccess(guanzhuEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cinemaDetailModelCallback.folloeCinemaError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUnFollowCinemaData(int userId, String sessionId, int cinemaId, CinemaDetailModelCallback cinemaDetailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .unfollowCinema(userId,sessionId,cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GuanzhuEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GuanzhuEntity guanzhuEntity) {
                        cinemaDetailModelCallback.unfollowCinemaSuccess(guanzhuEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cinemaDetailModelCallback.unfolloeCinemaError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUserFollowCinemaData(int userId, String sessionId, int page, int count, CinemaDetailModelCallback cinemaDetailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .userfollowCinema(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserFollowCinemaEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserFollowCinemaEntity userFollowCinemaEntity) {
                        cinemaDetailModelCallback.userfollowCinemaSuccess(userFollowCinemaEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cinemaDetailModelCallback.userfollowCinemaError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
