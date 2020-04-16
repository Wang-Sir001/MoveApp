package com.bw.movie.model.adapter.SearchAdapter;

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
import com.bw.movie.model.entity.SearchEntity.CinemaSearchEntity;
import com.bw.movie.model.entity.SearchEntity.MovieSearchEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CinemaSearchAdapter extends RecyclerView.Adapter<CinemaSearchAdapter.MyViewHolder> {


    private List<CinemaSearchEntity.ResultBean> mResult;

    public CinemaSearchAdapter(List<CinemaSearchEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.findcinema, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CinemaSearchEntity.ResultBean resultBean = mResult.get(position);
        holder.tuijianName.setText(resultBean.getName());

        Glide.with(holder.tuijianImg).load(resultBean.getLogo())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.tuijianImg);

        holder.tuijianDizhi.setText(mResult.get(position).getAddress());
       /* holder.tuijianImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(resultBean.getMovieId());
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tuijian_img)
        ImageView tuijianImg;
        @BindView(R.id.tuijian_name)
        TextView tuijianName;
        @BindView(R.id.tuijian_dizhi)
        TextView tuijianDizhi;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /*OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int movieId);
    }*/
}
