package com.bw.movie.view.activity.ScheduleActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bumptech.glide.Glide;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.DetailContract;
import com.bw.movie.model.adapter.DetailAdapter.BuyBean;
import com.bw.movie.model.adapter.DetailAdapter.FindCinemasAdapter;
import com.bw.movie.model.adapter.DetailAdapter.FindCinemasPriceAdapter;
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
import com.bw.movie.view.activity.ChooseSeatActivity;
import com.bw.movie.view.activity.DetailActivity.CinemaDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class TicketActivity extends BaseActivity<DetailPresenter> implements DetailContract.IView {

    @BindView(R.id.ticket_JC)
    JCVideoPlayerStandard ticketJC;
    @BindView(R.id.ticket_back)
    ImageView ticketBack;
    @BindView(R.id.ticket_name)
    TextView ticketName;
    @BindView(R.id.ticket_time)
    TextView ticketTime;
    @BindView(R.id.ticket_price)
    TextView ticketPrice;
    @BindView(R.id.ticket_daoyan)
    TextView ticketDaoyan;
    @BindView(R.id.ticket_Spinner01)
    AppCompatSpinner ticketSpinner01;
    @BindView(R.id.ticket_Spinner02)
    AppCompatSpinner ticketSpinner02;
    @BindView(R.id.ticket_rll)
    LinearLayout ticketRll;
    @BindView(R.id.ticket_recy)
    RecyclerView ticketRecy;
    @BindView(R.id.ss)
    TextView ss;
    private int mMovieId;
    private double mPrice;
    private String mDaoyan;
    private String mName;
    private String mTime;
    private int mUid;
    private String mSid;
    List<String> diqu = new ArrayList<>();
    List<String> times = new ArrayList<>();
    private int mRegionId;
    private String mTime1;

    @Override
    protected void initData() {
        presenter.getDetailData(mUid, mSid, mMovieId);
        ticketName.setText(mName);
        ticketTime.setText(mTime);
        ticketPrice.setText(mPrice + "分");
        ticketDaoyan.setText(mDaoyan);

        presenter.getRegionCityData();
        presenter.getfindDataData();
//        presenter.getfindcinemasData(mMovieId,1,1,10);

        ticketRecy.setLayoutManager(new LinearLayoutManager(this));
//        presenter.getfindcinemasPriceData(mMovieId,1,10);
    }

    @Override
    protected void initView() {
        //隐藏标题栏
        getSupportActionBar().hide();
        Intent intent = getIntent();
        mMovieId = intent.getIntExtra("movieId", 1);
        mPrice = intent.getDoubleExtra("price", 1);
        mDaoyan = intent.getStringExtra("daoyan");
        mName = intent.getStringExtra("name");
        mTime = intent.getStringExtra("time");

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
        return R.layout.activity_ticket;
    }

    @Override
    public void DetaileSuccess(DetialEntity detialEntity) {
        DetialEntity.ResultBean result = detialEntity.getResult();
        List<DetialEntity.ResultBean.ShortFilmListBean> shortFilmList = result.getShortFilmList();

        ticketJC.setUp(shortFilmList.get(0).getVideoUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
        Glide.with(this).load(shortFilmList.get(0).getImageUrl()).into(ticketJC.thumbImageView);
        ticketJC.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
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
        List<RegionCityEntity.ResultBean> result = regionCityEntity.getResult();
        diqu.clear();
        for (int i = 0; i < result.size(); i++) {
            diqu.add(result.get(i).getRegionName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, diqu);
        adapter.setDropDownViewResource(R.layout.item_tab1);
        ticketSpinner01.setAdapter(adapter);
        ticketSpinner01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view;
                v.setTextColor(Color.WHITE);
                v.setTextSize(25);
                mRegionId = result.get(position).getRegionId();
                presenter.getfindcinemasData(mMovieId, mRegionId, 1, 10);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void regionCity(Throwable throwable) {

    }

    @Override
    public void findDataSuccess(FindDataEntity findDataEntity) {
        List<String> result = findDataEntity.getResult();
        times.clear();
        for (int i = 0; i < result.size(); i++) {
            times.add(result.get(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, times);
        adapter.setDropDownViewResource(R.layout.item_tab1);
        ticketSpinner02.setAdapter(adapter);
        ticketSpinner02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view;
                v.setTextColor(Color.WHITE);
                v.setTextSize(25);
                mTime1 = times.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void findDataError(Throwable throwable) {

    }

    @Override
    public void findcinemasSuccess(FindCinemasEntity findCinemasEntity) {
        if (findCinemasEntity.getMessage().equals("无数据")) {
            Toast.makeText(this, "本地区没有影院可以播放电影", Toast.LENGTH_SHORT).show();
        }
        List<FindCinemasEntity.ResultBean> result = findCinemasEntity.getResult();
        FindCinemasAdapter findCinemasAdapter = new FindCinemasAdapter(result);
        ticketRecy.setAdapter(findCinemasAdapter);
        if (findCinemasAdapter != null) {
            findCinemasAdapter.notifyDataSetChanged();
        }
        findCinemasAdapter.setOnClickItemList(new FindCinemasAdapter.OnClickItemList() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(TicketActivity.this, ChooseSeatActivity.class);
                intent.putExtra("movieId", mMovieId);
                intent.putExtra("cinemaId",movieId);
                intent.putExtra("name",mName);
                startActivity(intent);
            }
        });

    }

    @Override
    public void findcinemasError(Throwable throwable) {

    }

    @Override
    public void findcinemasPriceSuccess(FindcinemasPriceEntity findcinemasPriceEntity) {
        List<FindcinemasPriceEntity.ResultBean> result = findcinemasPriceEntity.getResult();
        FindCinemasPriceAdapter adapter = new FindCinemasPriceAdapter(result);
        ticketRecy.setAdapter(adapter);
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        //点击影院选座
        adapter.setOnClickItemList(new FindCinemasPriceAdapter.OnClickItemList() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(TicketActivity.this, CinemaDetailActivity.class);
                intent.putExtra("cinemaId", movieId);
                startActivity(intent);
            }
        });

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

    @OnClick({R.id.ticket_back, R.id.ss})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ticket_back:
                finish();
                break;
            case R.id.ss:
                presenter.getfindcinemasPriceData(mMovieId,1,10);
                break;
        }
    }
}
