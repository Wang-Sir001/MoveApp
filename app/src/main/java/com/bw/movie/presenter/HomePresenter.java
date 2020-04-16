package com.bw.movie.presenter;

import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.HomeModel;
import com.bw.movie.model.entity.CityBean;
import com.bw.movie.model.entity.XBannerEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.JjsyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.RmdyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.ZzsyEntity;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class HomePresenter extends BasePresenter<HomeModel, HomeContract.IView> implements HomeContract.IPresenter {
    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }

    @Override
    public void getZzsyData(int page, int count) {
        model.getZzsyData(page, count, new HomeContract.IModel.HomeModelCallback() {
            @Override
            public void ZzsySuccess(ZzsyEntity zzsyEntity) {
                getView().ZzsySuccess(zzsyEntity);
            }

            @Override
            public void ZzsyError(Throwable throwable) {
                getView().ZzsyError(throwable);
            }

            @Override
            public void JjsySuccess(JjsyEntity jjsyEntity) {

            }

            @Override
            public void JjsyError(Throwable throwable) {

            }

            @Override
            public void RmdySuccess(RmdyEntity rmdyEntity) {

            }

            @Override
            public void RmdyError(Throwable throwable) {

            }

            @Override
            public void XBannersSuccess(XBannerEntity xBannerEntity) {

            }

            @Override
            public void XBannersError(Throwable throwable) {

            }

            @Override
            public void CitySuccess(CityBean cityBean) {

            }

            @Override
            public void CityError(Throwable throwable) {

            }

            @Override
            public void ReserveSuccess(RegEntity regEntity) {

            }

            @Override
            public void ReserveError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getJjsyData(int page, int count) {
        model.getJjsyData(page, count, new HomeContract.IModel.HomeModelCallback() {
            @Override
            public void ZzsySuccess(ZzsyEntity zzsyEntity) {

            }

            @Override
            public void ZzsyError(Throwable throwable) {

            }

            @Override
            public void JjsySuccess(JjsyEntity jjsyEntity) {
                getView().JjsySuccess(jjsyEntity);
            }

            @Override
            public void JjsyError(Throwable throwable) {
                getView().JjsyError(throwable);
            }

            @Override
            public void RmdySuccess(RmdyEntity rmdyEntity) {

            }

            @Override
            public void RmdyError(Throwable throwable) {

            }

            @Override
            public void XBannersSuccess(XBannerEntity xBannerEntity) {

            }

            @Override
            public void XBannersError(Throwable throwable) {

            }

            @Override
            public void CitySuccess(CityBean cityBean) {

            }

            @Override
            public void CityError(Throwable throwable) {

            }

            @Override
            public void ReserveSuccess(RegEntity regEntity) {

            }

            @Override
            public void ReserveError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getRmdyData(int page, int count) {
        model.getRmdyData(page, count, new HomeContract.IModel.HomeModelCallback() {
            @Override
            public void ZzsySuccess(ZzsyEntity zzsyEntity) {

            }

            @Override
            public void ZzsyError(Throwable throwable) {

            }

            @Override
            public void JjsySuccess(JjsyEntity jjsyEntity) {

            }

            @Override
            public void JjsyError(Throwable throwable) {

            }

            @Override
            public void RmdySuccess(RmdyEntity rmdyEntity) {
                getView().RmdySuccess(rmdyEntity);
            }

            @Override
            public void RmdyError(Throwable throwable) {
                getView().RmdyError(throwable);
            }

            @Override
            public void XBannersSuccess(XBannerEntity xBannerEntity) {

            }

            @Override
            public void XBannersError(Throwable throwable) {

            }

            @Override
            public void CitySuccess(CityBean cityBean) {

            }

            @Override
            public void CityError(Throwable throwable) {

            }

            @Override
            public void ReserveSuccess(RegEntity regEntity) {

            }

            @Override
            public void ReserveError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getXBannersData() {
        model.getXBannersData(new HomeContract.IModel.HomeModelCallback() {
            @Override
            public void ZzsySuccess(ZzsyEntity zzsyEntity) {

            }

            @Override
            public void ZzsyError(Throwable throwable) {

            }

            @Override
            public void JjsySuccess(JjsyEntity jjsyEntity) {

            }

            @Override
            public void JjsyError(Throwable throwable) {

            }

            @Override
            public void RmdySuccess(RmdyEntity rmdyEntity) {

            }

            @Override
            public void RmdyError(Throwable throwable) {

            }

            @Override
            public void XBannersSuccess(XBannerEntity xBannerEntity) {
                getView().XBannersSuccess(xBannerEntity);
            }

            @Override
            public void XBannersError(Throwable throwable) {
                getView().XBannersError(throwable);
            }

            @Override
            public void CitySuccess(CityBean cityBean) {

            }

            @Override
            public void CityError(Throwable throwable) {

            }

            @Override
            public void ReserveSuccess(RegEntity regEntity) {

            }

            @Override
            public void ReserveError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getCityData(String  location, String output, String key) {
        model.getCityData(location, output, key, new HomeContract.IModel.HomeModelCallback() {
            @Override
            public void ZzsySuccess(ZzsyEntity zzsyEntity) {

            }

            @Override
            public void ZzsyError(Throwable throwable) {

            }

            @Override
            public void JjsySuccess(JjsyEntity jjsyEntity) {

            }

            @Override
            public void JjsyError(Throwable throwable) {

            }

            @Override
            public void RmdySuccess(RmdyEntity rmdyEntity) {

            }

            @Override
            public void RmdyError(Throwable throwable) {

            }

            @Override
            public void XBannersSuccess(XBannerEntity xBannerEntity) {

            }

            @Override
            public void XBannersError(Throwable throwable) {

            }

            @Override
            public void CitySuccess(CityBean cityBean) {
                getView().CitySuccess(cityBean);
            }

            @Override
            public void CityError(Throwable throwable) {
                getView().CityError(throwable);
            }

            @Override
            public void ReserveSuccess(RegEntity regEntity) {

            }

            @Override
            public void ReserveError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getReserveData(int userId, String sessionId, int movieId) {
        model.getReserveData(userId, sessionId, movieId, new HomeContract.IModel.HomeModelCallback() {
            @Override
            public void ZzsySuccess(ZzsyEntity zzsyEntity) {

            }

            @Override
            public void ZzsyError(Throwable throwable) {

            }

            @Override
            public void JjsySuccess(JjsyEntity jjsyEntity) {

            }

            @Override
            public void JjsyError(Throwable throwable) {

            }

            @Override
            public void RmdySuccess(RmdyEntity rmdyEntity) {

            }

            @Override
            public void RmdyError(Throwable throwable) {

            }

            @Override
            public void XBannersSuccess(XBannerEntity xBannerEntity) {

            }

            @Override
            public void XBannersError(Throwable throwable) {

            }

            @Override
            public void CitySuccess(CityBean cityBean) {

            }

            @Override
            public void CityError(Throwable throwable) {

            }

            @Override
            public void ReserveSuccess(RegEntity regEntity) {
                getView().ReserveSuccess(regEntity);
            }

            @Override
            public void ReserveError(Throwable throwable) {
                getView().ReserveError(throwable);
            }
        });
    }
}
