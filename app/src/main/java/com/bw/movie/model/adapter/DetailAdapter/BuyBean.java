package com.bw.movie.model.adapter.DetailAdapter;

/**
 * date:2020/4/3 0003
 * author:胡锦涛(Administrator)
 * function:购票下单
 */
public class BuyBean {

    /**
     * orderId : 20200406075555476
     * message : 下单成功
     * status : 0000
     */

    private String orderId;
    private String message;
    private String status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
