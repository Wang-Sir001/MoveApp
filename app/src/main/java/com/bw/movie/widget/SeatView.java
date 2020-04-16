package com.bw.movie.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.bawei.mymovie.R;
import com.bw.movie.model.entity.seat.SeatBean;
import com.bw.movie.util.TUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author : Eaves
 * desc   : 功能描述
 * date   : 2020/2/12
 */
public class SeatView extends View {
    private int raw;//行数
    private int col = 0;//列数
    private List<SeatBean.ResultBean> mList = new ArrayList<>();//座位信息集合
    private Paint whitePaint;//可选
    private Paint yellowPaint;//已售(不可选)
    private Paint pinkPaint;//选中
    private List<Integer> columnsInfo = new ArrayList<>();//每排座位的列数,下标表示排数
    private float mRadius = getResources().getDimensionPixelOffset(R.dimen.dp_14);//座位圆半径
    private float promptRadius = getResources().getDimensionPixelOffset(R.dimen.dp_10);//提示圆点半径
    private float xSpace;//横向段距离
    private float ySpace;//纵向段距离
    private float mWidth;
    private float mHeight;
    private float pointY;//y坐标
    private float pointX;//x坐标
    private double fare;//影票单价
    private int num;//选中座位数
    private int scheduleId = -1;

    //初始化座位信息集合
    public void setSeatInfo(List<SeatBean.ResultBean> seatBeans){

        if (seatBeans == null || seatBeans.size() <= 0){
            return;
        }

        mList.clear();
        mList.addAll(seatBeans);

        raw = Integer.parseInt(mList.get(mList.size()-1).getRow());//行数

        col = 0;
        //最大的列数
        for (int i = 0; i < mList.size(); i++) {

            col = Math.max(col,Integer.parseInt(mList.get(i).getSeat()));
        }

        for (int i = 0; i < Integer.parseInt(mList.get(mList.size()-1).getRow()); i++) {
            columnsInfo.add(0);
        }

        for (int i = 0; i < mList.size(); i++) {
            //列数
            int temCol = Integer.parseInt(mList.get(i).getSeat());
            //行数
            int temRaw = Integer.parseInt(mList.get(i).getRow());

            columnsInfo.set((temRaw-1),temCol);
        }

        this.requestLayout();
        this.invalidate();
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId){
        this.scheduleId = scheduleId;
    }

    public void setNum(int num){
        this.num = num;
    }

    public void setFare(double fare){
        this.fare = fare;
    }

    public SeatView(Context context) {
        this(context, null);
    }

    public SeatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        int textSize = getResources().getDimensionPixelOffset(R.dimen.dp_11);

