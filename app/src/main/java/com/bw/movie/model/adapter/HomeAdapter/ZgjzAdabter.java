package com.bw.movie.model.adapter.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.model.entity.XBannerEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class ZgjzAdabter extends RecyclerView.Adapter<ZgjzAdabter.VH> {


    private List<XBannerEntity.ResultBean> mResult;

    public ZgjzAdabter(List<XBannerEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.rmdy_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(holder.imges)
                .load(mResult.get(1).getImageUrl())
                .error(R.mipmap.bitmap)
                .placeholder(R.mipmap.bitmap)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.imges);

        holder.imges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(24);
            }
        });


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.imgess)
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
