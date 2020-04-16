package com.bw.movie.view.activity.SearchActivity;

import android.os.Bundle;
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
import com.bw.movie.model.adapter.SearchAdapter.CinemaSearchAdapter;
import com.bw.movie.model.entity.SearchEntity.CinemaSearchEntity;
import com.bw.movie.model.entity.SearchEntity.MovieSearchEntity;
import com.bw.movie.presenter.MovieSearchPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CinemaSearchActivity extends BaseActivity<MovieSearchPresenter> implements SearchContract.IView {


    int page = 1;
    int count = 2;
    @BindView(R.id.clinema_sou_back)
    ImageView clinemaSouBack;
    @BindView(R.id.mv_clinema_et)
    EditText mvClinemaEt;
    @BindView(R.id.mv_clinema_sousuo)
    ImageView mvClinemaSousuo;
    @BindView(R.id.mv_clinema_rc)
    RecyclerView mvClinemaRc;
    @BindView(R.id.sm_clinema)
    SmartRefreshLayout smClinema;
    @BindView(R.id.mv_clinema_sou_null)
    ImageView mvClinemaSouNull;

    @Override
    protected void initData() {
        presenter.getCinemaSearchData(page, count, "");
    }

    @Override
    protected void initView() {
        //隐藏标题栏
        getSupportActionBar().hide();
        mvClinemaRc.setLayoutManager(new LinearLayoutManager(this));

        smClinema.setEnableLoadMore(true);
        smClinema.setEnableRefresh(true);

        smClinema.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                String s = mvClinemaEt.getText().toString();
//                presenter.getMovieSearchData("", page, count);
                presenter.getCinemaSearchData(page,count,s);
                smClinema.finishRefresh();
            }
        });

        smClinema.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                String s = mvClinemaEt.getText().toString();
                presenter.getCinemaSearchData(page,count,s);
                smClinema.finishLoadMore();
            }
        });

    }

    @Override
    protected MovieSearchPresenter initPresenter() {
        return new MovieSearchPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_clinema_search;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @Override
    public void MovieSearchSuccess(MovieSearchEntity movieSearchEntity) {

    }

    @Override
    public void MovieSearchError(Throwable throwable) {

    }

    @Override
    public void CinemaSearchSuccess(CinemaSearchEntity cinemaSearchEntity) {
        List<CinemaSearchEntity.ResultBean> result = cinemaSearchEntity.getResult();
        if (result.size() == 0) {
            mvClinemaSouNull.setVisibility(View.VISIBLE);
            mvClinemaRc.setVisibility(View.GONE);
        } else {
            mvClinemaRc.setVisibility(View.VISIBLE);
            mvClinemaSouNull.setVisibility(View.GONE);
        }

        CinemaSearchAdapter cinemaSearchAdapter = new CinemaSearchAdapter(result);
        mvClinemaRc.setAdapter(cinemaSearchAdapter);

    }

    @Override
    public void CinemaSearchError(Throwable throwable) {

    }

    @OnClick({R.id.clinema_sou_back, R.id.mv_clinema_sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.clinema_sou_back:
                finish();
                break;
            case R.id.mv_clinema_sousuo:
                String s = mvClinemaEt.getText().toString();
                if (TextUtils.isEmpty(s)){
                    Toast.makeText(CinemaSearchActivity.this, "搜素为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.getCinemaSearchData(page,count,s);
                break;
        }
    }
}
