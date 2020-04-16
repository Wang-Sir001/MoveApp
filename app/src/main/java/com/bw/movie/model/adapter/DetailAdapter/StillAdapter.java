package com.bw.movie.model.adapter.DetailAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/27
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class StillAdapter extends RecyclerView.Adapter<StillAdapter.VH> {


    private List<String> mPosterList;

    public StillAdapter(List<String> posterList) {

        mPosterList = posterList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.still_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(holder.stillImg)
                .load(mPosterList.get(position))
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.stillImg);

    }

    @Override
    public int getItemCount() {
        return mPosterList.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.still_img)
        ImageView stillImg;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
