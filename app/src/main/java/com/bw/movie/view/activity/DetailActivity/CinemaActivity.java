package com.bw.movie.view.activity.DetailActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.model.entity.GuanzhuEntity;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.detailEntity.CinemaDetailEntity;
import com.bw.movie.model.entity.detailEntity.CinemaPinglunEntity;
import com.bw.movie.model.entity.detailEntity.CommentsEntity;
import com.bw.movie.presenter.CinemaDetailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CinemaActivity extends BaseActivity<CinemaDetailPresenter> implements CinemaDetailContract.IView {

    @BindView(R.id.film_back)
    ImageView filmBack;
    @BindView(R.id.film_name)
    TextView filmName;
    @BindView(R.id.film_et)
    EditText filmEt;
    @BindView(R.id.film_num)
    TextView filmNum;
    @BindView(R.id.film_submit)
    Button filmSubmit;
    private int mCinemaId;
    private int mUid;
    private String mSid;
    private String mNames;

    @Override
    protected void initData() {
        filmName.setText(mNames);
    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        Intent intent = getIntent();
        mNames = intent.getStringExtra("names");
        mCinemaId = intent.getIntExtra("cinemaId", 1);

        SharedPreferences sp = getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");

            mUid = sp.getInt("uid", -1);
            mSid = sp.getString("sid", "");

        }
    }

    @Override
    protected CinemaDetailPresenter initPresenter() {
        return new CinemaDetailPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_cinema;
    }

    @Override
    public void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity) {

    }

    @Override
    public void cinemaDetailError(Throwable throwable) {

    }

    @Override
    public void cinemaPinglunSuccess(CinemaPinglunEntity cinemaPinglunEntity) {

    }

    @Override
    public void cinemaPinglunError(Throwable throwable) {

    }

    @Override
    public void cinemaWitryPinglunSuccess(CommentsEntity commentsEntity) {
        Toast.makeText(this, ""+commentsEntity.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cinemaWitryPinglunError(Throwable throwable) {

    }

    @Override
    public void followCinemaSuccess(GuanzhuEntity guanzhuEntity) {

    }

    @Override
    public void folloeCinemaError(Throwable throwable) {

    }

    @Override
    public void unfollowCinemaSuccess(GuanzhuEntity guanzhuEntity) {

    }

    @Override
    public void unfolloeCinemaError(Throwable throwable) {

    }

    @Override
    public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

    }

    @Override
    public void userfollowCinemaError(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick({R.id.film_back, R.id.film_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.film_back:
                finish();
                break;
            case R.id.film_submit:
                String s = filmEt.getText().toString();
                if (TextUtils.isEmpty(s)){
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.getCinemaWitryPinglunData(mUid,mSid,mCinemaId,s);
                break;
        }
    }
}
