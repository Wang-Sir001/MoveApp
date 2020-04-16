package com.bw.movie.view.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bumptech.glide.Glide;
import com.bw.movie.app.App;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.DetailContract;
import com.bw.movie.model.adapter.ChooseAdapter;
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
import com.bw.movie.util.MD5Util;
import com.bw.movie.widget.CommItemDecoration;
import com.bw.movie.widget.SeatView;
import com.bw.movie.wxapi.WXUtils;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 选座界面
 * 拥有影院ID和影片ID
 */
public class ChooseSeatActivity extends BaseActivity<DetailPresenter> implements DetailContract.IView {

    @BindView(R.id.choose_back)
    ImageView chooseBack;
    @BindView(R.id.choose_name)
    TextView chooseName;
    @BindView(R.id.movie_re)
    RelativeLayout movieRe;
    @BindView(R.id.choose_JC)
    JCVideoPlayerStandard chooseJC;
    @BindView(R.id.seat_view)
    SeatView seatView;
    @BindView(R.id.choose_tv)
    TextView chooseTv;
    @BindView(R.id.choose_recycler)
    RecyclerView chooseRecycler;
    @BindView(R.id.choose_pay)
    TextView choosePay;
    @BindView(R.id.cancel)
    TextView cancel;
    @BindView(R.id.wx)
    RadioButton wx;
    @BindView(R.id.zfb)
    RadioButton zfb;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.pay_rl)
    RelativeLayout payRl;
    private int mUid;
    private String mSid;
    private int mMovieId;
    private int mCinemaId;
    private String mName;
    private List<ChooseActivityBean.ResultBean> mList = new ArrayList<>();
    private ChooseAdapter mChooseAdapter;
    private SharedPreferences sp;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        Intent intent = getIntent();
        mCinemaId = intent.getIntExtra("cinemaId", 1);
        mMovieId = intent.getIntExtra("movieId", 1);
        mName = intent.getStringExtra("name");

        sp = getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");

            mUid = sp.getInt("uid", -1);
            mSid = sp.getString("sid", "");

        }

        chooseName.setText(mName);

        presenter.getDetailData(mUid, mSid, mMovieId);
        presenter.getchooseData(mMovieId, mCinemaId);

        seatView.setSeatViewCallBack(new SeatView.SeatViewCallBack() {
            @Override
            public void turnPrice(double price) {
                if (price == 0) {
                    choosePay.setText("请先选座");
                } else {
                    choosePay.setText("$" + price);
                }
            }
        });

        CommItemDecoration horizontal = CommItemDecoration.createHorizontal(this, getResources().getColor(R.color.dark), getResources().getDimensionPixelOffset(R.dimen.dp_5));
        chooseRecycler.addItemDecoration(horizontal);
        chooseRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mChooseAdapter = new ChooseAdapter(mList, this);
        chooseRecycler.setAdapter(mChooseAdapter);
        mChooseAdapter.setChooseItemCallBack(new ChooseAdapter.ChooseItemCallBack() {
            @Override
            public void chooseItemClick(int position, int chooseIndex) {
                if (position == chooseIndex) {//重复单击事件不做处理
                    return;
                }
                seatView.setScheduleId(mList.get(position).getId());//重新设置排期id
                seatView.setFare(mList.get(position).getFare());//重新设置单价
                seatView.setNum(0);
                //设置选中item的视觉改变
                mChooseAdapter.setChooseIndex(position);
                mChooseAdapter.notifyDataSetChanged();
                int hallId = mList.get(position).getHallId();

                //发起获取影厅对应座位信息的请求
                presenter.getseatData(hallId);

                choosePay.setText("请先选座");
            }
        });
        choosePay.setText("请先选座");
    }

    @Override
    protected void initView() {
        //隐藏标题
        getSupportActionBar().hide();
    }

    @Override
    protected DetailPresenter initPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_choose_seat;
    }

    @Override
    public void DetaileSuccess(DetialEntity detialEntity) {

        DetialEntity.ResultBean result = detialEntity.getResult();
        List<DetialEntity.ResultBean.ShortFilmListBean> shortFilmList = result.getShortFilmList();
        chooseJC.setUp(shortFilmList.get(0).getVideoUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
        Glide.with(this).load(shortFilmList.get(0).getImageUrl()).into(chooseJC.thumbImageView);
        chooseJC.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
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
        List<ChooseActivityBean.ResultBean> result = chooseActivityBean.getResult();
        mList.clear();
        mList.addAll(result);
        mChooseAdapter.setChooseIndex(0);//默认第一个选中
        mChooseAdapter.notifyDataSetChanged();
        chooseTv.setText("选择影厅和时间(" + mList.size() + ")");
        seatView.setFare(result.get(0).getFare());//设置默认影厅的单价
        seatView.setScheduleId(result.get(0).getId());//设置默认的排期id

        int hallId = result.get(0).getHallId();
        presenter.getseatData(hallId);

    }

    @Override
    public void chooseError(Throwable throwable) {

    }

    @Override
    public void seatSuccess(SeatBean seatBean) {
        List<SeatBean.ResultBean> result = seatBean.getResult();
        seatView.setSeatInfo(result);
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
        String orderId = buyBean.getOrderId();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.wx:
                        AlertDialog.Builder builder = new AlertDialog.Builder(ChooseSeatActivity.this);
                        builder.setTitle("请确认支付");
                        builder.setMessage("确认使用微信支付");
                        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //微信支付
                                presenter.getPayData(mUid,mSid,1,orderId);
                            }
                        });
                        builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 调到购票页面
                                /*Intent intent = new Intent(SelectedSeatActivity.this, BuyTicketsRecordActivity.class);
                                startActivity(intent);*/
                            }
                        });
                        builder.show();
                        break;
                    case R.id.zfb:
                        AlertDialog.Builder zfb = new AlertDialog.Builder(ChooseSeatActivity.this);
                        zfb.setTitle("请确认支付");
                        zfb.setMessage("确认使用支付宝支付");
                        zfb.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //支付宝支付

                                presenter.getPayData(mUid,mSid,2,orderId);
                            }
                        });
                        zfb.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 调到购票页面
                              /*  Intent intent = new Intent(SelectedSeatActivity.this, BuyTicketsRecordActivity.class);
                                startActivity(intent);*/
                            }
                        });
                        zfb.show();
                        break;
                }
            }
        });
    }

    @Override
    public void BuyError(Throwable throwable) {

    }

    @Override
    public void PaySuccess(PayBean payBean) {
        String appId = payBean.getAppId();//应用id
        String nonceStr = payBean.getNonceStr();//随机字符串
        String packageValue = payBean.getPackageValue();//扩展字段
        String partnerId = payBean.getPartnerId();//微信支付商户号
        String prepayId = payBean.getPrepayId();//支付凭证
        String sign = payBean.getSign();//签名
        String timeStamp = payBean.getTimeStamp();//时间戳
        if (WXUtils.success(App.getmContext())) {//判断用户是否安装过微信
            //注册应用
            App.sIWXAPI.registerApp(appId);
            PayReq payReq = new PayReq();
            payReq.appId=appId;
            Log.e("appId",appId);
            payReq.nonceStr=nonceStr;
            payReq.packageValue=packageValue;
            payReq.partnerId=partnerId;
            payReq.prepayId=prepayId;
            payReq.sign=sign;
            payReq.timeStamp=""+timeStamp;
            payRl.setVisibility(View.GONE);
            chooseRecycler.setVisibility(View.VISIBLE);
            //发起请求
            App.sIWXAPI.sendReq(payReq);
        }else {
            Toast.makeText(this, "请先安装微信!", Toast.LENGTH_SHORT).show();
        }
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

    @OnClick({R.id.choose_back, R.id.seat_view, R.id.choose_pay, R.id.cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.choose_back:
                finish();
                break;
            case R.id.seat_view:
                break;
            case R.id.choose_pay:
                if (TextUtils.equals("请先选座",choosePay.getText().toString().trim())){
                    Toast.makeText(this, "请先选座", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    payRl.setVisibility(View.VISIBLE);
                    chooseRecycler.setVisibility(View.GONE);
                }

                String paySeat = seatView.getPaySeat();
                int scheduleId1 = seatView.getScheduleId();
                String scheduleId = String.valueOf(seatView.getScheduleId());
                if (sp.getBoolean("b", false)) {
                    String userId = String.valueOf(sp.getInt("uid", -1));
                    //获取sign
                    String sign = MD5Util.getInstance().MD5(userId + scheduleId + "movie");
                    presenter.getBuyData(mUid,mSid,scheduleId1,paySeat,sign);
                } else {
                    Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case R.id.cancel:

                payRl.setVisibility(View.GONE);
                chooseRecycler.setVisibility(View.VISIBLE);
                break;
        }
    }
}
