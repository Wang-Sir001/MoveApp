package com.bw.movie.view.activity.MyActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.mymovie.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
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

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserXinXiActivity extends BaseActivity<MyPresenter> implements MyContract.IView {

    @BindView(R.id.xinxi_back)
    ImageView xinxiBack;
    @BindView(R.id.xinxi_Name)
    TextView xinxiName;
    @BindView(R.id.xinxi_xingbie)
    TextView xinxiXingbie;
    @BindView(R.id.xinxi_rq)
    TextView xinxiRq;
    @BindView(R.id.xinxi_email)
    TextView xinxiEmail;
    @BindView(R.id.xinxi_img)
    ImageView xinxiImg;
    private int mUid;
    private String mSid;

    @Override
    protected void initData() {
        presenter.getUserInfoData(mUid, mSid);
    }

    @Override
    protected void initView() {
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
        return R.layout.activity_user_xin_xi;
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
        MyxinxiEntity.ResultBean result = myxinxiEntity.getResult();
        Glide.with(xinxiImg)
                .load(result.getHeadPic())
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(xinxiImg);
        xinxiName.setText(result.getNickName());
        if (result.getSex() == 1){
            xinxiXingbie.setText("男");
        }else {
            xinxiXingbie.setText("女");
        }
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        String format = sim.format(result.getLastLoginTime());
        xinxiRq.setText(format);

        xinxiEmail.setText(result.getEmail());
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

    @OnClick(R.id.xinxi_back)
    public void onViewClicked() {
        finish();
    }
}
