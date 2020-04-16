package com.bw.movie.model;

import com.bw.movie.api.HomeApiServise;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.entity.CityBean;
import com.bw.movie.model.entity.XBannerEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.JjsyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.RmdyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.ZzsyEntity;
import com.bw.movie.util.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class HomeModel implements HomeContract.IModel {
    @Override
    public void getZzsyData(int page, int count, HomeModelCallback homeModelCallback) {
        NetUtils.getInstance().getClear(HomeApiServise.class)
                .zzsy(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZzsyEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZzsyEntity zzsyEntity) {
                        homeModelCallback.ZzsySuccess(zzsyEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeModelCallback.ZzsyError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getJjsyData(int page, int count, HomeModelCallback homeModelCallback) {
        NetUtils.getInstance().getClear(HomeApiServise.class)
                .jjsy(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JjsyEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JjsyEntity jjsyEntity) {
                        homeModelCallback.JjsySuccess(jjsyEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeModelCallback.JjsyError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRmdyData(int page, int count, HomeModelCallback homeModelCallback) {
        NetUtils.getInstance().getClear(HomeApiServise.class)
                .rmdy(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RmdyEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RmdyEntity rmdyEntity) {
                        homeModelCallback.RmdySuccess(rmdyEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeModelCallback.RmdyError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getXBannersData(HomeModelCallback homeModelCallback) {
        NetUtils.getInstance().getClear(HomeApiServise.class)
                .xBanners()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XBannerEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XBannerEntity xBannerEntity) {
                        homeModelCallback.XBannersSuccess(xBannerEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeModelCallback.XBannersError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getCityData(String  location, String output, String key, HomeModelCallback homeModelCallback) {
        NetUtils.getInstance().getClear(HomeApiServise.class)
                .city(location,output,key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CityBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CityBean cityBean) {
                        homeModelCallback.CitySuccess(cityBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeModelCallback.CityError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getReserveData(int userId, String sessionId, int movieId, HomeModelCallback homeModelCallback) {
        NetUtils.getInstance().getClear(HomeApiServise.class)
                .reserve(userId,sessionId,movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegEntity regEntity) {
                        homeModelCallback.ReserveSuccess(regEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeModelCallback.ReserveError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
