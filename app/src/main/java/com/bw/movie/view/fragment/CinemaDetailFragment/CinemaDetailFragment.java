package com.bw.movie.view.fragment.CinemaDetailFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.model.entity.GuanzhuEntity;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.detailEntity.CinemaDetailEntity;
import com.bw.movie.model.entity.detailEntity.CinemaPinglunEntity;
import com.bw.movie.model.entity.detailEntity.CommentsEntity;
import com.bw.movie.presenter.CinemaDetailPresenter;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CinemaDetailFragment extends BaseFragment<CinemaDetailPresenter> implements CinemaDetailContract.IView {

    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.dt)
    TextView dt;
    @BindView(R.id.dts)
    TextView dts;
    @BindView(R.id.gj)
    TextView gj;
    @BindView(R.id.gjs)
    TextView gjs;
    @BindView(R.id.zj)
    TextView zj;
    @BindView(R.id.zjs)
    TextView zjs;
    private int mUid;
    private String mSid;

    @Override
    protected void initView() {

    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_cinema_detail;
    }

    @Override
    protected CinemaDetailPresenter initPresenter() {
        return new CinemaDetailPresenter();
    }

    @Override
    protected void initData() {

        Bundle arguments = getArguments();
        int cinemaId = arguments.getInt("cinemaId", 1);
        SharedPreferences sp = getActivity().getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");

            mUid = sp.getInt("uid", -1);
            mSid = sp.getString("sid", "");

        }

        presenter.getCinemaDetailData(mUid, mSid, cinemaId);

    }

    public static CinemaDetailFragment getInstance(int cinemaId) {
        CinemaDetailFragment cinemaDetailFragment = new CinemaDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("cinemaId", cinemaId);
        cinemaDetailFragment.setArguments(bundle);

        return cinemaDetailFragment;

    }

    @Override
    public void cinemaDetailSuccess(CinemaDetailEntity cinemaDetailEntity) {
        CinemaDetailEntity.ResultBean result = cinemaDetailEntity.getResult();
        dizhi.setText(result.getAddress());
        phone.setText(result.getPhone());
        String vehicleRoute = result.getVehicleRoute();
        String[] split = vehicleRoute.split("；");
        for (String i:split) {
            Log.i("xxxs",i);
            Log.i("xxs",i);

            if (i.indexOf("地铁") != -1) {


                dt.setText("地铁:");
                dts.setText(i);
                dt.setVisibility(View.VISIBLE);
                dts.setVisibility(View.VISIBLE);

            }
            if (i.indexOf("公交") != -1) {


                gj.setText("公交车:");
                gjs.setText(i);
                gj.setVisibility(View.VISIBLE);
                gjs.setVisibility(View.VISIBLE);


            }
            if (i.indexOf("自驾") != -1) {


                zj.setText("自驾:");
                zjs.setText(i);
                zj.setVisibility(View.VISIBLE);
                zjs.setVisibility(View.VISIBLE);

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
