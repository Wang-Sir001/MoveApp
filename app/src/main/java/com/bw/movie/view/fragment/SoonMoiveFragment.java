package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.DetailContract;
import com.bw.movie.model.adapter.DetailAdapter.BuyBean;
import com.bw.movie.model.adapter.DetailAdapter.PayBean;
import com.bw.movie.model.adapter.SoonMovieAdabter;
import com.bw.movie.model.entity.GuanzhuEntity;
import com.bw.movie.model.entity.SoonMoiveEntity;
import com.bw.movie.model.entity.UserFollowMovieEntity;
import com.bw.movie.model.entity.detailEntity.CommentEntity;
import com.bw.movie.model.entity.detailEntity.CommentsEntity;
import com.bw.movie.model.entity.detailEntity.DetialEntity;
import com.bw.movie.model.entity.detailEntity.FindCinemasEntity;
import com.bw.movie.model.entity.detailEntity.FindDataEntity;
import com.bw.movie.model.entity.detailEntity.FindcinemasPriceEntity;
import com.bw.movie.model.entity.detailEntity.RegionCityEntity;
import com.bw.movie.model.entity.seat.ChooseActivityBean;
import com.bw.movie.model.entity.seat.SeatBean;
import com.bw.movie.presenter.DetailPresenter;
import com.bw.movie.view.activity.ChooseSeatActivity;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SoonMoiveFragment extends BaseFragment<DetailPresenter> implements DetailContract.IView {

    @BindView(R.id.soon_recy)
    RecyclerView soonRecy;
    private int mCinemaId;

    @Override
    protected void initView() {
        soonRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        Bundle arguments = getArguments();
        mCinemaId = arguments.getInt("cinemaId");
        presenter.getSoonMovieData(mCinemaId,1,10);
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_soon_moive;
    }

    @Override
    protected DetailPresenter initPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void DetaileSuccess(DetialEntity detialEntity) {

    }

    @Override
    public void DetailError(Throwable throwable) {

    }

    @Override
    public void CommentSuccess(CommentEntity commentEntity) {

    }

    @Override
    public void CommentError(Throwable throwable) {

    }

    @Override
    public void CommentsSuccess(CommentsEntity commentsEntity) {

    }

    @Override
    public void CommentsError(Throwable throwable) {

    }

    @Override
    public void regionCitySuccess(RegionCityEntity regionCityEntity) {

    }

    @Override
    public void regionCity(Throwable throwable) {

    }

    @Override
    public void findDataSuccess(FindDataEntity findDataEntity) {

    }

    @Override
    public void findDataError(Throwable throwable) {

    }

    @Override
    public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {

    }

    @Override
    public void findcinemasError(Throwable throwable) {

    }

    @Override
    public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {

    }

    @Override
    public void findcinemasPriceError(Throwable throwable) {

    }

    @Override
    public void chooseSuccess(ChooseActivityBean chooseActivityBean) {

    }

    @Override
    public void chooseError(Throwable throwable) {

    }

    @Override
    public void seatSuccess(SeatBean seatBean) {

    }

    @Override
    public void seatError(Throwable throwable) {

    }

    @Override
    public void soonMovieSuccess(SoonMoiveEntity soonMoiveEntity) {
        List<SoonMoiveEntity.ResultBean> result = soonMoiveEntity.getResult();
        if (result == null){
            return;
        }
        SoonMovieAdabter soonMovieAdabter = new SoonMovieAdabter(result);
        soonRecy.setAdapter(soonMovieAdabter);

        soonMovieAdabter.setOnClickItemList(new SoonMovieAdabter.OnClickItemList() {
            @Override
            public void onClick(int moiveId, String name) {
                Intent intent = new Intent(getActivity(), ChooseSeatActivity.class);
                intent.putExtra("cinemaId",mCinemaId);
                intent.putExtra("movieId",moiveId);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }

    @Override
    public void soonMovieError(Throwable throwable) {

    }

    @Override
    public void followMovieSuccess(GuanzhuEntity guanzhuEntity) {

    }

    @Override
    public void folloeMovieError(Throwable throwable) {

    }

    @Override
    public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {

    }

    @Override
    public void unfolloeMovieError(Throwable throwable) {

    }

    @Override
    public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {

    }

    @Override
    public void userfollowMovieError(Throwable throwable) {

    }

    @Override
    public void BuySuccess(BuyBean buyBean) {

    }

    @Override
    public void BuyError(Throwable throwable) {

    }

    @Override
    public void PaySuccess(PayBean payBean) {

    }

    @Override
    public void PayError(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    public static SoonMoiveFragment getInstance(int cinemaId) {
        SoonMoiveFragment soonMoiveFragment = new SoonMoiveFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("cinemaId",cinemaId);
        soonMoiveFragment.setArguments(bundle);
        return soonMoiveFragment;
    }
}
