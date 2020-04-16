package com.bw.movie.model.adapter.MyAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyHomeAdapter extends RecyclerView.Adapter<MyHomeAdapter.MyViewHolder> {
    //数据
    int imgs[] = {R.drawable.group_2, R.drawable.group_4, R.drawable.goupiaojilu, R.drawable.chongzhijilu, R.drawable.group_3, R.drawable.yijianfankui_01, R.drawable.shezhi};
    String names[] = {"我的关注", "我的预约", "购票记录", "看过的电影", "我的评论", "意见反馈", "设置"};


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.myhomeitem, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myitIv.setImageResource(imgs[position]);
        holder.myitName.setText(names[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.OnClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.myit_iv)
        ImageView myitIv;
        @BindView(R.id.myit_name)
        TextView myitName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void OnClick(int i);
    }
}
