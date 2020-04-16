package com.bw.movie.view.fragment.MoveFragment;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.YingyuanContract;
import com.bw.movie.model.adapter.MoveAdapter.FujinAdabter;
import com.bw.movie.model.entity.yingyuanEntity.FujinEntity;
import com.bw.movie.model.entity.yingyuanEntity.TuijianEntity;
import com.bw.movie.model.entity.yingyuanEntity.TwoItemEntity;
import com.bw.movie.presenter.MovePresenter;
import com.bw.movie.view.activity.DetailActivity.CinemaDetailActivity;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FujinFragment extends BaseFragment<MovePresenter> implements YingyuanContract.IView {

    @BindView(R.id.fujin_recy)
    RecyclerView fujinRecy;

    @Override
    protected void initView() {
        fujinRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_fujin;
    }

    @Override
    protected MovePresenter initPresenter() {
        return new MovePresenter();
    }

    @Override
    protected void initData() {
        presenter.getFujinData(0, null, null, null, 1, 10);
    }

    @Override
    public void FujinSuccess(FujinEntity fujinEntity) {
        List<FujinEntity.ResultBean> result = fujinEntity.getResult();
        FujinAdabter fujinAdabter = new FujinAdabter(result);
        fujinRecy.setAdapter(fujinAdabter);

        fujinAdabter.setOnClickItemList(new FujinAdabter.OnClickItemList() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getActivity(), CinemaDetailActivity.class);
                intent.putExtra("cinemaId",movieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void FujinError(Throwable throwable) {

    }

    @Override
    public void TuijianSuccess(TuijianEntity tuijianEntity) {

    }

    @Override
    public void TuijianError(Throwable throwable) {

    }

    @Override
    public void TwoItemSuccess(TwoItemEntity twoItemEntity) {

    }

    @Override
    public void TwoItemError(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
