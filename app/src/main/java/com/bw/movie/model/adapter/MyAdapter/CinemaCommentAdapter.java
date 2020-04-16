package com.bw.movie.model.adapter.MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.model.entity.myEntity.MyCinemaCommentEntity;
import com.bw.movie.util.NetUtils;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/4/8 0008
 * function:我的影院评论
 */
public class CinemaCommentAdapter extends RecyclerView.Adapter<CinemaCommentAdapter.MyViewHolder> {


    private List<MyCinemaCommentEntity.ResultBean> mResult;

    public CinemaCommentAdapter(List<MyCinemaCommentEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cmcm_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyCinemaCommentEntity.ResultBean resultBean = mResult.get(position);
        NetUtils.getInstance().getpho(resultBean.getLogo(),holder.cmcmIv);

        holder.cmcmName.setText(resultBean.getCinemaName());
        holder.cmcmAddress.setText(resultBean.getAddress());
        holder.cmcmKm.setText(resultBean.getDistance()+"km");
        holder.cmcmComment.setText(resultBean.getMyCommentContent());
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        holder.cmcmTime.setText(format.format(resultBean.getCommentTime()));
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cmcm_iv)
        ImageView cmcmIv;
        @BindView(R.id.cmcm_name)
        TextView cmcmName;
        @BindView(R.id.cmcm_address)
        TextView cmcmAddress;
        @BindView(R.id.cmcm_km)
        TextView cmcmKm;
        @BindView(R.id.cmcm_comment)
        TextView cmcmComment;
        @BindView(R.id.cmcm_time)
        TextView cmcmTime;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
