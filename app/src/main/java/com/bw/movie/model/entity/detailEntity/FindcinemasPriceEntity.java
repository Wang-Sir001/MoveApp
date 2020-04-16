package com.bw.movie.model.entity.detailEntity;

import java.util.List;

/**
 * data:2020/4/6
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class FindcinemasPriceEntity {

    /**
     * result : [{"address":"崇文门外大街18号国瑞城首层、地下二层","cinemaId":9,"logo":"http://mobile.bwstudent.com/images/movie/logo/blh.jpg","name":"北京百老汇影城国瑞购物中心店","price":0.13}]
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
         * address : 崇文门外大街18号国瑞城首层、地下二层
         * cinemaId : 9
         * logo : http://mobile.bwstudent.com/images/movie/logo/blh.jpg
         * name : 北京百老汇影城国瑞购物中心店
         * price : 0.13
         */

        private String address;
        private int cinemaId;
        private String logo;
        private String name;
        private double price;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
