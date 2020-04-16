package com.bw.movie.model;

import com.bw.movie.api.UserApiServise;
import com.bw.movie.contract.UserContract;
import com.bw.movie.model.entity.dengluEntity.LogEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dengluEntity.WeixinEntity;
import com.bw.movie.model.entity.dengluEntity.YzmEntity;
import com.bw.movie.util.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * data:2020/3/20
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class UserModel implements UserContract.IModel {
    @Override
    public void getYzmData(String email, UserModelCallback userModelCallback) {
        NetUtils.getInstance().getClear(UserApiServise.class)
                .yzm(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<YzmEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(YzmEntity yzmEntity) {
                        userModelCallback.YzmSuccess(yzmEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelCallback.YzmError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRegData(String nickName, String pwd, String email, String code, UserModelCallback userModelCallback) {
        NetUtils.getInstance().getClear(UserApiServise.class)
                .reg(nickName,pwd,email,code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegEntity regEntity) {
                        userModelCallback.RegSuccess(regEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelCallback.RegError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getLogData(String email, String pwd, UserModelCallback userModelCallback) {
        NetUtils.getInstance().getClear(UserApiServise.class)
                .log(email,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LogEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LogEntity logEntity) {
                        userModelCallback.LogSuccess(logEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelCallback.LogError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getWeixinData(String code, UserModelCallback userModelCallback) {
        NetUtils.getInstance().getClear(UserApiServise.class)
                .weixin(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeixinEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeixinEntity weixinEntity) {
                        userModelCallback.WeixinSuccess(weixinEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelCallback.WeixinError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
