package com.bw.movie.contract;

import com.bw.movie.base.mvp.IBaseModel;
import com.bw.movie.base.mvp.IBaseView;
import com.bw.movie.model.entity.yingyuanEntity.FujinEntity;
import com.bw.movie.model.entity.yingyuanEntity.TuijianEntity;
import com.bw.movie.model.entity.yingyuanEntity.TwoItemEntity;

/**
 * data:2020/3/24
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface YingyuanContract {
    interface IModel extends IBaseModel {
        void getFujinData(int userId, String sessionId, String longitude, String latitude, int page, int count, YingyuanModelCallback yingyuanModelCallback);
        void getTuijianData(int userId, String sessionId, int page, int count, YingyuanModelCallback yingyuanModelCallback);
        void getTwoItemData(YingyuanModelCallback yingyuanModelCallback);

        interface YingyuanModelCallback{
            void FujinSuccess(FujinEntity fujinEntity);
            void FujinError(Throwable throwable);
            void TuijianSuccess(TuijianEntity tuijianEntity);
            void TuijianError(Throwable throwable);
            void TwoItemSuccess(TwoItemEntity twoItemEntity);
            void TwoItemError(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void FujinSuccess(FujinEntity fujinEntity);
        void FujinError(Throwable throwable);
        void TuijianSuccess(TuijianEntity tuijianEntity);
        void TuijianError(Throwable throwable);
        void TwoItemSuccess(TwoItemEntity twoItemEntity);
        void TwoItemError(Throwable throwable);
    }
    interface IPresenter{
        void getFujinData(int userId, String sessionId, String longitude, String latitude, int page, int count);
        void getTuijianData(int userId, String sessionId, int page, int count);
        void getTwoItemData();
    }
}
