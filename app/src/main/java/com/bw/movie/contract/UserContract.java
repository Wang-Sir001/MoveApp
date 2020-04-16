package com.bw.movie.contract;

import com.bw.movie.base.mvp.IBaseModel;
import com.bw.movie.base.mvp.IBaseView;
import com.bw.movie.model.entity.dengluEntity.LogEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dengluEntity.WeixinEntity;
import com.bw.movie.model.entity.dengluEntity.YzmEntity;

/**
 * data:2020/3/20
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface UserContract {

    interface IModel extends IBaseModel {
        void getYzmData(String email, UserModelCallback userModelCallback);
        void getRegData(String nickName, String pwd, String email, String code, UserModelCallback userModelCallback);
        void getLogData(String email, String pwd, UserModelCallback userModelCallback);
        void getWeixinData(String code,UserModelCallback userModelCallback);

        interface UserModelCallback{
            void YzmSuccess(YzmEntity yzmEntity);
            void YzmError(Throwable throwable);
            void RegSuccess(RegEntity regEntity);
            void RegError(Throwable throwable);
            void LogSuccess(LogEntity logEntity);
            void LogError(Throwable throwable);
            void WeixinSuccess(WeixinEntity weixinEntity);
            void WeixinError(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void YzmSuccess(YzmEntity yzmEntity);
        void YzmError(Throwable throwable);
        void RegSuccess(RegEntity regEntity);
        void RegError(Throwable throwable);
        void LogSuccess(LogEntity logEntity);
        void LogError(Throwable throwable);
        void WeixinSuccess(WeixinEntity weixinEntity);
        void WeixinError(Throwable throwable);
    }
    interface IPresenter{
        void getYzmData(String email);
        void getRegData(String nickName, String pwd, String email, String code);
        void getLogData(String email, String pwd);
        void getWeixinData(String code);
    }

}
