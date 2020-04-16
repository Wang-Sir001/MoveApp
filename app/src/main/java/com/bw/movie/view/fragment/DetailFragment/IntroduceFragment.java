package com.bw.movie.view.fragment.DetailFragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.DetailContract;
import com.bw.movie.model.adapter.DetailAdapter.BuyBean;
import com.bw.movie.model.adapter.DetailAdapter.DaoYanAdapter;
import com.bw.movie.model.adapter.DetailAdapter.PayBean;
import com.bw.movie.model.adapter.DetailAdapter.YanYuanAdapter;
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

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroduceFragment extends BaseFragment<DetailPresenter> implements DetailContract.IView {

    @BindView(R.id.introduce_juqing)
    TextView introduceJuqing;
    @BindView(R.id.introduce_tv_daoyan)
    TextView introduceTvDaoyan;
    @BindView(R.id.introduce_daoyan)
    RecyclerView introduceDaoyan;
    @BindView(R.id.introduce_tv_yanyuan)
    TextView introduceTvYanyuan;
    @BindView(R.id.introduce_yanyuan)
    RecyclerView introduceYanyuan;
    private int mMovieId;

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        mMovieId = arguments.getInt("movieId");
        introduceDaoyan.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        introduceYanyuan.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_introduce;
    }

    @Override
    protected DetailPresenter initPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void initData() {
        presenter.getDetailData(0, "", mMovieId);
    }

    public static IntroduceFragment getInstance(int movieId) {
        IntroduceFragment introduceFragment = new IntroduceFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("movieId", movieId);
        introduceFragment.setArguments(bundle);

        return introduceFragment;

    }

    @Override
    public void DetaileSuccess(DetialEntity detialEntity) {


        DetialEntity.ResultBean result = detialEntity.getResult();
        List<DetialEntity.ResultBean.MovieDirectorBean> movieDirector = result.getMovieDirector();
        List<DetialEntity.ResultBean.MovieActorBean> movieActor = result.getMovieActor();
        introduceTvDaoyan.setText("导演("+result.getMovieDirector().size()+")");
        introduceTvYanyuan.setText("演员("+result.getMovieActor().size()+")");
        DaoYanAdapter daoYanAdapter = new DaoYanAdapter(movieDirector);
        introduceDaoyan.setAdapter(daoYanAdapter);
        YanYuanAdapter yanYuanAdapter = new YanYuanAdapter(movieActor);
        introduceYanyuan.setAdapter(yanYuanAdapter);
        introduceJuqing.setText(result.getSummary());
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
}
