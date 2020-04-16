package com.bw.movie.model;

import android.util.Log;

import com.bw.movie.api.DetailsApiServise;
import com.bw.movie.contract.DetailContract;
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
import com.bw.movie.util.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * data:2020/3/26
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class DetailModel implements DetailContract.IModel {
    @Override
    public void getDetailData(int userId, String sessionId, int movieId, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .detail(userId,sessionId,movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetialEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DetialEntity detialEntity) {
                        detailModelCallback.DetaileSuccess(detialEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.DetailError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getCommentData(int userId, String sessionId, int movieId, int page, int count, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .comment(userId,sessionId,movieId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommentEntity commentEntity) {
                        detailModelCallback.CommentSuccess(commentEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.CommentError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void getCommentsData(int userId, String sessionId, int movieId, String commentContent, double score, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .comments(userId,sessionId,movieId,commentContent,score)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentsEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommentsEntity commentsEntity) {
                        detailModelCallback.CommentsSuccess(commentsEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.CommentsError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRegionCityData(DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .regionCity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegionCityEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegionCityEntity regionCityEntity) {
                        detailModelCallback.regionCitySuccess(regionCityEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.regionCity(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getfindDataData(DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .findData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindDataEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindDataEntity findDataEntity) {
                        detailModelCallback.findDataSuccess(findDataEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.findDataError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getfindcinemasData(int movieId, int regionId, int page, int count, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .findcinemas(movieId,regionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindCinemasEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindCinemasEntity findCinemasEntity) {
                        detailModelCallback.findcinemasSuccess(findCinemasEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.findcinemasError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getfindcinemasPriceData(int movieId, int page, int count, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .findcinemasPrice(movieId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindcinemasPriceEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindcinemasPriceEntity findcinemasPriceEntity) {
                        detailModelCallback.findcinemasPriceSuccess(findcinemasPriceEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.findcinemasPriceError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getchooseData(int movieId, int cinemaId, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .choose(movieId,cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChooseActivityBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChooseActivityBean chooseActivityBean) {
                        detailModelCallback.chooseSuccess(chooseActivityBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.chooseError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getseatData(int hallId, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .seat(hallId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SeatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SeatBean seatBean) {
                        detailModelCallback.seatSuccess(seatBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.seatError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getSoonMovieData(int cinemaId,int page,int count, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .soonMovie(cinemaId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SoonMoiveEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SoonMoiveEntity soonMoiveEntity) {
                        detailModelCallback.soonMovieSuccess(soonMoiveEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.soonMovieError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getFollowMovieData(int userId, String sessionId, int movieId, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .followMovie(userId,sessionId,movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GuanzhuEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GuanzhuEntity guanzhuEntity) {
                        detailModelCallback.followMovieSuccess(guanzhuEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.folloeMovieError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUnFollowMovieData(int userId, String sessionId, int movieId, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .unFollowMovie(userId,sessionId,movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GuanzhuEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GuanzhuEntity guanzhuEntity) {
                        detailModelCallback.unfollowMovieSuccess(guanzhuEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.unfolloeMovieError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUserFollowMovieData(int userId, String sessionId, int page, int count, DetailModelCallback detailModelCallback) {
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
                        detailModelCallback.userfollowMovieSuccess(userFollowMovieEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.userfollowMovieError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getBuyData(int userId, String sessionId, int scheduleId, String seat, String sign, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .buy(userId,sessionId,scheduleId,seat,sign)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BuyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BuyBean buyBean) {
                        detailModelCallback.BuySuccess(buyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.BuyError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getPayData(int userId, String sessionId, int payType, String orderId, DetailModelCallback detailModelCallback) {
        NetUtils.getInstance().getClear(DetailsApiServise.class)
                .pay(userId,sessionId,payType,orderId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PayBean payBean) {
                        detailModelCallback.PaySuccess(payBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailModelCallback.PayError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
