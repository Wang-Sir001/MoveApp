package com.bw.movie.view.fragment.HomeFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.model.adapter.MyAdapter.MyHomeAdapter;
import com.bw.movie.util.NetUtils;
import com.bw.movie.view.activity.MyActivity.AllSysMsgActivity;
import com.bw.movie.view.activity.MyActivity.FeedBackActivity;
import com.bw.movie.view.activity.MyActivity.SetActivity;
import com.bw.movie.view.activity.MyActivity.UserAppointmentActivity;
import com.bw.movie.view.activity.MyActivity.UserAttentionActivity;
import com.bw.movie.view.activity.MyActivity.UserCommentActivity;
import com.bw.movie.view.activity.MyActivity.UserXinXiActivity;
import com.bw.movie.view.activity.UserActivity.LogActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {

    @BindView(R.id.info)
    ImageView info;
    @BindView(R.id.my_login)
    RelativeLayout myLogin;
    @BindView(R.id.my_headerPic)
    ImageView myHeaderPic;
    @BindView(R.id.my_myselfxx)
    ImageView myMyselfxx;
    @BindView(R.id.my_iviv)
    ImageView myIviv;
    @BindView(R.id.dypgd)
    ImageView dypgd;
    @BindView(R.id.my_moviePiao)
    RelativeLayout myMoviePiao;
    @BindView(R.id.my_rc)
    RecyclerView myRc;
    @BindView(R.id.my_Names)
    TextView myNames;
    private MyHomeAdapter mMyHomeAdapter;

    @Override
    protected void initView() {

    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

        myRc.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mMyHomeAdapter = new MyHomeAdapter();
        myRc.setAdapter(mMyHomeAdapter);

        mMyHomeAdapter.setOnClickListener(new MyHomeAdapter.OnClickListener() {
            @Override
            public void OnClick(int i) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent(getActivity(), UserAttentionActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), UserAppointmentActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        Intent intent2 = new Intent(getActivity(), UserCommentActivity.class);
                        startActivity(intent2);
                        break;
                    case 5:
                        Intent intent3 = new Intent(getActivity(), FeedBackActivity.class);
                        startActivity(intent3);
                        break;
                    case 6:
                        Intent intent4 = new Intent(getActivity(), SetActivity.class);
                        startActivity(intent4);
                        break;
                }
            }
        });

        SharedPreferences sp = getActivity().getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        if (sp.getBoolean("b", false)) {
            String headPic = sp.getString("headPic", "");
            String nickName = sp.getString("nickName", "");
            int uid = sp.getInt("uid", -1);
            String sid = sp.getString("sid", "");
            NetUtils.getInstance().getpho(headPic, myHeaderPic);
            myNames.setText(nickName);
        }

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick({R.id.my_login, R.id.my_headerPic, R.id.my_myselfxx, R.id.my_moviePiao,R.id.info,R.id.dypgd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_login:
                Intent intent = new Intent(getActivity(), LogActivity.class);
                startActivity(intent);
                break;
            case R.id.my_headerPic:
                break;
            case R.id.my_myselfxx:
                Intent intent1 = new Intent(getActivity(), UserXinXiActivity.class);
                startActivity(intent1);

                break;
            case R.id.my_moviePiao:
                break;
            case R.id.info:
                Intent intent2 = new Intent(getActivity(), AllSysMsgActivity.class);
                startActivity(intent2);
                break;
            case R.id.dypgd:

                break;
        }
    }
}
