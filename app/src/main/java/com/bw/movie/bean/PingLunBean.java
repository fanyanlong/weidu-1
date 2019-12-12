package com.bw.movie.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/11/19
 *@Time:15:48
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class PingLunBean {

    /**
     * message : 查询成功
     * result : [{"commentContent":"","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":2169,"commentTime":1573823968000,"commentUserId":13764,"commentUserName":"鱼清","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-25/20191025153053.jpg","commentId":2131,"commentTime":1573214821000,"commentUserId":13721,"commentUserName":"昨天的你","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":9.8},{"commentContent":"太振业要坐飞机","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-09-07/20190907140903.jpg","commentId":2125,"commentTime":1573003113000,"commentUserId":13472,"commentUserName":"红衣佳人白衣友","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":9.7},{"commentContent":"工信部整治APP","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115200650.jpg","commentId":2121,"commentTime":1572869626000,"commentUserId":13709,"commentUserName":"郝甜甜","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"这是在陆路","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115204216.png","commentId":1983,"commentTime":1572866279000,"commentUserId":13708,"commentUserName":"郭转晨","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":10}]
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
         * commentContent :
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * commentId : 2169
         * commentTime : 1573823968000
         * commentUserId : 13764
         * commentUserName : 鱼清
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 4.5
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<?> replyHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
