package com.bw.movie.view.activity.MyActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.MyContract;
import com.bw.movie.model.adapter.MyAdapter.AllSysMsgAdabter;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.UserFollowMovieEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.myEntity.AllSysMshEntity;
import com.bw.movie.model.entity.myEntity.MyCinemaCommentEntity;
import com.bw.movie.model.entity.myEntity.MyMovieCommentEntity;
import com.bw.movie.model.entity.myEntity.MyxinxiEntity;
import com.bw.movie.model.entity.myEntity.UserReserveEntity;
import com.bw.movie.presenter.MyPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllSysMsgActivity extends BaseActivity<MyPresenter> implements MyContract.IView {

    @BindView(R.id.allMsg_back)
    ImageView allMsgBack;
    @BindView(R.id.allMsg_recy)
    RecyclerView allMsgRecy;
    private int mUid;
    private String mSid;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        SharedPreferences sp = getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");

            mUid = sp.getInt("uid", -1);
            mSid = sp.getString("sid", "");

        }

        allMsgRecy.setLayoutManager(new LinearLayoutManager(this));

        presenter.getallSysMsgData(mUid,mSid,1,20);
    }

    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_all_sys_msg;
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
        List<AllSysMshEntity.ResultBean> result = allSysMshEntity.getResult();
        if (result != null){
            AllSysMsgAdabter allSysMsgAdabter = new AllSysMsgAdabter(result);
            allMsgRecy.setAdapter(allSysMsgAdabter);
        }

    }

    @Override
    public void allSysMsgError(Throwable throwable) {
        Log.i("allsyss",throwable.getMessage());
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

    @OnClick(R.id.allMsg_back)
    public void onViewClicked() {
        finish();
    }
}
