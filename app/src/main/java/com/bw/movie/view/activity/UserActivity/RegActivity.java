package com.bw.movie.view.activity.UserActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.UserContract;
import com.bw.movie.model.entity.dengluEntity.LogEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dengluEntity.WeixinEntity;
import com.bw.movie.model.entity.dengluEntity.YzmEntity;
import com.bw.movie.presenter.UserPresenter;
import com.bw.movie.util.EncryptUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class RegActivity extends BaseActivity<UserPresenter> implements UserContract.IView {

    @BindView(R.id.Reg_name)
    EditText RegName;
    @BindView(R.id.Reg_email)
    EditText RegEmail;
    @BindView(R.id.Reg_pwd)
    EditText RegPwd;
    @BindView(R.id.Reg_yzm)
    EditText RegYzm;
    @BindView(R.id.Reg_but_yzm)
    Button RegButYzm;
    @BindView(R.id.Reg_zc_tv)
    TextView RegZcTv;
    @BindView(R.id.Reg_but)
    Button RegBut;

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
        return R.layout.activity_reg;
    }

    @Override
    public void YzmSuccess(YzmEntity yzmEntity) {

    }

    @Override
    public void YzmError(Throwable throwable) {

    }

    @Override
    public void RegSuccess(RegEntity regEntity) {
        Toast.makeText(this, ""+regEntity.getMessage(), Toast.LENGTH_SHORT).show();
        if (regEntity.getStatus().equals("0000")){
            Intent intent = new Intent(RegActivity.this, LogActivity.class);
            startActivity(intent);
        }
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

    @OnClick({R.id.Reg_but_yzm, R.id.Reg_zc_tv, R.id.Reg_but})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Reg_but_yzm:

                String s = RegEmail.getText().toString();

                presenter.getYzmData(s);
                break;
            case R.id.Reg_zc_tv:
                Intent intent = new Intent(RegActivity.this, LogActivity.class);
                startActivity(intent);
                break;
            case R.id.Reg_but:
                String s1 = RegName.getText().toString();
                String s2 = RegEmail.getText().toString();
                String s3 = RegPwd.getText().toString();
                String s4 = RegYzm.getText().toString();

                String encrypt = EncryptUtil.encrypt(s3);
                Log.i("TAG",encrypt+"");

                presenter.getRegData(s1,encrypt,s2,s4);
                break;
        }
    }
}
