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
import com.bw.movie.model.entity.dianyingliebiaoEntity.RmdyEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class RmdyAdabter extends RecyclerView.Adapter<RmdyAdabter.VH> {


    private List<RmdyEntity.ResultBean> mRmdyEntityResult;

    public RmdyAdabter(List<RmdyEntity.ResultBean> rmdyEntityResult) {

        mRmdyEntityResult = rmdyEntityResult;
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
                .load(mRmdyEntityResult.get(position).getImageUrl())
                .error(R.mipmap.bitmap)
                .placeholder(R.mipmap.bitmap)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.imges);
        holder.price.setText(mRmdyEntityResult.get(position).getScore()+"");
        holder.name.setText(mRmdyEntityResult.get(position).getName());

        holder.imges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mRmdyEntityResult.get(position).getMovieId());
            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mRmdyEntityResult.get(position).getMovieId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRmdyEntityResult.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.imges)
        ImageView imges;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.gp)
        Button gp;
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
