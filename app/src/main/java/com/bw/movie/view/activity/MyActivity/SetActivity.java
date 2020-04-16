package com.bw.movie.view.activity.MyActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.util.DataCleanManager;
import com.bw.movie.view.activity.Main2Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetActivity extends BaseActivity {

    @BindView(R.id.comeback)
    ImageView comeback;
    @BindView(R.id.set_data)
    TextView setData;
    @BindView(R.id.set_clear)
    RelativeLayout setClear;
    @BindView(R.id.set_update)
    RelativeLayout setUpdate;
    @BindView(R.id.reset)
    ImageView reset;
    @BindView(R.id.set_cancle_login)
    Button setCancleLogin;
    private SharedPreferences sp;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
  //隐藏标题栏
        getSupportActionBar().hide();
        sp = getSharedPreferences("login.dp", Context.MODE_PRIVATE);
        try {
            //缓存大小

            String data = DataCleanManager.getTotalCacheSize(SetActivity.this);
            setData.setText(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_set;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }



    @OnClick({R.id.comeback, R.id.set_clear, R.id.set_update, R.id.reset, R.id.set_cancle_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.comeback:
                finish();
                break;
            case R.id.set_clear:
                AlertDialog.Builder builder = new AlertDialog.Builder(SetActivity.this);
                builder.setTitle("清除缓存提醒");
                builder.setMessage("是否确定清除缓存");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DataCleanManager.clearAllCache(SetActivity.this);
                        setData.setText("0M");
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
            case R.id.set_update:
                break;
            case R.id.reset:
                break;
            case R.id.set_cancle_login:
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("b",false);
                edit.commit();
                Intent intent = new Intent(SetActivity.this, Main2Activity.class);
                intent.putExtra("login",true);
                startActivity(intent);
                finish();
                break;
        }
    }
}
