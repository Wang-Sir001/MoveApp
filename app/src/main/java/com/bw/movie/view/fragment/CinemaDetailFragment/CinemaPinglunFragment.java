package com.bw.movie.view.fragment.CinemaDetailFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.model.adapter.DetailAdapter.CinemaPinglunAdapter;
import com.bw.movie.model.entity.GuanzhuEntity;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.detailEntity.CinemaDetailEntity;
import com.bw.movie.model.entity.detailEntity.CinemaPinglunEntity;
import com.bw.movie.model.entity.detailEntity.CommentsEntity;
import com.bw.movie.presenter.CinemaDetailPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CinemaPinglunFragment extends BaseFragment<CinemaDetailPresenter> implements CinemaDetailContract.IView {

    @BindView(R.id.cinema_pinglun)
    RecyclerView cinemaPinglun;
    @BindView(R.id.cinema_sm)
    SmartRefreshLayout cinemaSm;
    private int mCinemaId;
    private int mUid;
    private String mSid;
    int page = 1;
    int count = 5;

    @Override
    protected void initView() {

        Bundle arguments = getArguments();
        mCinemaId = arguments.getInt("cinemaId");
        SharedPreferences sp = getActivity().getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");

            mUid = sp.getInt("uid", -1);
            mSid = sp.getString("sid", "");

        }

        cinemaPinglun.setLayoutManager(new LinearLayoutManager(getActivity()));

        cinemaSm.setEnableRefresh(true);
        cinemaSm.setEnableLoadMore(true);

        cinemaSm.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                presenter.getCinemaPinglunData(mUid,mSid,mCinemaId,page,count);
                cinemaSm.finishRefresh();
            }
        });

        cinemaSm.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                presenter.getCinemaPinglunData(mUid,mSid,mCinemaId,page,count);
                cinemaSm.finishLoadMore();
            }
        });
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_cinema_pinglun;
    }

    @Override
    protected CinemaDetailPresenter initPresenter() {
        return new CinemaDetailPresenter();
    }

    @Override
    protected void initData() {


        presenter.getCinemaPinglunData(mUid,mSid,mCinemaId,page,count);

    }

    public static CinemaPinglunFragment getInstance(int cinemaId) {
        CinemaPinglunFragment cinemaPinglunFragment = new CinemaPinglunFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("cinemaId", cinemaId);
        cinemaPinglunFragment.setArguments(bundle);
        return cinemaPinglunFragment;
    }

    @Override
    public void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity) {

    }

    @Override
    public void cinemaDetailError(Throwable throwable) {

    }

    @Override
    public void cinemaPinglunSuccess(CinemaPinglunEntity cinemaPinglunEntity) {
        List<CinemaPinglunEntity.ResultBean> result = cinemaPinglunEntity.getResult();
        CinemaPinglunAdapter cinemaPinglunAdapter = new CinemaPinglunAdapter(result);
        cinemaPinglun.setAdapter(cinemaPinglunAdapter);
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
}
