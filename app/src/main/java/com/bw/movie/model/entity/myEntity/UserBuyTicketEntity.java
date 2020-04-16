package com.bw.movie.model.entity.myEntity;

import java.util.List;

/**
 * data:2020/4/13
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class UserBuyTicketEntity {
    public String status;
    public String message;
    public List<ResultBean> result;

    public static class ResultBean{
      public int id;
      public String movieName;
      public String cinemaName;
      public String imageUrl;
      public String orderId;
      public long createTime;
      public double price;
      public int amount;
    }
}
