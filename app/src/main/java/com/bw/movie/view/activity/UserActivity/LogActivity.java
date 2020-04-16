package com.bw.movie.view.activity.UserActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
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
import com.bw.movie.util.EncryptUtil;
import com.bw.movie.view.activity.Main2Activity;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import butterknife.BindView;
import butterknife.OnClick;

public class LogActivity extends BaseActivity<UserPresenter> implements UserContract.IView {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.wang_pwd_but)
    Button wangPwdBut;
    @BindView(R.id.zhuce_tv)
    TextView zhuceTv;
    @BindView(R.id.log_but)
    Button logBut;
    @BindView(R.id.log_weixin)
    ImageButton logWeixin;
    private SharedPreferences sp;

    @Override
    protected void initData() {
        getSupportActionBar().hide();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected UserPresenter initPresenter() {
        return new UserPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_log;
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
        String status = logEntity.getStatus();
        LogEntity.ResultBean result = logEntity.getResult();
        if (result != null) {
            sp = getSharedPreferences("login.dp", MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("headPic",result.getUserInfo().getHeadPic());
            edit.putString("nickName",result.getUserInfo().getNickName());
            edit.putInt("uid",result.getUserId());
            edit.putString("sid",result.getSessionId());
            edit.putBoolean("b",true);
            edit.commit();
        }
        if (status.equals("0000")){
            Intent intent = new Intent(LogActivity.this, Main2Activity.class);
            Toast.makeText(this, ""+logEntity.getMessage(), Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }
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

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick({R.id.wang_pwd_but, R.id.zhuce_tv, R.id.log_but, R.id.log_weixin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wang_pwd_but:
                break;
            case R.id.zhuce_tv:
                Intent intent = new Intent(LogActivity.this, RegActivity.class);
                startActivity(intent);
                break;
            case R.id.log_but:
                String email = etPhone.getText().toString();
                String pwd = etPwd.getText().toString();

                String encrypt = EncryptUtil.encrypt(pwd);
                Log.i("xxx",encrypt+"");

                presenter.getLogData(email,encrypt+"");

                break;
            case R.id.log_weixin:
                if (!App.sIWXAPI.isWXAppInstalled()) {
                    return;
                }

                final SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "diandi_wx_login";
                App.sIWXAPI.sendReq(req);
                break;
        }
    }
}
