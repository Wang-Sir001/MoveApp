package com.bw.movie.model.adapter.MyAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.model.entity.myEntity.MyMovieCommentEntity;
import com.bw.movie.util.NetUtils;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.media.CamcorderProfile.get;

/**
 * date:2020/4/8 0008
 * function:我的电影评论
 */
public class MovieCommentAdapter extends RecyclerView.Adapter<MovieCommentAdapter.MyViewHolder> {


    private List<MyMovieCommentEntity.ResultBean> mResult;

    public MovieCommentAdapter(List<MyMovieCommentEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cmmv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyMovieCommentEntity.ResultBean resultBean = mResult.get(position);
        NetUtils.getInstance().getpho(resultBean.getImageUrl(),holder.cmmvIv);
        holder.cmmvName.setText(resultBean.getMovieName());
        holder.cmmvDao.setText("导演:"+resultBean.getDirector());
        holder.cmmvZhu.setText("主演:"+resultBean.getStarring());
        holder.cmmvScore.setText("评分:"+resultBean.getMovieScore());
        holder.cmmvComment.setText(resultBean.getMyCommentContent());
        double myCommentScore = resultBean.getMyCommentScore();
        holder.cmmvFen.setText("("+myCommentScore+"分)");
        holder.cmmvRat.setRating((float) myCommentScore/2);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        holder.cmmvTime.setText(format.format(resultBean.getCommentTime()));
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cmmv_iv)
        ImageView cmmvIv;
        @BindView(R.id.cmmv_name)
        TextView cmmvName;
        @BindView(R.id.cmmv_dao)
        TextView cmmvDao;
        @BindView(R.id.cmmv_zhu)
        TextView cmmvZhu;
        @BindView(R.id.cmmv_score)
        TextView cmmvScore;
        @BindView(R.id.cmmv_comment)
        TextView cmmvComment;
        @BindView(R.id.cmmv_rat)
        RatingBar cmmvRat;
        @BindView(R.id.cmmv_fen)
        TextView cmmvFen;
        @BindView(R.id.cmmv_time)
        TextView cmmvTime;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
