package com.bw.movie.presenter;

import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.contract.YingyuanContract;
import com.bw.movie.model.MoveModel;
import com.bw.movie.model.entity.yingyuanEntity.FujinEntity;
import com.bw.movie.model.entity.yingyuanEntity.TuijianEntity;
import com.bw.movie.model.entity.yingyuanEntity.TwoItemEntity;

/**
 * data:2020/3/24
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class MovePresenter extends BasePresenter<MoveModel, YingyuanContract.IView> implements YingyuanContract.IPresenter {
    @Override
    protected MoveModel initModel() {
        return new MoveModel();
    }

    @Override
    public void getFujinData(int userId, String sessionId, String longitude, String latitude, int page, int count) {
        model.getFujinData(userId, sessionId, longitude, latitude, page, count, new YingyuanContract.IModel.YingyuanModelCallback() {
            @Override
            public void FujinSuccess(FujinEntity fujinEntity) {
                getView().FujinSuccess(fujinEntity);
            }

            @Override
            public void FujinError(Throwable throwable) {
                getView().FujinError(throwable);
            }

            @Override
            public void TuijianSuccess(TuijianEntity tuijianEntity) {

            }

            @Override
            public void TuijianError(Throwable throwable) {

            }

            @Override
            public void TwoItemSuccess(TwoItemEntity twoItemEntity) {

            }

            @Override
            public void TwoItemError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getTuijianData(int userId, String sessionId, int page, int count) {
        model.getTuijianData(userId, sessionId, page, count, new YingyuanContract.IModel.YingyuanModelCallback() {
            @Override
            public void FujinSuccess(FujinEntity fujinEntity) {

            }

            @Override
            public void FujinError(Throwable throwable) {

            }

            @Override
            public void TuijianSuccess(TuijianEntity tuijianEntity) {
                getView().TuijianSuccess(tuijianEntity);
            }

            @Override
            public void TuijianError(Throwable throwable) {
                getView().TuijianError(throwable);
            }

            @Override
            public void TwoItemSuccess(TwoItemEntity twoItemEntity) {

            }

            @Override
            public void TwoItemError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getTwoItemData() {
        model.getTwoItemData(new YingyuanContract.IModel.YingyuanModelCallback() {
            @Override
            public void FujinSuccess(FujinEntity fujinEntity) {

            }

            @Override
            public void FujinError(Throwable throwable) {

            }

            @Override
            public void TuijianSuccess(TuijianEntity tuijianEntity) {

            }

            @Override
            public void TuijianError(Throwable throwable) {

            }

            @Override
            public void TwoItemSuccess(TwoItemEntity twoItemEntity) {
                getView().TwoItemSuccess(twoItemEntity);
            }

            @Override
            public void TwoItemError(Throwable throwable) {
                getView().TwoItemError(throwable);
            }
        });
    }
}
