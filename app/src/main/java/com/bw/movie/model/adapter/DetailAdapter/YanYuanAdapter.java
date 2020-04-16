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
import com.bw.movie.model.entity.detailEntity.DetialEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/27
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class YanYuanAdapter extends RecyclerView.Adapter<YanYuanAdapter.VH> {


    private List<DetialEntity.ResultBean.MovieActorBean> mMovieActor;

    public YanYuanAdapter(List<DetialEntity.ResultBean.MovieActorBean> movieActor) {

        mMovieActor = movieActor;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.yanyuan_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(holder.yanyuanImg)
                .load(mMovieActor.get(position).getPhoto())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.yanyuanImg);

        holder.yanyuanName.setText(mMovieActor.get(position).getName());

        holder.yanyuanNameYan.setText("饰演:"+mMovieActor.get(position).getRole());
    }

    @Override
    public int getItemCount() {
        return mMovieActor.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.yanyuan_img)
        ImageView yanyuanImg;
        @BindView(R.id.yanyuan_Name)
        TextView yanyuanName;
        @BindView(R.id.yanyuan_Name_yan)
        TextView yanyuanNameYan;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
