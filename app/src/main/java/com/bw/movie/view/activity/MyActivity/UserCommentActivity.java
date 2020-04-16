package com.bw.movie.view.activity.MyActivity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.view.fragment.MyFragment.CinemaCommentFragment;
import com.bw.movie.view.fragment.MyFragment.MovieCommentFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用户的评论界面
 */
public class UserCommentActivity extends BaseActivity {
    List<Fragment> fg = new ArrayList<>();
    List<String> st = new ArrayList<>();
    @BindView(R.id.attention_back)
    ImageView attentionBack;
    @BindView(R.id.attention_tab)
    TabLayout attentionTab;
    @BindView(R.id.attention_vp)
    ViewPager attentionVp;

    @Override
    protected void initData() {
        fg.clear();
        st.clear();
        st.add("电影");
        st.add("影院");
        fg.add(new MovieCommentFragment());
        fg.add(new CinemaCommentFragment());
        attentionVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fg.get(position);
            }

            @Override
            public int getCount() {
                return fg.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return st.get(position);
            }
        });

        attentionTab.setupWithViewPager(attentionVp);
    }

    @Override
    protected void initView() {

        //隐藏标题栏
        getSupportActionBar().hide();
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_user_comment;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick(R.id.attention_back)
    public void onViewClicked() {
        finish();
    }
}
