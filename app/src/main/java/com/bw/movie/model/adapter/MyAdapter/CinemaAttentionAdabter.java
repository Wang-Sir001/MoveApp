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
import com.bw.movie.model.entity.UserFollowCinemaEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class CinemaAttentionAdabter extends RecyclerView.Adapter<CinemaAttentionAdabter.VH> {


    private List<UserFollowCinemaEntity.ResultBean> mResult;

    public CinemaAttentionAdabter(List<UserFollowCinemaEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cinema_attention_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(holder.cinemaAttentionImg)
                .load(mResult.get(position).getLogo())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.cinemaAttentionImg);

        holder.cinemaAttentionName.setText(mResult.get(position).getName());
        holder.cinemaAttentionContent.setText(mResult.get(position).getAddress());


        holder.cinemaAttentionImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mResult.get(position).getCinemaId());
            }
        });

        holder.cinemaAttentionName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mResult.get(position).getCinemaId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }


    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.cinemaAttention_img)
        ImageView cinemaAttentionImg;
        @BindView(R.id.cinemaAttention_Name)
        TextView cinemaAttentionName;
        @BindView(R.id.cinemaAttention_content)
        TextView cinemaAttentionContent;

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
        void onClick(int cinemaId);
    }
}
