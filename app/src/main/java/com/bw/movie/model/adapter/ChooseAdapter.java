package com.bw.movie.model.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


import com.bawei.mymovie.R;
import com.bw.movie.model.entity.seat.ChooseActivityBean;

import java.util.List;

/**
 * author : Eaves
 * desc   : 功能描述
 * date   : 2020/2/12
 */
public class ChooseAdapter extends RecyclerView.Adapter<ChooseAdapter.MyHolder> {

   /* private List<ChooseActivityBean.ResultBean> mList;
    private Context mContext;
    private int chooseIndex = -1;
    private Drawable selected;
    private Drawable unSelected;*/
    private List<ChooseActivityBean.ResultBean> mList;
    private Context mContext;
    private int chooseIndex = -1;
    private Drawable selected;
    private Drawable unSelected;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ChooseAdapter(List<ChooseActivityBean.ResultBean> list, Context context) {
        mList = list;
        mContext = context;
        selected = context.getDrawable(R.drawable.choose_item_selected);

        unSelected = context.getDrawable(R.drawable.choose_item_unselected);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.choose_recy_item,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    public void setChooseIndex(int chooseIndex){
        this.chooseIndex = chooseIndex;
    }
    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {


        myHolder.one.setText(mList.get(i).getScreeningHall());
        String beginTime = mList.get(i).getBeginTime();
        String endTime = mList.get(i).getEndTime();
        String newBegin = beginTime.substring(0, 5);
        String newEnd = endTime.substring(0,5);
        myHolder.two.setText(newBegin+"——"+newEnd);
        if (chooseIndex == i){
            //选中
            myHolder.logo.setBackground(selected);
        }else {
            //未选中
            myHolder.logo.setBackground(unSelected);
        }

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mChooseItemCallBack != null){
                    mChooseItemCallBack.chooseItemClick(i,chooseIndex);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView one;
        TextView two;
        TextView logo;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            one = itemView.findViewById(R.id.choose_one);
            two = itemView.findViewById(R.id.choose_two);
            logo = itemView.findViewById(R.id.choose_logo);
        }
    }

    private ChooseItemCallBack mChooseItemCallBack;
    public interface ChooseItemCallBack{
        void chooseItemClick(int position, int chooseIndex);
    }
    public void setChooseItemCallBack(ChooseItemCallBack chooseItemCallBack){
        mChooseItemCallBack = chooseItemCallBack;
    }
}
