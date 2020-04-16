package com.bw.movie.view.activity.DetailActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.model.entity.GuanzhuEntity;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.detailEntity.CinemaDetailEntity;
import com.bw.movie.model.entity.detailEntity.CinemaPinglunEntity;
import com.bw.movie.model.entity.detailEntity.CommentsEntity;
import com.bw.movie.presenter.CinemaDetailPresenter;
import com.bw.movie.view.activity.SoonMovieActivity;
import com.bw.movie.view.fragment.CinemaDetailFragment.CinemaDetailFragment;
import com.bw.movie.view.fragment.CinemaDetailFragment.CinemaPinglunFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CinemaDetailActivity extends BaseActivity<CinemaDetailPresenter> implements CinemaDetailContract.IView {

    @BindView(R.id.cinemaDetail_back)
    ImageView cinemaDetailBack;
    @BindView(R.id.cinemaDetail_Name)
    TextView cinemaDetailName;
    @BindView(R.id.cinemaDetail_aixin)
    CheckBox cinemaDetailAixin;

    @BindView(R.id.cinemaDetail_dzl)
    TextView cinemaDetailDzl;
    @BindView(R.id.cinemaDetail_tab)
    TabLayout cinemaDetailTab;
    @BindView(R.id.cinemaDetail_vp)
    ViewPager cinemaDetailVp;
    @BindView(R.id.cinemaDetail_write)
    Button cinemaDetailWrite;
    @BindView(R.id.cinemaDetail_paiqi)
    Button cinemaDetailPaiqi;
    @BindView(R.id.cinemaDetail_label1)
    TextView cinemaDetailLabel1;
    @BindView(R.id.cinemaDetail_label2)
    TextView cinemaDetailLabel2;
    @BindView(R.id.cinemaDetail_label3)
    TextView cinemaDetailLabel3;
    @BindView(R.id.cinemaDetail_label4)
    TextView cinemaDetailLabel4;
    private int mUid;
    int ax;
    private String mSid;
    List<Fragment> mFrameLayouts = new ArrayList<>();
    List<String> mStrings = new ArrayList<>();
    int a=0;
    private int mCinemaId;
    private String mName;

    @Override
    protected void initData() {

        presenter.getCinemaDetailData(mUid, mSid, mCinemaId);
        presenter.getUserFollowCinemaData(mUid,mSid,1,10);

        mFrameLayouts.add(CinemaDetailFragment.getInstance(mCinemaId));
        mFrameLayouts.add(CinemaPinglunFragment.getInstance(mCinemaId));

        mStrings.add("影院详情");
        mStrings.add("影院评价");

        cinemaDetailVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFrameLayouts.get(position);
            }

            @Override
            public int getCount() {
                return mFrameLayouts.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mStrings.get(position);
            }
        });

        cinemaDetailTab.setupWithViewPager(cinemaDetailVp);

    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        SharedPreferences sp = getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");

            mUid = sp.getInt("uid", -1);
            mSid = sp.getString("sid", "");

        }
        Intent intent = getIntent();
        mCinemaId = intent.getIntExtra("cinemaId", 1);
    }

    @Override
    protected CinemaDetailPresenter initPresenter() {
        return new CinemaDetailPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_cinema_detail;
    }

    @Override
    public void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity) {
        CinemaDetailEntity.ResultBean result = cinemaDetailEntity.getResult();
        mName = result.getName();
        cinemaDetailName.setText(result.getName());
        String label = result.getLabel();
        String[] split = label.split(",");
        for (String i : split){
            a++;
            if (a == 1){
                cinemaDetailLabel1.setText(i);
                cinemaDetailLabel1.setVisibility(View.VISIBLE);
            }
            if (a == 2){
                cinemaDetailLabel2.setText(i);
                cinemaDetailLabel2.setVisibility(View.VISIBLE);
            }
            if (a == 3){
                cinemaDetailLabel3.setText(i);
                cinemaDetailLabel3.setVisibility(View.VISIBLE);
            }
            if (a == 4){
                cinemaDetailLabel4.setText(i);
                cinemaDetailLabel4.setVisibility(View.VISIBLE);
            }
        }


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

    }

    @Override
    public void cinemaWitryPinglunError(Throwable throwable) {

    }

    @Override
    public void followCinemaSuccess(GuanzhuEntity guanzhuEntity) {
        Toast.makeText(this, ""+guanzhuEntity.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void folloeCinemaError(Throwable throwable) {

    }

    @Override
    public void unfollowCinemaSuccess(GuanzhuEntity guanzhuEntity) {
        Toast.makeText(this, ""+guanzhuEntity.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void unfolloeCinemaError(Throwable throwable) {

    }

    @Override
    public void userfollowCinemaSuccess(UserFollowCinemaEntity userFollowCinemaEntity) {
        List<UserFollowCinemaEntity.ResultBean> result = userFollowCinemaEntity.getResult();
        if (result != null){
            int size = result.size();
            Log.i("sizess",size+"");
            for (int i=0;i<size;i++){
                if (result.get(i).getCinemaId() == mCinemaId){
                    cinemaDetailAixin.setChecked(true);
                    cinemaDetailAixin.setText("已关注");
                    return;
                }
            }
        }


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

    @OnClick({R.id.cinemaDetail_back, R.id.cinemaDetail_aixin, R.id.cinemaDetail_write, R.id.cinemaDetail_paiqi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cinemaDetail_back:
                finish();
                break;
            case R.id.cinemaDetail_aixin:
                if (cinemaDetailAixin.isChecked()){
                    presenter.getFollowCinemaData(mUid,mSid,mCinemaId);
                }else {
                    presenter.getUnFollowCinemaData(mUid,mSid,mCinemaId);
                }
                break;
            case R.id.cinemaDetail_write:
                Intent intent = new Intent(CinemaDetailActivity.this,CinemaActivity.class);
                intent.putExtra("cinemaId",mCinemaId);
                intent.putExtra("names",mName);
                startActivity(intent);
                break;
            case R.id.cinemaDetail_paiqi:
                Intent intent1 = new Intent(CinemaDetailActivity.this, SoonMovieActivity.class);
                intent1.putExtra("cinemaId",mCinemaId);
                startActivity(intent1);
                break;
        }
    }
}
