package com.bw.movie.model.adapter;

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
import com.bw.movie.model.entity.SoonMoiveEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class SoonMovieAdabter extends RecyclerView.Adapter<SoonMovieAdabter.VH> {


    private List<SoonMoiveEntity.ResultBean> mMovieList;

    public SoonMovieAdabter(List<SoonMoiveEntity.ResultBean> movieList) {

        mMovieList = movieList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.soon_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        Glide.with(holder.jjsyImg)
                .load(mMovieList.get(position).getImageUrl())
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.jjsyImg);

        holder.soonName.setText("影名 : "+mMovieList.get(position).getName());
        holder.soonDaoyan.setText("导演"+mMovieList.get(position).getDirector());
        holder.soonYanyuan.setText("演员"+mMovieList.get(position).getStarring());
        holder.soonPrice.setText("评分"+mMovieList.get(position).getScore()+"");


        holder.jjsyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mMovieList.get(position).getMovieId(),mMovieList.get(position).getName());
        }
        });
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.jjsy_img)
        ImageView jjsyImg;
        @BindView(R.id.soon_Name)
        TextView soonName;
        @BindView(R.id.soon_daoyan)
        TextView soonDaoyan;
        @BindView(R.id.soon_yanyuan)
        TextView soonYanyuan;
        @BindView(R.id.soon_price)
        TextView soonPrice;
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
        void onClick(int moiveId,String name);
    }
}
