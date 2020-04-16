package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.contract.DetailContract;
import com.bw.movie.model.DetailModel;
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

/**
 * data:2020/3/26
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class DetailPresenter extends BasePresenter<DetailModel, DetailContract.IView> implements DetailContract.IPresenter {
    @Override
    protected DetailModel initModel() {
        return new DetailModel();
    }

    @Override
    public void getDetailData(int userId, String sessionId, int movieId) {
        model.getDetailData(userId, sessionId, movieId, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {
                getView().DetaileSuccess(detialEntity);
            }

            @Override
            public void DetailError(Throwable throwable) {
                getView().DetailError(throwable);
            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getCommentData(int userId, String sessionId, int movieId, int page, int count) {
        Log.i("xi",userId+""+movieId);
        model.getCommentData(userId, sessionId, movieId, page, count, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {
                getView().CommentSuccess(commentEntity);
                Log.i("xiii",commentEntity.getMessage());
            }

            @Override
            public void CommentError(Throwable throwable) {
                getView().CommentError(throwable);
            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getCommentsData(int userId, String sessionId, int movieId, String commentContent, double score) {
        model.getCommentsData(userId, sessionId, movieId, commentContent, score, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {
                getView().CommentsSuccess(commentsEntity);
            }

            @Override
            public void CommentsError(Throwable throwable) {
                getView().CommentsError(throwable);
            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getRegionCityData() {
        model.getRegionCityData(new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {
                getView().regionCitySuccess(regionCityEntity);
            }

            @Override
            public void regionCity(Throwable throwable) {
                getView().regionCity(throwable);
            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getfindDataData() {
        model.getfindDataData(new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {
                getView().findDataSuccess(findDataEntity);
            }

            @Override
            public void findDataError(Throwable throwable) {
                getView().findDataError(throwable);
            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getfindcinemasData(int movieId, int regionId, int page, int count) {
        model.getfindcinemasData(movieId, regionId, page, count, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {
                getView().findcinemasSuccess(findCinemasEntity);
            }

            @Override
            public void findcinemasError(Throwable throwable) {
                getView().findcinemasError(throwable);
            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getfindcinemasPriceData(int movieId, int page, int count) {
        model.getfindcinemasPriceData(movieId, page, count, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {
                getView().findcinemasPriceSuccess(findcinemasPriceEntity);
            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {
                getView().findcinemasPriceError(throwable);
            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getchooseData(int movieId, int cinemaId) {
        model.getchooseData(movieId, cinemaId, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {
                getView().chooseSuccess(chooseActivityBean);
            }

            @Override
            public void chooseError(Throwable throwable) {
                getView().chooseError(throwable);
            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getseatData(int hallId) {
        model.getseatData(hallId, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {
                getView().seatSuccess(seatBean);
            }

            @Override
            public void seatError(Throwable throwable) {
                getView().seatError(throwable);
            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getSoonMovieData(int cinemaId,int page,int count) {
        model.getSoonMovieData(cinemaId,page,count, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {
                getView().soonMovieSuccess(soonMoiveEntity);
            }

            @Override
            public void soonMovieError(Throwable throwable) {
                getView().soonMovieError(throwable);
            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getFollowMovieData(int userId, String sessionId, int movieId) {
        model.getFollowMovieData(userId, sessionId, movieId, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {
                getView().followMovieSuccess(guanzhuEntity);
            }

            @Override
            public void folloeMovieError(Throwable throwable) {
                getView().folloeMovieError(throwable);
            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getUnFollowMovieData(int userId, String sessionId, int movieId) {
        model.getUnFollowMovieData(userId, sessionId, movieId, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {
                getView().unfollowMovieSuccess(guanzhuEntity);
            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {
                getView().unfolloeMovieError(throwable);
            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getUserFollowMovieData(int userId, String sessionId, int page, int count) {
        model.getUserFollowMovieData(userId, sessionId, page, count, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {
                getView().userfollowMovieSuccess(userFollowMovieEntity);
            }

            @Override
            public void userfollowMovieError(Throwable throwable) {
                getView().userfollowMovieError(throwable);
            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getBuyData(int userId, String sessionId, int scheduleId, String seat, String sign) {
        model.getBuyData(userId, sessionId, scheduleId, seat, sign, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {
                getView().BuySuccess(buyBean);
            }

            @Override
            public void BuyError(Throwable throwable) {
                getView().BuyError(throwable);
            }

            @Override
            public void PaySuccess(PayBean payBean) {

            }

            @Override
            public void PayError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getPayData(int userId, String sessionId, int payType, String orderId) {
        model.getPayData(userId, sessionId, payType, orderId, new DetailContract.IModel.DetailModelCallback() {
            @Override
            public void DetaileSuccess(DetialEntity detialEntity) {

            }

            @Override
            public void DetailError(Throwable throwable) {

            }

            @Override
            public void CommentSuccess(CommentEntity commentEntity) {

            }

            @Override
            public void CommentError(Throwable throwable) {

            }

            @Override
            public void CommentsSuccess(CommentsEntity commentsEntity) {

            }

            @Override
            public void CommentsError(Throwable throwable) {

            }

            @Override
            public void regionCitySuccess(RegionCityEntity regionCityEntity) {

            }

            @Override
            public void regionCity(Throwable throwable) {

            }

            @Override
            public void findDataSuccess(FindDataEntity findDataEntity) {

            }

            @Override
            public void findDataError(Throwable throwable) {

            }

            @Override
            public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

            }

            @Override
            public void findcinemasError(Throwable throwable) {

            }

            @Override
            public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

            }

            @Override
            public void findcinemasPriceError(Throwable throwable) {

            }

            @Override
            public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

            }

            @Override
            public void chooseError(Throwable throwable) {

            }

            @Override
            public void seatSuccess(SeatBean seatBean) {

            }

            @Override
            public void seatError(Throwable throwable) {

            }

            @Override
            public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {

            }

            @Override
            public void soonMovieError(Throwable throwable) {

            }

            @Override
            public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void folloeMovieError(Throwable throwable) {

            }

            @Override
            public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

            }

            @Override
            public void unfolloeMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void BuySuccess(BuyBean buyBean) {

            }

            @Override
            public void BuyError(Throwable throwable) {

            }

            @Override
            public void PaySuccess(PayBean payBean) {
                getView().PaySuccess(payBean);
            }

            @Override
            public void PayError(Throwable throwable) {
                getView().PayError(throwable);
            }
        });
    }

}
