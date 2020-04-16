package com.bw.movie.view.activity.MyActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.MyContract;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.UserFollowMovieEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.myEntity.AllSysMshEntity;
import com.bw.movie.model.entity.myEntity.MyCinemaCommentEntity;
import com.bw.movie.model.entity.myEntity.MyMovieCommentEntity;
import com.bw.movie.model.entity.myEntity.MyxinxiEntity;
import com.bw.movie.model.entity.myEntity.UserReserveEntity;
import com.bw.movie.presenter.MyPresenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedBackActivity extends BaseActivity<MyPresenter> implements MyContract.IView {
    @BindView(R.id.fk_back)
    ImageView fkBack;
    @BindView(R.id.fk_et)
    EditText fkEt;
    @BindView(R.id.fk_bt)
    Button fkBt;
    @BindView(R.id.success)
    RelativeLayout success;
    private int mUid;
    private String mSid;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //隐藏标题栏
        getSupportActionBar().hide();

        SharedPreferences sp = getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");

            mUid = sp.getInt("uid", -1);
            mSid = sp.getString("sid", "");

        }
    }

    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_feed_back;
    }

    @Override
    public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

    }

    @Override
    public void userfollowMovieError(Throwable throwable) {

    }

    @Override
    public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {

    }

    @Override
    public void userfollowCinemaError(Throwable throwable) {

    }

    @Override
    public void UserReserveSuccess(UserReserveEntity userReserveEntity) {

    }

    @Override
    public void UserReserveError(Throwable throwable) {

    }

    @Override
    public void MyMovieCommentSuccess(MyMovieCommentEntity myMovieCommentEntity) {

    }

    @Override
    public void MyMovieCommentError(Throwable throwable) {

    }

    @Override
    public void MyCinemaCommentSuccess(MyCinemaCommentEntity myCinemaCommentEntity) {

    }

    @Override
    public void MyCinemaCommentError(Throwable throwable) {

    }

    @Override
    public void feedBackSuccess(RegEntity regEntity) {
        String status = regEntity.getStatus();
        if (status.equals("0000")){
            success.setVisibility(View.VISIBLE);
            fkEt.setVisibility(View.GONE);
            fkBt.setVisibility(View.GONE);
        }
    }

    @Override
    public void feedBackError(Throwable throwable) {

    }

    @Override
    public void allSysMsgSuccess(AllSysMshEntity allSysMshEntity) {

    }

    @Override
    public void allSysMsgError(Throwable throwable) {

    }

    @Override
    public void changeSysMsgSuccess(RegEntity regEntity) {

    }

    @Override
    public void changeSysMsgError(Throwable throwable) {

    }

    @Override
    public void UserInfoSuccess(MyxinxiEntity myxinxiEntity) {

    }

    @Override
    public void UserInfoError(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
    @OnClick({R.id.fk_back, R.id.fk_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fk_back:
                finish();
                break;
            case R.id.fk_bt:
                String content = fkEt.getText().toString().trim();
                if (TextUtils.isEmpty(content)){
                    Toast.makeText(this, "意见不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

//                mPresenter.postDoParams(MyUrls.BASE_FEEDBACK, FeedBackBean.class,map);
                presenter.getfeedBackData(mUid,mSid,content);
                break;
        }
    }
}
