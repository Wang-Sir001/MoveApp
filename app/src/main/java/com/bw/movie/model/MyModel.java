package com.bw.movie.model;

import com.bawei.mymovie.R;
import com.bw.movie.api.DetailsApiServise;
import com.bw.movie.api.MyApiServise;
import com.bw.movie.contract.MyContract;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.UserFollowMovieEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.myEntity.AllSysMshEntity;
import com.bw.movie.model.entity.myEntity.MyCinemaCommentEntity;
import com.bw.movie.model.entity.myEntity.MyMovieCommentEntity;
import com.bw.movie.model.entity.myEntity.MyxinxiEntity;
import com.bw.movie.model.entity.myEntity.UserReserveEntity;
import com.bw.movie.util.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * data:2020/4/10
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class MyModel implements MyContract.IModel {
    @Override
    public void getUserFollowMovieData(int userId, String sessionId, int page, int count, MyModelCallback myModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .userfollowMovie(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserFollowMovieEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserFollowMovieEntity userFollowMovieEntity) {
                        myModelCallback.userfollowMovieSuccess(userFollowMovieEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myModelCallback.userfollowMovieError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUserFollowCinemaData(int userId, String sessionId, int page, int count, MyModelCallback myModelCallback) {
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
                        myModelCallback.userfollowCinemaSuccess(userFollowCinemaEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myModelCallback.userfollowCinemaError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUserReserveData(int userId, String sessionId, MyModelCallback myModelCallback) {
        NetUtils.getInstance().getClear(MyApiServise.class)
                .UserReserve(userId,sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserReserveEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserReserveEntity userReserveEntity) {
                        myModelCallback.UserReserveSuccess(userReserveEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myModelCallback.UserReserveError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMyMovieCommentData(int userId, String sessionId, int page, int count, MyModelCallback myModelCallback) {
        NetUtils.getInstance().getClear(MyApiServise.class)
                .MyMovieComment(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyMovieCommentEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyMovieCommentEntity myMovieCommentEntity) {
                        myModelCallback.MyMovieCommentSuccess(myMovieCommentEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myModelCallback.MyMovieCommentError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMyCinemaCommentData(int userId, String sessionId, String longitude, String latitude, int page, int count, MyModelCallback myModelCallback) {
        NetUtils.getInstance().getClear(MyApiServise.class)
                .MyCinemaComment(userId,sessionId,longitude,latitude,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyCinemaCommentEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyCinemaCommentEntity myCinemaCommentEntity) {
                        myModelCallback.MyCinemaCommentSuccess(myCinemaCommentEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myModelCallback.MyCinemaCommentError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getfeedBackData(int userId, String sessionId, String content, MyModelCallback myModelCallback) {
        NetUtils.getInstance().getClear(MyApiServise.class)
                .feedBack(userId,sessionId,content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegEntity regEntity) {
                        myModelCallback.feedBackSuccess(regEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myModelCallback.feedBackError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getallSysMsgData(int userId, String sessionId, int page, int count, MyModelCallback myModelCallback) {
        NetUtils.getInstance().getClear(MyApiServise.class)
                .allSysMsg(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AllSysMshEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AllSysMshEntity allSysMshEntity) {
                        myModelCallback.allSysMsgSuccess(allSysMshEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myModelCallback.allSysMsgError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getchangeSysMsgData(int userId, String sessionId, int id, MyModelCallback myModelCallback) {
        NetUtils.getInstance().getClear(MyApiServise.class)
                .changeSysMsg(userId,sessionId,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegEntity regEntity) {
                        myModelCallback.changeSysMsgSuccess(regEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myModelCallback.changeSysMsgError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUserInfoData(int userId, String sessionId, MyModelCallback myModelCallback) {
        NetUtils.getInstance().getClear(MyApiServise.class)
                .UserInfo(userId,sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyxinxiEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyxinxiEntity myxinxiEntity) {
                        myModelCallback.UserInfoSuccess(myxinxiEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myModelCallback.UserInfoError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
