package com.bw.movie.view.fragment.DetailFragment;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bawei.mymovie.R;
import com.bumptech.glide.Glide;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.DetailContract;
import com.bw.movie.model.adapter.DetailAdapter.BuyBean;
import com.bw.movie.model.adapter.DetailAdapter.PayBean;
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
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrailerFragment extends BaseFragment<DetailPresenter> implements DetailContract.IView {


    @BindView(R.id.JVPlayer1)
    JCVideoPlayerStandard JVPlayer1;
    @BindView(R.id.JVPlayer2)
    JCVideoPlayerStandard JVPlayer2;
    @BindView(R.id.JVPlayer3)
    JCVideoPlayerStandard JVPlayer3;
    private int mMovieId;

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        mMovieId = arguments.getInt("movieId");
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_trailer;
    }

    @Override
    protected DetailPresenter initPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void initData() {

        presenter.getDetailData(0,"",mMovieId);
    }

    public static TrailerFragment getInstance(int movieId) {

        TrailerFragment trailerFragment = new TrailerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("movieId", movieId);
        trailerFragment.setArguments(bundle);

        return trailerFragment;
    }

    @Override
    public void DetaileSuccess(DetialEntity detialEntity) {
        /*JCVideoPlayer jCVideoPlayer = (JCVideoPlayer) findViewById(R.id.videocontroller);
        videoController.setUp("视频/MP3地址","视频/MP3标题");
        videoController.ivThumb.setThumbInCustomProject("视频/MP3缩略图地址");*/
        DetialEntity.ResultBean result = detialEntity.getResult();
        List<DetialEntity.ResultBean.ShortFilmListBean> shortFilmList = result.getShortFilmList();

        JVPlayer1.setUp(shortFilmList.get(0).getVideoUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
        Glide.with(getActivity()).load(shortFilmList.get(0).getImageUrl()).into(JVPlayer1.thumbImageView);
        JVPlayer1.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        JVPlayer2.setUp(shortFilmList.get(1).getVideoUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
        Glide.with(getActivity()).load(shortFilmList.get(1).getImageUrl()).into(JVPlayer2.thumbImageView);
        JVPlayer2.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        JVPlayer3.setUp(shortFilmList.get(2).getVideoUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
        Glide.with(getActivity()).load(shortFilmList.get(2).getImageUrl()).into(JVPlayer3.thumbImageView);
        JVPlayer3.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
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
