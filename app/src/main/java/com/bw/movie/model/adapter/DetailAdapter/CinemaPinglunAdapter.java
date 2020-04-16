package com.bw.movie.model.adapter.DetailAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.model.entity.detailEntity.CinemaPinglunEntity;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/27
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class CinemaPinglunAdapter extends RecyclerView.Adapter<CinemaPinglunAdapter.VH> {


    private List<CinemaPinglunEntity.ResultBean> mResult;

    public CinemaPinglunAdapter(List<CinemaPinglunEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cinnema_pinglun_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        Glide.with(holder.cinemaImg)
                .load(mResult.get(position).getCommentHeadPic())
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .into(holder.cinemaImg);

        holder.cinemaName.setText(mResult.get(position).getCommentUserName());
        SimpleDateFormat sim = new SimpleDateFormat("MM-dd hh:ss");
        String format = sim.format(mResult.get(position).getCommentTime());
        holder.cinemaTime.setText(format+"");
        holder.textCinema.setText(mResult.get(position).getCommentContent());

    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.cinema_img)
        ImageView cinemaImg;
        @BindView(R.id.cinema_name)
        TextView cinemaName;
        @BindView(R.id.cinema_time)
        TextView cinemaTime;
        @BindView(R.id.text_cinema)
        TextView textCinema;
        @BindView(R.id.cinema_zan)
        ImageView cinemaZan;
        @BindView(R.id.cinema_zans)
        TextView cinemaZans;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
