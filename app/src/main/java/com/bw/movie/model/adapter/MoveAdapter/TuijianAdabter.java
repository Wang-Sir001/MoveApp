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
import com.bw.movie.model.entity.yingyuanEntity.TuijianEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class TuijianAdabter extends RecyclerView.Adapter<TuijianAdabter.VH> {


    private List<TuijianEntity.ResultBean> mResult;

    public TuijianAdabter(List<TuijianEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.tuijian_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(holder.tuijianImg)
                .load(mResult.get(position).getLogo())
                .error(R.mipmap.bitmap)
                .placeholder(R.mipmap.bitmap)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.tuijianImg);

        holder.tuijianName.setText(mResult.get(position).getName());
        holder.tuijianDizhi.setText(mResult.get(position).getAddress());

        holder.tuijianImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mResult.get(position).getId());
            }
        });

        holder.tuijianName.setOnClickListener(new View.OnClickListener() {
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
        @BindView(R.id.tuijian_img)
        ImageView tuijianImg;
        @BindView(R.id.tuijian_name)
        TextView tuijianName;
        @BindView(R.id.tuijian_dizhi)
        TextView tuijianDizhi;
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
