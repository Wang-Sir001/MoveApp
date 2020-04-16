package com.bw.movie.view.fragment.MyFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.MyContract;
import com.bw.movie.model.adapter.MyAdapter.MovieAttentionAdabter;
import com.bw.movie.model.entity.UserFollowCinemaEntity;
import com.bw.movie.model.entity.UserFollowMovieEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.myEntity.AllSysMshEntity;
import com.bw.movie.model.entity.myEntity.MyCinemaCommentEntity;
import com.bw.movie.model.entity.myEntity.MyMovieCommentEntity;
import com.bw.movie.model.entity.myEntity.MyxinxiEntity;
import com.bw.movie.model.entity.myEntity.UserReserveEntity;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.view.activity.DetailActivity.DetailActivity;

import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieAttentionFragment extends BaseFragment<MyPresenter> implements MyContract.IView {

    @BindView(R.id.attentionMovie_recy)
    RecyclerView attentionMovieRecy;
    private int mUid;
    private String mSid;

    @Override
    protected void initView() {
        SharedPreferences sp = getActivity().getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");

            mUid = sp.getInt("uid", -1);
            mSid = sp.getString("sid", "");

        }

        attentionMovieRecy.setLayoutManager(new LinearLayoutManager(getActivity()));

        presenter.getUserFollowMovieData(mUid,mSid,1,20);
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_movie_attention;
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
        List<UserFollowMovieEntity.ResultBean> result = userFollowMovieEntity.getResult();
        if (result != null) {
            MovieAttentionAdabter movieAttentionAdabter = new MovieAttentionAdabter(result);
            attentionMovieRecy.setAdapter(movieAttentionAdabter);

            movieAttentionAdabter.notifyDataSetChanged();

            movieAttentionAdabter.setOnClickItemList(new MovieAttentionAdabter.OnClickItemList() {
                @Override
                public void onClick(int movieId) {
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("movieId",movieId);
                    startActivity(intent);
                }
            });
        }


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
