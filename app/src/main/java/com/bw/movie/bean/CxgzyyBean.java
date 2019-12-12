package com.bw.movie.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/12/3
 *@Time:11:20
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class CxgzyyBean {

    /**
     * result : [{"address":"远大路1号金源时代购物中心5层东首","cinemaId":11,"logo":"http://172.17.8.100/images/movie/logo/xmgj.jpg","name":"星美国际影城"}]
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
         */

        private String address;
        private int cinemaId;
        private String logo;
        private String name;

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
    }
}
