package com.bw.movie.view.fragment.HomeFragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.entity.CityBean;
import com.bw.movie.model.entity.XBannerEntity;
import com.bw.movie.model.entity.dengluEntity.RegEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.JjsyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.RmdyEntity;
import com.bw.movie.model.entity.dianyingliebiaoEntity.ZzsyEntity;
import com.bw.movie.presenter.HomePresenter;
import com.bw.movie.util.LocationUtils;
import com.bw.movie.view.activity.SearchActivity.CinemaSearchActivity;
import com.bw.movie.view.fragment.MoveFragment.FujinFragment;
import com.bw.movie.view.fragment.MoveFragment.TuijianFragment;
import com.bw.movie.view.fragment.MoveFragment.TwoItemFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoveFragment extends BaseFragment<HomePresenter> implements HomeContract.IView {

    @BindView(R.id.move_dingwei)
    ImageView moveDingwei;
    @BindView(R.id.move_sousuo)
    ImageView moveSousuo;
    @BindView(R.id.Move_tab)
    TabLayout MoveTab;
    @BindView(R.id.Move_vp)
    ViewPager MoveVp;

    List<Fragment> mFragments = new ArrayList<>();
    List<String> mStrings = new ArrayList<>();
    @BindView(R.id.home_tv)
    TextView homeTv;

    @Override
    protected void initView() {

    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_move;
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {

        FujinFragment fujinFragment = new FujinFragment();
        TuijianFragment tuijianFragment = new TuijianFragment();
        TwoItemFragment twoItemFragment = new TwoItemFragment();

        mFragments.add(tuijianFragment);
        mFragments.add(fujinFragment);
        mFragments.add(twoItemFragment);

        mStrings.add("推荐影院");
        mStrings.add("附近影院");
        mStrings.add("地区");

        MoveVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mStrings.get(position);
            }
        });

        MoveTab.setupWithViewPager(MoveVp);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick({R.id.move_dingwei, R.id.move_sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.move_dingwei:
                String citys = LocationUtils.getInstance().getCity(getActivity());
                Log.i("logs", citys);
                presenter.getCityData(citys, "json", "s4YosA4Q6CygoFPF7I0GGSwaUaVjRbqI");
                break;
            case R.id.move_sousuo:
                Intent intent = new Intent(getActivity(), CinemaSearchActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void ZzsySuccess(ZzsyEntity zzsyEntity) {

    }

    @Override
    public void ZzsyError(Throwable throwable) {

    }

    @Override
    public void JjsySuccess(JjsyEntity jjsyEntity) {

    }

    @Override
    public void JjsyError(Throwable throwable) {

    }

    @Override
    public void RmdySuccess(RmdyEntity rmdyEntity) {

    }

    @Override
    public void RmdyError(Throwable throwable) {

    }

    @Override
    public void XBannersSuccess(XBannerEntity xBannerEntity) {

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

    }

    @Override
    public void ReserveError(Throwable throwable) {

    }
}
