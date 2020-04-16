package com.bw.movie.view.activity.SearchActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.SearchContract;
import com.bw.movie.model.adapter.SearchAdapter.MovieSearchAdapter;
import com.bw.movie.model.entity.SearchEntity.CinemaSearchEntity;
import com.bw.movie.model.entity.SearchEntity.MovieSearchEntity;
import com.bw.movie.presenter.MovieSearchPresenter;
import com.bw.movie.view.activity.DetailActivity.DetailActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MovieSearchActivity extends BaseActivity<MovieSearchPresenter> implements SearchContract.IView {

    @BindView(R.id.mv_sou_back)
    ImageView mvSouBack;
    @BindView(R.id.mv_movie_et)
    EditText mvMovieEt;
    @BindView(R.id.mv_movie_sousuo)
    ImageView mvMovieSousuo;
    @BindView(R.id.mv_movie_rc)
    RecyclerView mvMovieRc;
    @BindView(R.id.sm)
    SmartRefreshLayout sm;
    @BindView(R.id.mv_movie_sou_null)
    ImageView mvMovieSouNull;

    int page=1;
    int count=5;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //隐藏标题栏
        getSupportActionBar().hide();
        mvMovieRc.setLayoutManager(new LinearLayoutManager(this));

        sm.setEnableLoadMore(true);
        sm.setEnableRefresh(true);

        sm.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                String s = mvMovieEt.getText().toString();
                if (TextUtils.isEmpty(s)){
                    Toast.makeText(MovieSearchActivity.this, "搜素为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.getMovieSearchData(s,page,count);

                sm.finishRefresh();
            }
        });

        sm.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                String s = mvMovieEt.getText().toString();
                if (TextUtils.isEmpty(s)){
                    Toast.makeText(MovieSearchActivity.this, "搜素为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.getMovieSearchData(s,page,count);
                sm.finishLoadMore();
            }
        });

    }

    @Override
    protected MovieSearchPresenter initPresenter() {
        return new MovieSearchPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_movie_search;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick({R.id.mv_sou_back, R.id.mv_movie_sousuo, R.id.mv_movie_sou_null})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mv_sou_back:
                finish();
                break;
            case R.id.mv_movie_sousuo:
                String s = mvMovieEt.getText().toString();
                if (TextUtils.isEmpty(s)){
                    Toast.makeText(MovieSearchActivity.this, "搜素为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.getMovieSearchData(s,page,count);
                break;
            case R.id.mv_movie_sou_null:
                break;
        }
    }

    @Override
    public void MovieSearchSuccess(MovieSearchEntity movieSearchEntity) {
        String status = movieSearchEntity.getMessage();
        if (TextUtils.equals("未查到相关电影",status)){
            mvMovieSouNull.setVisibility(View.VISIBLE);
            mvMovieRc.setVisibility(View.GONE);
        }else {
            mvMovieRc.setVisibility(View.VISIBLE);
            mvMovieSouNull.setVisibility(View.GONE);
        }
        List<MovieSearchEntity.ResultBean> result = movieSearchEntity.getResult();
        MovieSearchAdapter movieSearchAdapter = new MovieSearchAdapter(result);mvMovieRc.setAdapter(movieSearchAdapter);

        movieSearchAdapter.setOnClickListener(new MovieSearchAdapter.OnClickListener() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(MovieSearchActivity.this, DetailActivity.class);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void MovieSearchError(Throwable throwable) {

    }

    @Override
    public void CinemaSearchSuccess(CinemaSearchEntity cinemaSearchEntity) {

    }

    @Override
    public void CinemaSearchError(Throwable throwable) {

    }
}
