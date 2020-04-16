package com.bw.movie.model.adapter.MyAdapter;

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
import com.bw.movie.model.entity.UserFollowMovieEntity;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class MovieAttentionAdabter extends RecyclerView.Adapter<MovieAttentionAdabter.VH> {


    private List<UserFollowMovieEntity.ResultBean> mResult;

    public MovieAttentionAdabter(List<UserFollowMovieEntity.ResultBean> result) {
        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_attention_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(holder.movieAttentionImg)
                .load(mResult.get(position).getImageUrl())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.movieAttentionImg);

        holder.movieAttentionName.setText(mResult.get(position).getName());
        holder.movieAttentionDaoyan.setText("导演: "+mResult.get(position).getDirector());
        holder.movieAttentionYanyuan.setText("主演: "+mResult.get(position).getStarring());
        holder.movieAttentionPrice.setText("评分: "+mResult.get(position).getScore()+"分");

        holder.movieAttentionImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mResult.get(position).getMovieId());
            }
        });

        holder.movieAttentionName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mResult.get(position).getMovieId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }


    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.movieAttention_img)
        ImageView movieAttentionImg;
        @BindView(R.id.movieAttention_Name)
        TextView movieAttentionName;
        @BindView(R.id.movieAttention_Daoyan)
        TextView movieAttentionDaoyan;
        @BindView(R.id.movieAttention_Yanyuan)
        TextView movieAttentionYanyuan;
        @BindView(R.id.movieAttention_Price)
        TextView movieAttentionPrice;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    OnClickItemList mOnClickItemList;

    public void setOnClickItemList(OnClickItemList onClickItemList) {
        mOnClickItemList = onClickItemList;
    }

    public interface OnClickItemList {
        void onClick(int movieId);
    }
}
