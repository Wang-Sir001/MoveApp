package com.bw.movie.model;

import com.bw.movie.api.YingyuanApiServise;
import com.bw.movie.contract.YingyuanContract;
import com.bw.movie.model.entity.yingyuanEntity.FujinEntity;
import com.bw.movie.model.entity.yingyuanEntity.TuijianEntity;
import com.bw.movie.model.entity.yingyuanEntity.TwoItemEntity;
import com.bw.movie.util.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * data:2020/3/24
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class MoveModel implements YingyuanContract.IModel {
    @Override
    public void getFujinData(int userId, String sessionId, String longitude, String latitude, int page, int count, YingyuanModelCallback yingyuanModelCallback) {
        NetUtils.getInstance().getClear(YingyuanApiServise.class)
                .fujin(userId,sessionId,longitude,latitude,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FujinEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FujinEntity fujinEntity) {
                        yingyuanModelCallback.FujinSuccess(fujinEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        yingyuanModelCallback.FujinError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getTuijianData(int userId, String sessionId, int page, int count, YingyuanModelCallback yingyuanModelCallback) {
        NetUtils.getInstance().getClear(YingyuanApiServise.class)
                .tuijian(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TuijianEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TuijianEntity tuijianEntity) {
                        yingyuanModelCallback.TuijianSuccess(tuijianEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        yingyuanModelCallback.TuijianError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getTwoItemData(YingyuanModelCallback yingyuanModelCallback) {
        NetUtils.getInstance().getClear(YingyuanApiServise.class)
                .twoItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TwoItemEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TwoItemEntity twoItemEntity) {
                        yingyuanModelCallback.TwoItemSuccess(twoItemEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        yingyuanModelCallback.TwoItemError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
