package com.bw.movie.presenter;

import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.contract.UserContract;
import com.bw.movie.model.UserModel;
import com.bw.movie.model.entity.dengluEntity.LogEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dengluEntity.WeixinEntity;
import com.bw.movie.model.entity.dengluEntity.YzmEntity;

/**
 * data:2020/3/20
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class UserPresenter extends BasePresenter<UserModel, UserContract.IView> implements UserContract.IPresenter {
    @Override
    protected UserModel initModel() {
        return new UserModel();
    }

    @Override
    public void getYzmData(String email) {
        model.getYzmData(email, new UserContract.IModel.UserModelCallback() {
            @Override
            public void YzmSuccess(YzmEntity yzmEntity) {
                getView().YzmSuccess(yzmEntity);
            }

            @Override
            public void YzmError(Throwable throwable) {
                getView().YzmError(throwable);
            }

            @Override
            public void RegSuccess(RegEntity regEntity) {

            }

            @Override
            public void RegError(Throwable throwable) {

            }

            @Override
            public void LogSuccess(LogEntity logEntity) {

            }

            @Override
            public void LogError(Throwable throwable) {

            }

            @Override
            public void WeixinSuccess(WeixinEntity weixinEntity) {

            }

            @Override
            public void WeixinError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getRegData(String nickName, String pwd, String email, String code) {
        model.getRegData(nickName, pwd, email, code, new UserContract.IModel.UserModelCallback() {
            @Override
            public void YzmSuccess(YzmEntity yzmEntity) {

            }

            @Override
            public void YzmError(Throwable throwable) {

            }

            @Override
            public void RegSuccess(RegEntity regEntity) {
                getView().RegSuccess(regEntity);
            }

            @Override
            public void RegError(Throwable throwable) {
                getView().RegError(throwable);
            }

            @Override
            public void LogSuccess(LogEntity logEntity) {

            }

            @Override
            public void LogError(Throwable throwable) {

            }

            @Override
            public void WeixinSuccess(WeixinEntity weixinEntity) {

            }

            @Override
            public void WeixinError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getLogData(String email, String pwd) {
        model.getLogData(email, pwd, new UserContract.IModel.UserModelCallback() {
            @Override
            public void YzmSuccess(YzmEntity yzmEntity) {

            }

            @Override
            public void YzmError(Throwable throwable) {

            }

            @Override
            public void RegSuccess(RegEntity regEntity) {

            }

            @Override
            public void RegError(Throwable throwable) {

            }

            @Override
            public void LogSuccess(LogEntity logEntity) {
                getView().LogSuccess(logEntity);
            }

            @Override
            public void LogError(Throwable throwable) {
                getView().LogError(throwable);
            }

            @Override
            public void WeixinSuccess(WeixinEntity weixinEntity) {

            }

            @Override
            public void WeixinError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getWeixinData(String code) {
        model.getWeixinData(code, new UserContract.IModel.UserModelCallback() {
            @Override
            public void YzmSuccess(YzmEntity yzmEntity) {

            }

            @Override
            public void YzmError(Throwable throwable) {

            }

            @Override
            public void RegSuccess(RegEntity regEntity) {

            }

            @Override
            public void RegError(Throwable throwable) {

            }

            @Override
            public void LogSuccess(LogEntity logEntity) {

            }

            @Override
            public void LogError(Throwable throwable) {

            }

            @Override
            public void WeixinSuccess(WeixinEntity weixinEntity) {
                getView().WeixinSuccess(weixinEntity);
            }

            @Override
            public void WeixinError(Throwable throwable) {
                getView().WeixinError(throwable);
            }
        });
    }
}
