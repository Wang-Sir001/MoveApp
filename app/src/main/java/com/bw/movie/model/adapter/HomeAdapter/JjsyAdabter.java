package com.bw.movie.model.adapter.HomeAdapter;

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
import com.bw.movie.model.entity.dianyingliebiaoEntity.JjsyEntity;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class JjsyAdabter extends RecyclerView.Adapter<JjsyAdabter.VH> {


    @BindView(R.id.jjsy_yy)
    Button jjsyYy;
    private List<JjsyEntity.ResultBean> mJjsyEntityResult;

    public JjsyAdabter(List<JjsyEntity.ResultBean> jjsyEntityResult) {

        mJjsyEntityResult = jjsyEntityResult;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.jjsy_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(holder.jjsyImg)
                .load(mJjsyEntityResult.get(position).getImageUrl())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.jjsyImg);

        SimpleDateFormat sim = new SimpleDateFormat("yyyy年MM月dd日");
        String format = sim.format(mJjsyEntityResult.get(position).getReleaseTime());

        holder.jjsyName.setText(mJjsyEntityResult.get(position).getName());
        holder.jjsyTime.setText(format + "");
        holder.jjsyPeapo.setText(mJjsyEntityResult.get(position).getWantSeeNum() + "人想看");

        holder.jjsyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mJjsyEntityResult.get(position).getMovieId());
            }
        });

        holder.jjsyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mJjsyEntityResult.get(position).getMovieId());
            }
        });
        holder.jjsyYy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemYuyue.onClickest(mJjsyEntityResult.get(position).getMovieId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mJjsyEntityResult.size();
    }


    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.jjsy_Name)
        TextView jjsyName;
        @BindView(R.id.jjsy_Time)
        TextView jjsyTime;
        @BindView(R.id.jjsy_Peapo)
        TextView jjsyPeapo;
        @BindView(R.id.jjsy_img)
        ImageView jjsyImg;
        @BindView(R.id.jjsy_yy)
        Button jjsyYy;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    OnClickItemList mOnClickItemList;

    public void setOnClickItemList(OnClickItemList onClickItemList) {
        mOnClickItemList = onClickItemList;
    }

    public interface OnClickItemList {
        void onClick(int movieId);
    }

    OnClickItemYuyue mOnClickItemYuyue;

    public void setOnClickItemYuyue(OnClickItemYuyue onClickItemYuyue) {
        mOnClickItemYuyue = onClickItemYuyue;
    }

    public interface OnClickItemYuyue{
        void onClickest(int movieId);
    }
}
