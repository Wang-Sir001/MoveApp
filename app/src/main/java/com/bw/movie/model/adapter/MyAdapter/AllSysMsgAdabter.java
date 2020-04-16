package com.bw.movie.model.adapter.MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymovie.R;
import com.bw.movie.model.entity.myEntity.AllSysMshEntity;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class AllSysMsgAdabter extends RecyclerView.Adapter<AllSysMsgAdabter.VH> {


    private List<AllSysMshEntity.ResultBean> mResult;

    public AllSysMsgAdabter(List<AllSysMshEntity.ResultBean> result) {

        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_msg_item_layout, parent, false);
        VH vh = new VH(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.allMsgTitle.setText(mResult.get(position).getTitle());
        SimpleDateFormat sim = new SimpleDateFormat("MM-dd hh:ss");
        String format = sim.format(mResult.get(position).getPushTime());
        holder.allMsgTitle.setText(format);
        holder.allMsgContext.setText(mResult.get(position).getContent());

        holder.allMsgTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.allMsgCb.setChecked(false);
            }
        });
        holder.allMsgContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.allMsgCb.setChecked(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.allMsg_cb)
        CheckBox allMsgCb;
        @BindView(R.id.allMsg_time)
        TextView allMsgTime;
        @BindView(R.id.allMsg_context)
        TextView allMsgContext;
        @BindView(R.id.allMsg_title)
        TextView allMsgTitle;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
