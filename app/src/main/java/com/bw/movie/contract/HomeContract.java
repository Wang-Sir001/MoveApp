package com.bw.movie.contract;

import com.bw.movie.base.mvp.IBaseModel;
import com.bw.movie.base.mvp.IBaseView;
import com.bw.movie.model.entity.CityBean;
import com.bw.movie.model.entity.XBannerEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.JjsyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.RmdyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.ZzsyEntity;

import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface HomeContract {
    interface IModel extends IBaseModel {
        void getZzsyData(int page, int count, HomeModelCallback homeModelCallback);
        void getJjsyData(int page, int count, HomeModelCallback homeModelCallback);
        void getRmdyData(int page, int count, HomeModelCallback homeModelCallback);
        void getXBannersData(HomeModelCallback homeModelCallback);
        void getCityData(String  location,String output,String key,HomeModelCallback homeModelCallback);
        void getReserveData(int userId,String sessionId,int movieId,HomeModelCallback homeModelCallback);

        interface HomeModelCallback{
            void ZzsySuccess(ZzsyEntity zzsyEntity);
            void ZzsyError(Throwable throwable);
            void JjsySuccess(JjsyEntity jjsyEntity);
            void JjsyError(Throwable throwable);
            void RmdySuccess(RmdyEntity rmdyEntity);
            void RmdyError(Throwable throwable);
            void XBannersSuccess(XBannerEntity xBannerEntity);
            void XBannersError(Throwable throwable);
            void CitySuccess(CityBean cityBean);
            void CityError(Throwable throwable);
            void ReserveSuccess(RegEntity regEntity);
            void ReserveError(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void ZzsySuccess(ZzsyEntity zzsyEntity);
        void ZzsyError(Throwable throwable);
        void JjsySuccess(JjsyEntity jjsyEntity);
        void JjsyError(Throwable throwable);
        void RmdySuccess(RmdyEntity rmdyEntity);
        void RmdyError(Throwable throwable);
        void XBannersSuccess(XBannerEntity xBannerEntity);
        void XBannersError(Throwable throwable);
        void CitySuccess(CityBean cityBean);
        void CityError(Throwable throwable);
        void ReserveSuccess(RegEntity regEntity);
        void ReserveError(Throwable throwable);
    }
    interface IPresenter{
        void getZzsyData(int page, int count);
        void getJjsyData(int page, int count);
        void getRmdyData(int page, int count);
        void getXBannersData();
        void getCityData(String  location,String output,String key);
        void getReserveData(int userId,String sessionId,int movieId);
    }
}
