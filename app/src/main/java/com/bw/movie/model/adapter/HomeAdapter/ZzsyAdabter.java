package com.bw.movie.model.adapter.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.model.entity.dianyingliebiaoEntity.ZzsyEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class ZzsyAdabter extends RecyclerView.Adapter<ZzsyAdabter.VH> {


    private List<ZzsyEntity.ResultBean> mZzsyEntityResult;

    public ZzsyAdabter(List<ZzsyEntity.ResultBean> zzsyEntityResult) {

        mZzsyEntityResult = zzsyEntityResult;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.zzsy_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(holder.imges)
                .load(mZzsyEntityResult.get(position).getImageUrl())
                .error(R.mipmap.bitmap)
                .placeholder(R.mipmap.bitmap)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.imges);
        holder.price.setText(mZzsyEntityResult.get(position).getScore()+"");
        holder.name.setText(mZzsyEntityResult.get(position).getName());

        holder.imges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mZzsyEntityResult.get(position).getMovieId());
            }
        });

        holder.gp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mZzsyEntityResult.get(position).getMovieId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mZzsyEntityResult.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.gp)
        Button gp;
        @BindView(R.id.imges)
        ImageView imges;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    OnClickItemList mOnClickItemList;

    public void setOnClickItemList(OnClickItemList onClickItemList) {
        mOnClickItemList = onClickItemList;
    }

    public interface OnClickItemList{
        void onClick(int movieId);
    }
}
