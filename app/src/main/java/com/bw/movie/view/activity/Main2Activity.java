package com.bw.movie.view.activity;

import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.view.fragment.HomeFragment.HomeFragment;
import com.bw.movie.view.fragment.HomeFragment.MoveFragment;
import com.bw.movie.view.fragment.HomeFragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class Main2Activity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rg)
    RadioGroup rg;

    List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void initData() {

        HomeFragment homeFragment = new HomeFragment();
        MoveFragment moveFragment = new MoveFragment();
        MyFragment myFragment = new MyFragment();

        mFragments.add(homeFragment);
        mFragments.add(moveFragment);
        mFragments.add(myFragment);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                vp.setCurrentItem(0);
                break;
            case R.id.rb2:
                vp.setCurrentItem(1);
                break;
            case R.id.rb3:
                vp.setCurrentItem(2);
                break;
        }
    }
}