        whitePaint = new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);
        whitePaint.setTextSize(textSize);

        yellowPaint = new Paint();
        yellowPaint.setAntiAlias(true);
        yellowPaint.setColor(getResources().getColor(R.color.yellow));

        pinkPaint = new Paint();
        pinkPaint.setAntiAlias(true);
        pinkPaint.setColor(getResources().getColor(R.color.lipstick));

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /*//如果没有座位信息,则不测量,也就不绘制了
        if (mList == null || mList.size() < 0) {
            return;
        }*/

        //获取View宽高
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

        //获取横向段距离
        xSpace = (mWidth - (mRadius * 2.0f)) / (col - 1);
        //获取纵向段距离
        ySpace = (mHeight - (mRadius + promptRadius)) / raw;
        //ySpace = (mHeight - (mRadius + 2.0f)) / (raw - 1);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //如果没有座位信息,则不测量,也就不绘制了
        if (mList == null || mList.size() <= 0) {
            return;
        }


        //绘制
        for (int i = 0; i < mList.size(); i++) {

            pointX = getPointX((Integer.parseInt(mList.get(i).getRow()) - 1), (Integer.parseInt(mList.get(i).getSeat()) - 1));
            pointY = getPointY((Integer.parseInt(mList.get(i).getRow()) - 1));

            switch (mList.get(i).getStatus()) {

                case 1://可选  whitePaint
                    canvas.drawCircle(pointX,pointY,mRadius,whitePaint);
                    break;
                case 2://已选  yellowPaint
                    canvas.drawCircle(pointX,pointY,mRadius,yellowPaint);
                    break;
                case 3://选中  pinkPaint
                    canvas.drawCircle(pointX,pointY,mRadius,pinkPaint);
                    break;
            }
        }

        //绘制提示小圆点以及文本
        canvas.drawCircle(mWidth / 2.0f,getPointY(Integer.parseInt(mList.get(mList.size()-1).getRow())),promptRadius,yellowPaint);
        canvas.drawText("已售",(mWidth / 2.0f)+(promptRadius*2.0f),getPointY(Integer.parseInt(mList.get(mList.size()-1).getRow()))+promptRadius/5.0f,whitePaint);

        canvas.drawCircle(((mWidth / 2.0f)-(xSpace*2.0f)),getPointY(Integer.parseInt(mList.get(mList.size()-1).getRow())),promptRadius,whitePaint);
        canvas.drawText("可选",((mWidth / 2.0f)-(xSpace*2.0f))+(promptRadius*2.0f),getPointY(Integer.parseInt(mList.get(mList.size()-1).getRow()))+promptRadius/5.0f,whitePaint);

        canvas.drawCircle(((mWidth / 2.0f)+(xSpace*2.0f)),getPointY(Integer.parseInt(mList.get(mList.size()-1).getRow())),promptRadius,pinkPaint);
        canvas.drawText("选中",((mWidth / 2.0f)+(xSpace*2.0f))+(promptRadius*2.0f),getPointY(Integer.parseInt(mList.get(mList.size()-1).getRow()))+promptRadius/5.0f,whitePaint);

        /**
         *
         * 0  10   第一排
         * 1  10 + ySpace  第二排
         * 2  10 + 2 * ySpace  第三排
         */

        //获取y坐标

        //获取x坐标
        /**
         * 满列的情况  columnsInfo.get(i) == col
         * 0 10  第一列  mRadius + (j * xSpace)
         * 1 10 + xSpace 第二列
         * 2 10 + 2 * xSpace 第三列
         *
         * 非满列的情况
         * 起始点坐标 (((col - 1) - (columnsInfo.get(i) - 1))/2) * xSpace + mRadius
         * 0 10   ((最大列的段距离个数-列少的段距离个数)/2) * 段距离 + 半径  就是起始点坐标
         * 1 10   起始点坐标 + 1 * 段距离
         * 2 10   起始点坐标 + 2 * 段距离
         */


    }

    /**
     * @param rawIndex 行数下标
     * @return y坐标
     */
    private float getPointY(int rawIndex) {

        return mRadius + (rawIndex * ySpace);
    }

    /**
     * @param rawIndex 行数下标
     * @param colIndex 列数下标
     * @return x坐标
     */
    private float getPointX(int rawIndex, int colIndex) {

        return getXStart(rawIndex) + (colIndex * xSpace);
    }

    /**
     * @param rawIndex 行数下标
     * @return x坐标起始点
     */
    private float getXStart(int rawIndex) {

        return (((((col - 1) - (columnsInfo.get(rawIndex) - 1)) / 2.0f) * xSpace)) + mRadius;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float touchX;
        float touchY;

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                touchX = event.getX();//相对于控件的x坐标
                touchY = event.getY();//相对于控件的y坐标


                //判断属于哪个范围
                for (int i = 0; i < mList.size(); i++) {
                    pointX = getPointX((Integer.parseInt(mList.get(i).getRow()) - 1), (Integer.parseInt(mList.get(i).getSeat()) - 1));
                    pointY = getPointY((Integer.parseInt(mList.get(i).getRow()) - 1));

                    if (touchX>(pointX-mRadius) && touchX <(pointX+mRadius)){
                        if (touchY >= (pointY - mRadius) && (touchY <= (pointY + mRadius))){
                            //此时在某点范围内,判断状态,可选就修改,并且传值动态修改计价
                            if (mList.get(i).getStatus() == 1){//处于可选状态
                                if (num>=4){
                                    TUtils.toastInfo("不能在选了");
                                    break;
                                }
                                mList.get(i).setStatus(3);//标识为已选状态
                                //通知重新绘制
                                this.invalidate();

                                num++;//选座数量+1;
                                if (mSeatViewCallBack != null){
                                    //回传票价
                                    mSeatViewCallBack.turnPrice(num*fare);
                                }
                            }else if (mList.get(i).getStatus() == 3){//处于选中状态
                                mList.get(i).setStatus(1);//取消选中,恢复可选状态
                                num--;//选座数量-1
                                if (mSeatViewCallBack!=null){
                                    mSeatViewCallBack.turnPrice(num*fare);
                                }
                                //通知重新绘制
                                this.invalidate();
                            }
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    public String getPaySeat(){
        String seatInfo = "";
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).getStatus()==3){
                seatInfo += mList.get(i).getRow()+"-"+mList.get(i).getSeat()+",";
            }
        }
        if (TextUtils.equals("",seatInfo)){
            return seatInfo;
        }else {
            String substring = seatInfo.substring(0, seatInfo.length() - 1);
            return substring;
        }
    }
    private SeatViewCallBack mSeatViewCallBack;
    public interface SeatViewCallBack{
        void turnPrice(double price);
    }
    public void setSeatViewCallBack(SeatViewCallBack seatViewCallBack){
        this.mSeatViewCallBack = seatViewCallBack;
    }
}
