package com.bw.movie.view.activity.UserActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.model.entity.GuideIvEntity;
import com.bw.movie.view.activity.DetailActivity.DetailActivity;
import com.bw.movie.view.activity.Main2Activity;
import com.stx.xhb.androidx.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GuidePageActivity extends BaseActivity {

    @BindView(R.id.xBanner)
    XBanner xBanner;

    private List<GuideIvEntity> mGuideIvEntityList = new ArrayList<>();
    private SharedPreferences mMv_sp;

    @Override
    protected void initData() {

        mGuideIvEntityList.add(new GuideIvEntity(R.mipmap.one));
        mGuideIvEntityList.add(new GuideIvEntity(R.mipmap.two));
        mGuideIvEntityList.add(new GuideIvEntity(R.mipmap.three));
        mGuideIvEntityList.add(new GuideIvEntity(R.mipmap.forw));

        xBanner.setBannerData(mGuideIvEntityList);
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                ImageView iv = (ImageView) view;
                iv.setImageResource(mGuideIvEntityList.get(position).getRouse());
            }
        });

    }

    @Override
    protected void initView() {

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mMv_sp = getSharedPreferences("mv_sp", MODE_PRIVATE);

        boolean aBoolean = mMv_sp.getBoolean("boolean", false);

        if (aBoolean){
            Intent intent = new Intent(GuidePageActivity.this, Main2Activity.class);
            startActivity(intent);
            finish();
        }

        xBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == mGuideIvEntityList.size()-1){

                    if (mMv_sp != null){
                        mMv_sp.edit()
                                .putBoolean("boolean",true)
                                .commit();


                        Intent intent = new Intent(GuidePageActivity.this, Main2Activity.class);
                        startActivity(intent);
                        finish();
                    }
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_guide_page;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}
