package com.bw.movie.model.entity.seat;

import java.util.List;

/**
 * author : Eaves
 * desc   : 功能描述
 * date   : 2020/2/12
 */
public class ChooseActivityBean {
    /**
     * result : [{"beginTime":"11:22:00","endTime":"13:03:00","fare":0.09,"hallId":5,"id":21,"screeningHall":"杜比厅"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * beginTime : 11:22:00
         * endTime : 13:03:00
         * fare : 0.09
         * hallId : 5
         * id : 21
         * screeningHall : 杜比厅
         */

        private String beginTime;
        private String endTime;
        private double fare;
        private int hallId;
        private int id;
        private String screeningHall;

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public double getFare() {
            return fare;
        }

        public void setFare(double fare) {
            this.fare = fare;
        }

        public int getHallId() {
            return hallId;
        }

        public void setHallId(int hallId) {
            this.hallId = hallId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getScreeningHall() {
            return screeningHall;
        }

        public void setScreeningHall(String screeningHall) {
            this.screeningHall = screeningHall;
        }
    }
}
