package com.bw.movie.model.adapter.SearchAdapter;

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
import com.bw.movie.model.entity.SearchEntity.MovieSearchEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieSearchAdapter extends RecyclerView.Adapter<MovieSearchAdapter.MyViewHolder> {


    private List<MovieSearchEntity.ResultBean> mResult;

    public MovieSearchAdapter(List<MovieSearchEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.findmovie,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MovieSearchEntity.ResultBean resultBean = mResult.get(position);
        holder.mvFinmovieItName.setText(resultBean.getName());
        holder.mvFinmovieItDao.setText("导演:"+resultBean.getDirector());
        holder.mvFinmovieItZhu.setText("主演:"+resultBean.getStarring());
        Glide.with(holder.mvFinmovieItImg).load(resultBean.getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.mvFinmovieItImg);
        holder.mvFinmovieItImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(resultBean.getMovieId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.mv_finmovie_it_img)
        ImageView mvFinmovieItImg;
        @BindView(R.id.mv_finmovie_it_name)
        TextView mvFinmovieItName;
        @BindView(R.id.mv_finmovie_it_dao)
        TextView mvFinmovieItDao;
        @BindView(R.id.mv_finmovie_it_zhu)
        TextView mvFinmovieItZhu;
        @BindView(R.id.mv_finmovie_it_bt)
        Button mvFinmovieItBt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onClick(int movieId);
    }
}
