package com.bw.movie.view.fragment.DetailFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.DetailContract;
import com.bw.movie.model.adapter.DetailAdapter.BuyBean;
import com.bw.movie.model.adapter.DetailAdapter.CommentAdapter;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class FilmCriticsFragment extends BaseFragment<DetailPresenter> implements DetailContract.IView {

    @BindView(R.id.comment_recy)
    RecyclerView commentRecy;
    private int mMovieId;
    private int mUid;
    private String mSid;

    @Override
    protected void initView() {

        Bundle arguments = getArguments();
        mMovieId = arguments.getInt("movieId");
        commentRecy.setLayoutManager(new LinearLayoutManager(getActivity()));

        SharedPreferences sp = getActivity().getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");

            mUid = sp.getInt("uid", -1);
            mSid = sp.getString("sid", "");

        }

        presenter.getCommentData(mUid,mSid,mMovieId,1,10);

    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_film_critics;
    }

    @Override
    protected DetailPresenter initPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void initData() {
//        presenter.getCommentData(13761,"158555796306513761",22,1,10);
    }

    public static FilmCriticsFragment getInstance(int movieId) {

        FilmCriticsFragment filmCriticsFragment = new FilmCriticsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("movieId", movieId);
        filmCriticsFragment.setArguments(bundle);

        return filmCriticsFragment;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void DetaileSuccess(DetialEntity detialEntity) {

    }

    @Override
    public void DetailError(Throwable throwable) {

    }

    @Override
    public void CommentSuccess(CommentEntity commentEntity) {
        Log.i("coment",commentEntity.getMessage());
        List<CommentEntity.ResultBean> result = commentEntity.getResult();
        if (result != null) {
            CommentAdapter commentAdapter = new CommentAdapter(result);
            commentRecy.setAdapter(commentAdapter);
        }

    }

    @Override
    public void CommentError(Throwable throwable) {
        Toast.makeText(getActivity(), ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
        Log.i("erroster",throwable.getMessage()+"");
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
}
