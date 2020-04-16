package com.bw.movie.model.adapter.MyAdapter;

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
import com.bw.movie.model.entity.myEntity.UserReserveEntity;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class AppointmentAdabter extends RecyclerView.Adapter<AppointmentAdabter.VH> {


    private List<UserReserveEntity.ResultBean> mResult;

    public AppointmentAdabter(List<UserReserveEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(holder.jjsyImg)
                .load(mResult.get(position).getImageUrl())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.jjsyImg);

        holder.appointmentName.setText(mResult.get(position).getName());

        SimpleDateFormat sim = new SimpleDateFormat("MM月dd日");
        String format = sim.format(mResult.get(position).getReleaseTime());
        holder.appointmentTime.setText(format+"上映");
        holder.appointmentPeapo.setText(mResult.get(position).getWantSeeNum()+"人想看");


        holder.jjsyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mResult.get(position).getMovieId());
            }
        });

        holder.appointmentName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItemList.onClick(mResult.get(position).getMovieId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }


    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.jjsy_img)
        ImageView jjsyImg;
        @BindView(R.id.appointment_Name)
        TextView appointmentName;
        @BindView(R.id.appointment_Time)
        TextView appointmentTime;
        @BindView(R.id.appointment_Peapo)
        TextView appointmentPeapo;

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
}
