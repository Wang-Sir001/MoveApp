package com.bw.movie.wxapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.bawei.mymovie.R;
import com.bw.movie.app.App;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.UserContract;
import com.bw.movie.model.entity.dengluEntity.LogEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dengluEntity.WeixinEntity;
import com.bw.movie.model.entity.dengluEntity.YzmEntity;
import com.bw.movie.presenter.UserPresenter;
import com.bw.movie.view.activity.Main2Activity;
import com.bw.movie.view.fragment.HomeFragment.MyFragment;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity extends BaseActivity<UserPresenter> implements IWXAPIEventHandler, UserContract.IView {
    private static final int RETURN_MSG_TYPE_LOGIN = 1;
    private static final int RETURN_MSG_TYPE_SHARE = 2;
    String code;
    SharedPreferences sp;
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        App.sIWXAPI.handleIntent(getIntent(),this);

    }

    @Override
    protected UserPresenter initPresenter() {
        return new UserPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_wxentry;
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        switch (baseResp.errCode) {

            case BaseResp.ErrCode.ERR_AUTH_DENIED:
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                if (RETURN_MSG_TYPE_SHARE == baseResp.getType()) {
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case BaseResp.ErrCode.ERR_OK:
                switch (baseResp.getType()) {
                    case RETURN_MSG_TYPE_LOGIN:
                        //拿到了微信返回的code,立马再去请求access_token
                        code = ((SendAuth.Resp) baseResp).code;
                        Log.i("codeeeee",code+"");
                        //就在这个地方，用网络库什么的或者自己封的网络api，发请求去咯，注意是get请求
                        presenter.getWeixinData(code);
                        break;
                    case RETURN_MSG_TYPE_SHARE:
                        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                }
                break;

        }
    }

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
        sp = getSharedPreferences("login.dp", MODE_PRIVATE);
        WeixinEntity.ResultBean result = weixinEntity.getResult();
        SharedPreferences.Editor edit = sp.edit();
        WeixinEntity.ResultBean.UserInfoBean userInfo = result.getUserInfo();
        edit.putString("headPic",userInfo.getHeadPic());
        edit.putString("nickName",userInfo.getNickName());
        edit.putInt("uid",result.getUserId());
        edit.putString("sid",result.getSessionId());
        edit.putBoolean("b",true);
        edit.commit();
        Intent intent = new Intent(WXEntryActivity.this, Main2Activity.class);
        intent.putExtra("login",true);
        startActivity(intent);
    }

    @Override
    public void WeixinError(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }




}
