package com.bw.movie.view.fragment.MyFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.MyContract;
import com.bw.movie.model.adapter.MyAdapter.MovieCommentAdapter;
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

/**
 * date:2020/4/8 0008
 * function:
 */
public class MovieCommentFragment extends BaseFragment<MyPresenter> implements MyContract.IView {

    @BindView(R.id.comment_rc)
    RecyclerView commentRc;
    @BindView(R.id.nu)
    ImageView nu;
    int page=1;
    private int mUid;
    private String mSid;

    @Override
    protected void initView() {
        commentRc.setLayoutManager(new LinearLayoutManager(getContext()));
        SharedPreferences sp = getActivity().getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");

            mUid = sp.getInt("uid", -1);
            mSid = sp.getString("sid", "");

        }
        presenter.getMyMovieCommentData(mUid,mSid,page,10);
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_movie_comment;
    }

    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initData() {

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
        List<MyMovieCommentEntity.ResultBean> result = myMovieCommentEntity.getResult();
        if (result != null) {
            nu.setVisibility(View.GONE);
            commentRc.setVisibility(View.VISIBLE);
            MovieCommentAdapter movieCommentAdapter = new MovieCommentAdapter(result);
            commentRc.setAdapter(movieCommentAdapter);
        }else {
            nu.setVisibility(View.VISIBLE);
            commentRc.setVisibility(View.GONE);
        }
    }

    @Override
    public void MyMovieCommentError(Throwable throwable) {
        Log.i("souter",throwable.getMessage());
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
}
