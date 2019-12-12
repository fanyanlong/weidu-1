package com.bw.movie.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/12/2
 *@Time:21:37
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class CxyyplBean {

    /**
     * result : [{"address":"天桥南大街3号楼一层、二层（天桥艺术大厦南侧）","cinemaId":3,"cinemaName":"首都电影院","commentTime":1575293433000,"distance":0,"logo":"http://172.17.8.100/images/movie/logo/sd.jpg","myCommentContent":"666"},{"address":"前门大街大栅栏街36号","cinemaId":2,"cinemaName":"大观楼电影院","commentTime":1575293425000,"distance":0,"logo":"http://172.17.8.100/images/movie/logo/dgl.jpg","myCommentContent":"牛逼"},{"address":"滨河路乙1号雍和航星园74-76号楼","cinemaId":1,"cinemaName":"青春光线电影院","commentTime":1575293416000,"distance":0,"logo":"http://172.17.8.100/images/movie/logo/qcgx.jpg","myCommentContent":"可以"}]
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
         * address : 天桥南大街3号楼一层、二层（天桥艺术大厦南侧）
         * cinemaId : 3
         * cinemaName : 首都电影院
         * commentTime : 1575293433000
         * distance : 0
         * logo : http://172.17.8.100/images/movie/logo/sd.jpg
         * myCommentContent : 666
         */

        private String address;
        private int cinemaId;
        private String cinemaName;
        private long commentTime;
        private int distance;
        private String logo;
        private String myCommentContent;

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

        public String getCinemaName() {
            return cinemaName;
        }

        public void setCinemaName(String cinemaName) {
            this.cinemaName = cinemaName;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getMyCommentContent() {
            return myCommentContent;
        }

        public void setMyCommentContent(String myCommentContent) {
            this.myCommentContent = myCommentContent;
        }
    }
}
