package com.bw.movie.view.activity.DetailActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
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

import org.greenrobot.greendao.annotation.Id;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentActivity extends BaseActivity<DetailPresenter> implements DetailContract.IView {

    @BindView(R.id.film_back)
    ImageView filmBack;
    @BindView(R.id.film_name)
    TextView filmName;
    @BindView(R.id.film_ping)
    TextView filmPing;
    @BindView(R.id.film_ratingbar)
    RatingBar filmRatingbar;
    @BindView(R.id.film_et)
    EditText filmEt;
    @BindView(R.id.film_num)
    TextView filmNum;
    @BindView(R.id.film_submit)
    Button filmSubmit;
    private String mName;
    private double pricce;
    private int mId;
    private int mUid;
    private String mSid;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mName = intent.getStringExtra("mName");
        filmName.setText(mName);
        mId = intent.getIntExtra("mId",1);

        filmRatingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               filmPing.setText("我的评分("+rating+")");
               pricce = rating;
           }
       });
    }

    @Override
    protected void initView() {
        SharedPreferences sp = getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");

            mUid = sp.getInt("uid", -1);
            mSid = sp.getString("sid", "");

        }
    }

    @Override
    protected DetailPresenter initPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_comment;
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
        Toast.makeText(this, commentsEntity.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void CommentsError(Throwable throwable) {
        Toast.makeText(this, ""+throwable, Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.film_back, R.id.film_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.film_back:
                finish();
                break;
            case R.id.film_submit:
                String s = filmEt.getText().toString();
                if (TextUtils.isEmpty(s)){
                    Toast.makeText(this, "评论不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.i("pricces",pricce+"");
                float rating = filmRatingbar.getRating();
                presenter.getCommentsData(mUid,mSid,mId,s,rating);
                break;
        }
    }
}
