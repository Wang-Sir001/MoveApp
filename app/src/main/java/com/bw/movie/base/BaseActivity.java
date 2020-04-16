package com.bw.movie.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.base.mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * data:2020/3/16
 * author:王江伟(DJ慢羊羊)
 * function: activity层基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    public P presenter;
    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutId());
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        mBind = ButterKnife.bind(this);

        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int LayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
        if (presenter != null) {
            mBind.unbind();
        }
    }
}
