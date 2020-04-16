package com.bw.movie.view.fragment.HomeFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.adapter.HomeAdapter.JjsyAdabter;
import com.bw.movie.model.adapter.HomeAdapter.RmdyAdabter;
import com.bw.movie.model.adapter.HomeAdapter.ZgjzAdabter;
import com.bw.movie.model.adapter.HomeAdapter.ZzsyAdabter;
import com.bw.movie.model.entity.CityBean;
import com.bw.movie.model.entity.XBannerEntity;
import com.bw.movie.model.entity.XBannersEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.JjsyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.RmdyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.ZzsyEntity;
import com.bw.movie.presenter.HomePresenter;
import com.bw.movie.util.LocationUtils;
import com.bw.movie.util.NetUtils;
import com.bw.movie.view.activity.DetailActivity.DetailActivity;
import com.bw.movie.view.activity.SearchActivity.MovieSearchActivity;
import com.stx.xhb.androidx.XBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.IView {

    @BindView(R.id.dingwei)
    ImageView dingwei;
    @BindView(R.id.sousuo)
    ImageView sousuo;
    @BindView(R.id.xBanners)
    XBanner xBanners;
    @BindView(R.id.zzsygd)
    TextView zzsygd;
    @BindView(R.id.zzsy)
    RecyclerView zzsy;
    @BindView(R.id.jjsygd)
    TextView jjsygd;
    @BindView(R.id.jjsy)
    RecyclerView jjsy;
    @BindView(R.id.rmdygd)
    TextView rmdygd;
    @BindView(R.id.rmdy)
    RecyclerView rmdy;
    @BindView(R.id.popular_image_h)
    RecyclerView popularImageH;
    @BindView(R.id.home_tv)
    TextView homeTv;
    private List<XBannersEntity> mXBannersEntityArrayList = new ArrayList<>();
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

        zzsy.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        jjsy.setLayoutManager(new LinearLayoutManager(getActivity()));
        rmdy.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        popularImageH.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        presenter.getXBannersData();
        presenter.getZzsyData(1, 10);
        presenter.getJjsyData(1, 10);
        presenter.getRmdyData(1, 10);




    }

    @Override
    public void ZzsySuccess(ZzsyEntity zzsyEntity) {
        Log.i("xxx", zzsyEntity.getMessage());
        List<ZzsyEntity.ResultBean> zzsyEntityResult = zzsyEntity.getResult();
        ZzsyAdabter zzsyAdabter = new ZzsyAdabter(zzsyEntityResult);
        zzsy.setAdapter(zzsyAdabter);
        zzsyAdabter.setOnClickItemList(new ZzsyAdabter.OnClickItemList() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });

    }

    @Override
    public void ZzsyError(Throwable throwable) {

    }

    @Override
    public void JjsySuccess(JjsyEntity jjsyEntity) {
        List<JjsyEntity.ResultBean> result = jjsyEntity.getResult();
        JjsyAdabter jjsyAdabter = new JjsyAdabter(result);
        jjsy.setAdapter(jjsyAdabter);
        jjsyAdabter.setOnClickItemList(new JjsyAdabter.OnClickItemList() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });

        jjsyAdabter.setOnClickItemYuyue(new JjsyAdabter.OnClickItemYuyue() {
            @Override
            public void onClickest(int movieId) {
                presenter.getReserveData(mUid,mSid,movieId);
            }
        });

    }

    @Override
    public void JjsyError(Throwable throwable) {

    }

    @Override
    public void RmdySuccess(RmdyEntity rmdyEntity) {
        List<RmdyEntity.ResultBean> result = rmdyEntity.getResult();
        RmdyAdabter rmdyAdabter = new RmdyAdabter(result);

        rmdy.setAdapter(rmdyAdabter);

        rmdyAdabter.setOnClickItemList(new RmdyAdabter.OnClickItemList() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void RmdyError(Throwable throwable) {

    }

    @Override
    public void XBannersSuccess(XBannerEntity xBannerEntity) {
        List<XBannerEntity.ResultBean> result = xBannerEntity.getResult();
        ZgjzAdabter zgjzAdabter = new ZgjzAdabter(result);
        popularImageH.setAdapter(zgjzAdabter);
        xBanners.setBannerData(result);
        xBanners.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                NetUtils.getInstance().getpho(result.get(position).getImageUrl(), (ImageView) view);
            }
        });

        zgjzAdabter.setOnClickItemList(new ZgjzAdabter.OnClickItemList() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void XBannersError(Throwable throwable) {

    }

    @Override
    public void CitySuccess(CityBean cityBean) {

        CityBean.ResultBean result = cityBean.getResult();
        CityBean.ResultBean.AddressComponentBean addressComponent = result.getAddressComponent();
        String city = addressComponent.getCity();

        homeTv.setText(city);
    }

    @Override
    public void CityError(Throwable throwable) {

    }

    @Override
    public void ReserveSuccess(RegEntity regEntity) {
        Toast.makeText(getActivity(), ""+regEntity.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ReserveError(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick({R.id.dingwei, R.id.sousuo, R.id.zzsygd, R.id.jjsygd, R.id.rmdygd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dingwei:
                String citys = LocationUtils.getInstance().getCity(getActivity());
                Log.i("logs",citys);
                presenter.getCityData(citys,"json","s4YosA4Q6CygoFPF7I0GGSwaUaVjRbqI");
                break;
            case R.id.sousuo:
                Intent intent = new Intent(getActivity(), MovieSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.zzsygd:
                break;
            case R.id.jjsygd:
                break;
            case R.id.rmdygd:
                break;
        }
    }
}
