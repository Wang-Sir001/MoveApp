package com.bw.movie.presenter;

import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.contract.MyContract;
import com.bw.movie.model.MyModel;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.UserFollowMovieEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.myEntity.AllSysMshEntity;
import com.bw.movie.model.entity.myEntity.MyCinemaCommentEntity;
import com.bw.movie.model.entity.myEntity.MyMovieCommentEntity;
import com.bw.movie.model.entity.myEntity.MyxinxiEntity;
import com.bw.movie.model.entity.myEntity.UserReserveEntity;

/**
 * data:2020/4/10
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class MyPresenter extends BasePresenter<MyModel, MyContract.IView> implements MyContract.IPresenter {
    @Override
    protected MyModel initModel() {
        return new MyModel();
    }

    @Override
    public void getUserFollowMovieData(int userId, String sessionId, int page, int count) {
        model.getUserFollowMovieData(userId, sessionId, page, count, new MyContract.IModel.MyModelCallback() {
            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {
                getView().userfollowMovieSuccess(userFollowMovieEntity);
            }

            @Override
            public void userfollowMovieError(Throwable throwable) {
                getView().userfollowMovieError(throwable);
            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }

            @Override
            public void UserReserveSuccess(UserReserveEntity userReserveEntity) {

            }

            @Override
            public void UserReserveError(Throwable throwable) {

            }

            @Override
            public void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity) {

            }

            @Override
            public void MyMovieCommentError(Throwable throwable) {

            }

            @Override
            public void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity) {

            }

            @Override
            public void MyCinemaCommentError(Throwable throwable) {

            }

            @Override
            public void feedBackSuccess(RegEntity regEntity) {

            }

            @Override
            public void feedBackError(Throwable throwable) {

            }

            @Override
            public void allSysMsgSuccess(AllSysMshEntity allSysMshEntity) {

            }

            @Override
            public void allSysMsgError(Throwable throwable) {

            }

            @Override
            public void changeSysMsgSuccess(RegEntity regEntity) {

            }

            @Override
            public void changeSysMsgError(Throwable throwable) {

            }

            @Override
            public void UserInfoSuccess(MyxinxiEntity myxinxiEntity) {

            }

            @Override
            public void UserInfoError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getUserFollowCinemaData(int userId, String sessionId, int page, int count) {
        model.getUserFollowCinemaData(userId, sessionId, page, count, new MyContract.IModel.MyModelCallback() {
            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {
                getView().userfollowCinemaSuccess(userFollowCinemaEntity);
            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {
                getView().userfollowCinemaError(throwable);
            }

            @Override
            public void UserReserveSuccess(UserReserveEntity userReserveEntity) {

            }

            @Override
            public void UserReserveError(Throwable throwable) {

            }

            @Override
            public void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity) {

            }

            @Override
            public void MyMovieCommentError(Throwable throwable) {

            }

            @Override
            public void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity) {

            }

            @Override
            public void MyCinemaCommentError(Throwable throwable) {

            }

            @Override
            public void feedBackSuccess(RegEntity regEntity) {

            }

            @Override
            public void feedBackError(Throwable throwable) {

            }

            @Override
            public void allSysMsgSuccess(AllSysMshEntity allSysMshEntity) {

            }

            @Override
            public void allSysMsgError(Throwable throwable) {

            }

            @Override
            public void changeSysMsgSuccess(RegEntity regEntity) {

            }

            @Override
            public void changeSysMsgError(Throwable throwable) {

            }

            @Override
            public void UserInfoSuccess(MyxinxiEntity myxinxiEntity) {

            }

            @Override
            public void UserInfoError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getUserReserveData(int userId, String sessionId) {
        model.getUserReserveData(userId, sessionId, new MyContract.IModel.MyModelCallback() {
            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }

            @Override
            public void UserReserveSuccess(UserReserveEntity userReserveEntity) {
                getView().UserReserveSuccess(userReserveEntity);
            }

            @Override
            public void UserReserveError(Throwable throwable) {
                getView().UserReserveError(throwable);
            }

            @Override
            public void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity) {

            }

            @Override
            public void MyMovieCommentError(Throwable throwable) {

            }

            @Override
            public void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity) {

            }

            @Override
            public void MyCinemaCommentError(Throwable throwable) {

            }

            @Override
            public void feedBackSuccess(RegEntity regEntity) {

            }

            @Override
            public void feedBackError(Throwable throwable) {

            }

            @Override
            public void allSysMsgSuccess(AllSysMshEntity allSysMshEntity) {

            }

            @Override
            public void allSysMsgError(Throwable throwable) {

            }

            @Override
            public void changeSysMsgSuccess(RegEntity regEntity) {

            }

            @Override
            public void changeSysMsgError(Throwable throwable) {

            }

            @Override
            public void UserInfoSuccess(MyxinxiEntity myxinxiEntity) {

            }

            @Override
            public void UserInfoError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getMyMovieCommentData(int userId, String sessionId, int page, int count) {
        model.getMyMovieCommentData(userId, sessionId, page, count, new MyContract.IModel.MyModelCallback() {
            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }

            @Override
            public void UserReserveSuccess(UserReserveEntity userReserveEntity) {

            }

            @Override
            public void UserReserveError(Throwable throwable) {

            }

            @Override
            public void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity) {
                getView().MyMovieCommentSuccess(myMovieCommentEntity);
            }

            @Override
            public void MyMovieCommentError(Throwable throwable) {
                getView().MyMovieCommentError(throwable);
            }

            @Override
            public void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity) {

            }

            @Override
            public void MyCinemaCommentError(Throwable throwable) {

            }

            @Override
            public void feedBackSuccess(RegEntity regEntity) {

            }

            @Override
            public void feedBackError(Throwable throwable) {

            }

            @Override
            public void allSysMsgSuccess(AllSysMshEntity allSysMshEntity) {

            }

            @Override
            public void allSysMsgError(Throwable throwable) {

            }

            @Override
            public void changeSysMsgSuccess(RegEntity regEntity) {

            }

            @Override
            public void changeSysMsgError(Throwable throwable) {

            }

            @Override
            public void UserInfoSuccess(MyxinxiEntity myxinxiEntity) {

            }

            @Override
            public void UserInfoError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getMyCinemaCommentData(int userId, String sessionId, String longitude, String latitude, int page, int count) {
        model.getMyCinemaCommentData(userId, sessionId, longitude, latitude, page, count, new MyContract.IModel.MyModelCallback() {
            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }

            @Override
            public void UserReserveSuccess(UserReserveEntity userReserveEntity) {

            }

            @Override
            public void UserReserveError(Throwable throwable) {

            }

            @Override
            public void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity) {

            }

            @Override
            public void MyMovieCommentError(Throwable throwable) {

            }

            @Override
            public void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity) {
                getView().MyCinemaCommentSuccess(myCinemaCommentEntity);
            }

            @Override
            public void MyCinemaCommentError(Throwable throwable) {
                getView().MyCinemaCommentError(throwable);
            }

            @Override
            public void feedBackSuccess(RegEntity regEntity) {

            }

            @Override
            public void feedBackError(Throwable throwable) {

            }

            @Override
            public void allSysMsgSuccess(AllSysMshEntity allSysMshEntity) {

            }

            @Override
            public void allSysMsgError(Throwable throwable) {

            }

            @Override
            public void changeSysMsgSuccess(RegEntity regEntity) {

            }

            @Override
            public void changeSysMsgError(Throwable throwable) {

            }

            @Override
            public void UserInfoSuccess(MyxinxiEntity myxinxiEntity) {

            }

            @Override
            public void UserInfoError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getfeedBackData(int userId, String sessionId, String content) {
        model.getfeedBackData(userId, sessionId, content, new MyContract.IModel.MyModelCallback() {
            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }

            @Override
            public void UserReserveSuccess(UserReserveEntity userReserveEntity) {

            }

            @Override
            public void UserReserveError(Throwable throwable) {

            }

            @Override
            public void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity) {

            }

            @Override
            public void MyMovieCommentError(Throwable throwable) {

            }

            @Override
            public void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity) {

            }

            @Override
            public void MyCinemaCommentError(Throwable throwable) {

            }

            @Override
            public void feedBackSuccess(RegEntity regEntity) {
                getView().feedBackSuccess(regEntity);
            }

            @Override
            public void feedBackError(Throwable throwable) {
                getView().feedBackError(throwable);
            }

            @Override
            public void allSysMsgSuccess(AllSysMshEntity allSysMshEntity) {

            }

            @Override
            public void allSysMsgError(Throwable throwable) {

            }

            @Override
            public void changeSysMsgSuccess(RegEntity regEntity) {

            }

            @Override
            public void changeSysMsgError(Throwable throwable) {

            }

            @Override
            public void UserInfoSuccess(MyxinxiEntity myxinxiEntity) {

            }

            @Override
            public void UserInfoError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getallSysMsgData(int userId, String sessionId, int page, int count) {
        model.getallSysMsgData(userId, sessionId, page, count, new MyContract.IModel.MyModelCallback() {
            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }

            @Override
            public void UserReserveSuccess(UserReserveEntity userReserveEntity) {

            }

            @Override
            public void UserReserveError(Throwable throwable) {

            }

            @Override
            public void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity) {

            }

            @Override
            public void MyMovieCommentError(Throwable throwable) {

            }

            @Override
            public void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity) {

            }

            @Override
            public void MyCinemaCommentError(Throwable throwable) {

            }

            @Override
            public void feedBackSuccess(RegEntity regEntity) {

            }

            @Override
            public void feedBackError(Throwable throwable) {

            }

            @Override
            public void allSysMsgSuccess(AllSysMshEntity allSysMshEntity) {
                getView().allSysMsgSuccess(allSysMshEntity);
            }

            @Override
            public void allSysMsgError(Throwable throwable) {
                getView().allSysMsgError(throwable);
            }

            @Override
            public void changeSysMsgSuccess(RegEntity regEntity) {

            }

            @Override
            public void changeSysMsgError(Throwable throwable) {

            }

            @Override
            public void UserInfoSuccess(MyxinxiEntity myxinxiEntity) {

            }

            @Override
            public void UserInfoError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getchangeSysMsgData(int userId, String sessionId, int id) {
        model.getchangeSysMsgData(userId, sessionId, id, new MyContract.IModel.MyModelCallback() {
            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }

            @Override
            public void UserReserveSuccess(UserReserveEntity userReserveEntity) {

            }

            @Override
            public void UserReserveError(Throwable throwable) {

            }

            @Override
            public void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity) {

            }

            @Override
            public void MyMovieCommentError(Throwable throwable) {

            }

            @Override
            public void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity) {

            }

            @Override
            public void MyCinemaCommentError(Throwable throwable) {

            }

            @Override
            public void feedBackSuccess(RegEntity regEntity) {

            }

            @Override
            public void feedBackError(Throwable throwable) {

            }

            @Override
            public void allSysMsgSuccess(AllSysMshEntity allSysMshEntity) {

            }

            @Override
            public void allSysMsgError(Throwable throwable) {

            }

            @Override
            public void changeSysMsgSuccess(RegEntity regEntity) {
                getView().changeSysMsgSuccess(regEntity);
            }

            @Override
            public void changeSysMsgError(Throwable throwable) {
                getView().changeSysMsgError(throwable);
            }

            @Override
            public void UserInfoSuccess(MyxinxiEntity myxinxiEntity) {

            }

            @Override
            public void UserInfoError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getUserInfoData(int userId, String sessionId) {
        model.getUserInfoData(userId, sessionId, new MyContract.IModel.MyModelCallback() {
            @Override
            public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

            }

            @Override
            public void userfollowMovieError(Throwable throwable) {

            }

            @Override
            public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

            }

            @Override
            public void userfollowCinemaError(Throwable throwable) {

            }

            @Override
            public void UserReserveSuccess(UserReserveEntity userReserveEntity) {

            }

            @Override
            public void UserReserveError(Throwable throwable) {

            }

            @Override
            public void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity) {

            }

            @Override
            public void MyMovieCommentError(Throwable throwable) {

            }

            @Override
            public void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity) {

            }

            @Override
            public void MyCinemaCommentError(Throwable throwable) {

            }

            @Override
            public void feedBackSuccess(RegEntity regEntity) {

            }

            @Override
            public void feedBackError(Throwable throwable) {

            }

            @Override
            public void allSysMsgSuccess(AllSysMshEntity allSysMshEntity) {

            }

            @Override
            public void allSysMsgError(Throwable throwable) {

            }

            @Override
            public void changeSysMsgSuccess(RegEntity regEntity) {

            }

            @Override
            public void changeSysMsgError(Throwable throwable) {

            }

            @Override
            public void UserInfoSuccess(MyxinxiEntity myxinxiEntity) {
                getView().UserInfoSuccess(myxinxiEntity);
            }

            @Override
            public void UserInfoError(Throwable throwable) {
                getView().UserInfoError(throwable);
            }
        });
    }
}
