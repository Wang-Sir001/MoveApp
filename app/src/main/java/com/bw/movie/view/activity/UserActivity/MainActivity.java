package com.bw.movie.view.activity.UserActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bawei.mymovie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.mvp.BasePresenter;

import butterknife.BindView;

/**
 * 姓名:王江伟
 * 时间:2020年3月19日15:01:16
 * 作用:3秒引导页
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.tv)
    TextView tv;
    int time = 3;

    //Handler接收数据
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                if (time > 0){
                    time --;
                    tv.setText(time+"S");
                    mHandler.sendEmptyMessageDelayed(1,1000);
                }else {
                    //时间倒计时结束跳转
                    Intent intent = new Intent(MainActivity.this, GuidePageActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    };



    @Override
    protected void initData() {

        //创建子线程,做耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessageDelayed(1,1000);
            }
        }).start();

    }

    @Override
    protected void initView() {
//隐藏标题
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
