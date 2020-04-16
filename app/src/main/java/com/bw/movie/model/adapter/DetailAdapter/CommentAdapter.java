package com.bw.movie.model.adapter.DetailAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.model.entity.detailEntity.CommentEntity;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/27
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.VH> {


    private List<CommentEntity.ResultBean> mResult;

    public CommentAdapter(List<CommentEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(holder.commentImg)
                .load(mResult.get(position).getCommentHeadPic())
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.commentImg);

        holder.commentName.setText(mResult.get(position).getCommentUserName());

        SimpleDateFormat sim = new SimpleDateFormat("MM-dd   HH:ss");
        String format = sim.format(mResult.get(position).getCommentTime());
        holder.commentTime.setText(format);
        holder.commentRating.setRating((float) mResult.get(position).getScore());
        holder.commentPrice.setText(mResult.get(position).getScore()+"分");
        holder.commentText.setText(mResult.get(position).getCommentContent());

    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.comment_img)
        ImageView commentImg;
        @BindView(R.id.comment_name)
        TextView commentName;
        @BindView(R.id.comment_time)
        TextView commentTime;
        @BindView(R.id.comment_rating)
        RatingBar commentRating;
        @BindView(R.id.comment_price)
        TextView commentPrice;
        @BindView(R.id.comment_text)
        TextView commentText;
        @BindView(R.id.cpmment_zan)
        ImageView cpmmentZan;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
