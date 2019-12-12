package com.bw.movie.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/12/2
 *@Time:21:35
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class CxdyplBean {

    /**
     * result : [{"commentTime":1575290224000,"director":"徐克","imageUrl":"http://172.17.8.100/images/movie/stills/drjzsdtw/drjzsdtw1.jpg","movieId":4,"movieName":"狄仁杰之四大天王","movieScore":0,"myCommentContent":"123","myCommentScore":5.5,"starring":"赵又廷,冯绍峰,林更新,刘嘉玲,阮经天,马思纯"},{"commentTime":1575290200000,"director":"韦正","imageUrl":"http://172.17.8.100/images/movie/stills/aqgy/aqgy1.jpg","movieId":15,"movieName":"爱情公寓","movieScore":0,"myCommentContent":"great","myCommentScore":5.5,"starring":"陈赫,娄艺潇,邓家佳,孙艺洲"},{"commentTime":1575290200000,"director":"韦正","imageUrl":"http://172.17.8.100/images/movie/stills/aqgy/aqgy1.jpg","movieId":15,"movieName":"爱情公寓","movieScore":0,"myCommentContent":"great","myCommentScore":5.5,"starring":"陈赫,娄艺潇,邓家佳,孙艺洲"},{"commentTime":1575290200000,"director":"韦正","imageUrl":"http://172.17.8.100/images/movie/stills/aqgy/aqgy1.jpg","movieId":15,"movieName":"爱情公寓","movieScore":0,"myCommentContent":"great","myCommentScore":5.5,"starring":"陈赫,娄艺潇,邓家佳,孙艺洲"},{"commentTime":1575290200000,"director":"韦正","imageUrl":"http://172.17.8.100/images/movie/stills/aqgy/aqgy1.jpg","movieId":15,"movieName":"爱情公寓","movieScore":0,"myCommentContent":"great","myCommentScore":5.5,"starring":"陈赫,娄艺潇,邓家佳,孙艺洲"},{"commentTime":1575290200000,"director":"韦正","imageUrl":"http://172.17.8.100/images/movie/stills/aqgy/aqgy1.jpg","movieId":15,"movieName":"爱情公寓","movieScore":0,"myCommentContent":"great","myCommentScore":5.5,"starring":"陈赫,娄艺潇,邓家佳,孙艺洲"},{"commentTime":1575290051000,"director":"闫非","imageUrl":"http://172.17.8.100/images/movie/stills/xhssf/xhssf1.jpg","movieId":3,"movieName":"西虹市首富","movieScore":0,"myCommentContent":"132","myCommentScore":5.5,"starring":"沈腾,宋芸烨,张晨光,艾伦,常远"},{"commentTime":1575289768000,"director":"克里斯托弗·麦奎里","imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieId":16,"movieName":"碟中谍6：全面瓦解","movieScore":0,"myCommentContent":"123","myCommentScore":5.5,"starring":"汤姆·克鲁斯,亨利·卡维尔,丽贝卡·弗格森,西蒙·佩吉"},{"commentTime":1575289614000,"director":"吕乐","imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg","movieId":21,"movieName":"找到你","movieScore":0,"myCommentContent":"ff","myCommentScore":5.5,"starring":"姚晨,马伊琍,袁文康,吴昊宸"},{"commentTime":1575289176000,"director":"\r\n刘伟强","imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz1.jpg","movieId":24,"movieName":"中国机长","movieScore":0,"myCommentContent":"ttt","myCommentScore":5.5,"starring":"张涵予,欧豪,袁泉,张天爱,李沁"}]
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
         * commentTime : 1575290224000
         * director : 徐克
         * imageUrl : http://172.17.8.100/images/movie/stills/drjzsdtw/drjzsdtw1.jpg
         * movieId : 4
         * movieName : 狄仁杰之四大天王
         * movieScore : 0
         * myCommentContent : 123
         * myCommentScore : 5.5
         * starring : 赵又廷,冯绍峰,林更新,刘嘉玲,阮经天,马思纯
         */

        private long commentTime;
        private String director;
        private String imageUrl;
        private int movieId;
        private String movieName;
        private int movieScore;
        private String myCommentContent;
        private double myCommentScore;
        private String starring;

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public int getMovieScore() {
            return movieScore;
        }

        public void setMovieScore(int movieScore) {
            this.movieScore = movieScore;
        }

        public String getMyCommentContent() {
            return myCommentContent;
        }

        public void setMyCommentContent(String myCommentContent) {
            this.myCommentContent = myCommentContent;
        }

        public double getMyCommentScore() {
            return myCommentScore;
        }

        public void setMyCommentScore(double myCommentScore) {
            this.myCommentScore = myCommentScore;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
