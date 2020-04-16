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
import com.bw.movie.model.entity.detailEntity.FindCinemasEntity;
import com.bw.movie.model.entity.detailEntity.FindcinemasPriceEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/4/6
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class FindCinemasPriceAdapter extends RecyclerView.Adapter<FindCinemasPriceAdapter.Vh> {


    private List<FindcinemasPriceEntity.ResultBean> mResult;

    public FindCinemasPriceAdapter(List<FindcinemasPriceEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_cinemas_price_item_layout, parent, false);

        return new Vh(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {
        Glide.with(holder.findCinemaImg)
                .load(mResult.get(position).getLogo())
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.findCinemaImg);

        holder.findCinemaName.setText(mResult.get(position).getName());
        holder.findCinemaDizhi.setText(mResult.get(position).getAddress());
        holder.findCinemaImg.setOnClickListener(new View.OnClickListener() {
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

    class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.findCinema_img)
        ImageView findCinemaImg;
        @BindView(R.id.findCinema_name)
        TextView findCinemaName;
        @BindView(R.id.findCinema_dizhi)
        TextView findCinemaDizhi;
        public Vh(@NonNull View itemView) {
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
