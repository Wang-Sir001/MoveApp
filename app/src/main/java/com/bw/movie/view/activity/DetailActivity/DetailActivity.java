package com.bw.movie.view.activity.DetailActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.mymovie.R;
import com.bumptech.glide.Glide;
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
import com.bw.movie.view.activity.ScheduleActivity.TicketActivity;
import com.bw.movie.view.fragment.DetailFragment.FilmCriticsFragment;
import com.bw.movie.view.fragment.DetailFragment.IntroduceFragment;
import com.bw.movie.view.fragment.DetailFragment.StillFragment;
import com.bw.movie.view.fragment.DetailFragment.TrailerFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED;
import static com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED;

public class DetailActivity extends BaseActivity<DetailPresenter> implements DetailContract.IView {

    @BindView(R.id.detail_back)
    ImageView detailBack;
    @BindView(R.id.detail_name)
    TextView detailName;
    @BindView(R.id.detail_img)
    ImageView detailImg;
    @BindView(R.id.detail_movie_img)
    ImageView detailMovieImg;
    @BindView(R.id.detail_guodu)
    TextView detailGuodu;
    @BindView(R.id.pf_tv)
    TextView pfTv;
    @BindView(R.id.pl_tv)
    TextView plTv;
    @BindView(R.id.detail_movie_name)
    TextView detailMovieName;
    @BindView(R.id.detail_movie_time)
    TextView detailMovieTime;
    @BindView(R.id.detail_movie_release_time)
    TextView detailMovieReleaseTime;
    @BindView(R.id.detail_aixin)
    CheckBox detailAixin;
    @BindView(R.id.movie_re)
    RelativeLayout movieRe;
    @BindView(R.id.detail_tab)
    TabLayout detailTab;
    @BindView(R.id.detail_vp)
    ViewPager detailVp;
    @BindView(R.id.scoll_view)
    RelativeLayout scollView;
    @BindView(R.id.detail_write)
    Button detailWrite;
    @BindView(R.id.detail_xuan)
    Button detailXuan;
    List<Fragment> fglist = new ArrayList<>();
    List<String> stlist = new ArrayList<>();
    private BottomSheetBehavior<RelativeLayout> mBoottom;
    private int movieId;
    private String mName;
    private String mName1;
    private String mDuration;
    private double mScore;
    int ax = 0;
    private int mUid;
    private String mSid;


    @Override
    protected void initData() {
        mBoottom.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                if (i == STATE_EXPANDED){
                    detailWrite.setClickable(false);
                    detailXuan.setClickable(false);
                }

                if (i == STATE_COLLAPSED){
                    detailWrite.setClickable(true);
                    detailXuan.setClickable(true);
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

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

        presenter.getUserFollowMovieData(mUid,mSid,1,10);
        //隐藏标题栏
        getSupportActionBar().hide();
        //滑动控件
        mBoottom = BottomSheetBehavior.from(scollView);
        //接收电影Id
        Intent intent = getIntent();
        if (intent != null) {
            movieId = intent.getIntExtra("movieId", 0);
            presenter.getDetailData(0,"",movieId);
            //设置数据
            fglist.clear();
            stlist.clear();
            fglist.add(IntroduceFragment.getInstance(movieId));
            fglist.add(TrailerFragment.getInstance(movieId));
            fglist.add(StillFragment.getInstance(movieId));
            fglist.add(FilmCriticsFragment.getInstance(movieId));
            stlist.add("介绍");
            stlist.add("预告");
            stlist.add("剧照");
            stlist.add("影评");
            //设施适配器
            detailVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
                @NonNull
                @Override
                public Fragment getItem(int position) {
                    return fglist.get(position);
                }

                @Override
                public int getCount() {
                    return fglist.size();
                }

                @Nullable
                @Override
                public CharSequence getPageTitle(int position) {
                    return stlist.get(position);
                }
            });
            //关联tab+vp
            detailTab.setupWithViewPager(detailVp);

        }
    }

    @Override
    protected DetailPresenter initPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void DetaileSuccess(DetialEntity detialEntity) {
        DetialEntity.ResultBean result = detialEntity.getResult();
        if (result != null) {
            List<DetialEntity.ResultBean.MovieDirectorBean> movieDirector = result.getMovieDirector();
            mName1 = movieDirector.get(0).getName();
            mName = result.getName();
            detailName.setText(result.getName());
            Glide.with(detailMovieImg)
                    .load(result.getImageUrl())
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(detailMovieImg);
            pfTv.setText("评分"+result.getScore()+"分");
            plTv.setText("评论"+result.getCommentNum()+"条");
            mScore = result.getScore();
            detailMovieName.setText(result.getName());
            detailMovieTime.setText(result.getDuration());
            mDuration = result.getDuration();
            SimpleDateFormat sim = new SimpleDateFormat("yyyy年MM月dd日");
            String format = sim.format(result.getReleaseTime());
            detailMovieReleaseTime.setText(format+""+result.getPlaceOrigin());
        }



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
        Toast.makeText(this, ""+guanzhuEntity.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void folloeMovieError(Throwable throwable) {

    }

    @Override
    public void unfollowMovieSuccess(GuanzhuEntity guanzhuEntity) {
        Toast.makeText(this, ""+guanzhuEntity.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void unfolloeMovieError(Throwable throwable) {

    }

    @Override
    public void userfollowMovieSuccess(UserFollowMovieEntity userFollowMovieEntity) {
        List<UserFollowMovieEntity.ResultBean> result = userFollowMovieEntity.getResult();
        if (result != null){

            int size = result.size();
            for (int i = 0;i<size;i++){
                if (result.get(i).getMovieId() == movieId){
                    detailAixin.setChecked(true);
                    detailAixin.setText("已关注");
                    return;
                }
            }


        }

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

    @OnClick({R.id.detail_back, R.id.pf_tv, R.id.pl_tv, R.id.detail_aixin, R.id.detail_write, R.id.detail_xuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.detail_back:
                finish();
                break;
            case R.id.pf_tv:
                break;
            case R.id.pl_tv:
                break;
            case R.id.detail_aixin:
                if (detailAixin.isChecked()){
                    presenter.getFollowMovieData(mUid,mSid,movieId);
                    detailAixin.setText("已关注");
                }else {
                    presenter.getUnFollowMovieData(mUid,mSid,movieId);
                    detailAixin.setText("未关注");
                }

                break;
            case R.id.detail_write:
                Intent intent = new Intent(this,CommentActivity.class);
                intent.putExtra("mName",mName);
                intent.putExtra("mId",movieId);
                startActivity(intent);
                break;
            case R.id.detail_xuan:
                Intent intent1 = new Intent(DetailActivity.this, TicketActivity.class);
                intent1.putExtra("movieId",movieId);
                intent1.putExtra("daoyan",mName1);
                intent1.putExtra("name",mName);
                intent1.putExtra("time",mDuration);
                intent1.putExtra("price",mScore);

                startActivity(intent1);
                break;
        }
    }
}
