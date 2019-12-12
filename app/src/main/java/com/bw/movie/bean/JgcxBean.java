package com.bw.movie.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/12/5
 *@Time:15:59
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class JgcxBean {

    /**
     * result : [{"address":"远大路1号金源时代购物中心5层东首","cinemaId":11,"logo":"http://172.17.8.100/images/movie/logo/xmgj.jpg","name":"星美国际影城","price":0.15},{"address":"中关村广场购物中心津乐汇三层（鼎好一期西侧）","cinemaId":12,"logo":"http://172.17.8.100/images/movie/logo/mjhlyc.jpg","name":"美嘉欢乐影城中关村店","price":0.16},{"address":"复兴路69号五棵松卓展时代百货五层东侧","cinemaId":13,"logo":"http://172.17.8.100/images/movie/logo/bjalclgj.jpg","name":"北京耀莱成龙国际影城","price":0.17},{"address":"中关村大街19号新中关购物中心B1层","cinemaId":15,"logo":"http://172.17.8.100/images/movie/logo/jy.jpg","name":"金逸北京中关村店","price":0.18},{"address":"新街口外大街25号","cinemaId":14,"logo":"http://172.17.8.100/images/movie/logo/zygj.jpg","name":"中影国际影城北京小西天店","price":0.21}]
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
         * address : 远大路1号金源时代购物中心5层东首
         * cinemaId : 11
         * logo : http://172.17.8.100/images/movie/logo/xmgj.jpg
         * name : 星美国际影城
         * price : 0.15
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
