package com.bw.movie.model.adapter.MoveAdapter;

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
import com.bw.movie.model.entity.yingyuanEntity.FujinEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class FujinAdabter extends RecyclerView.Adapter<FujinAdabter.VH> {


    private List<FujinEntity.ResultBean> mResult;

    public FujinAdabter(List<FujinEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fujin_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(holder.fujinImg)
                .load(mResult.get(position).getLogo())
                .error(R.mipmap.bitmap)
                .placeholder(R.mipmap.bitmap)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.fujinImg);

        holder.fujinName.setText(mResult.get(position).getName());
        holder.fujinDizhi.setText(mResult.get(position).getAddress());
        holder.fujinMi.setText(mResult.get(position).getDistance()+"米");

        holder.fujinImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mResult.get(position).getId());
            }
        });

        holder.fujinName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mResult.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.fujin_img)
        ImageView fujinImg;
        @BindView(R.id.fujin_name)
        TextView fujinName;
        @BindView(R.id.fujin_dizhi)
        TextView fujinDizhi;
        @BindView(R.id.fujin_mi)
        TextView fujinMi;
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
