package com.bw.movie.bean;

import java.util.List;

/**
 * @author: 张恩
 * @description:
 * @date :2019/12/3 20:51
 */
public class EmailMessageBean {

    /**
     * result : [{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8634,"pushTime":1575375233000,"status":0,"title":"系统通知","userId":13790},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8625,"pushTime":1575365478000,"status":0,"title":"系统通知","userId":13790},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8624,"pushTime":1575364976000,"status":0,"title":"系统通知","userId":13790},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8622,"pushTime":1575364409000,"status":0,"title":"系统通知","userId":13790},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8521,"pushTime":1575278357000,"status":0,"title":"系统通知","userId":13790},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8361,"pushTime":1575184689000,"status":0,"title":"系统通知","userId":13790},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8326,"pushTime":1575102617000,"status":0,"title":"系统通知","userId":13790},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8324,"pushTime":1575100932000,"status":0,"title":"系统通知","userId":13790},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8292,"pushTime":1575095932000,"status":0,"title":"系统通知","userId":13790}]
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
         * content : 您已购买电影票,请尽快完成支付,以免影响到您的观影
         * id : 8634
         * pushTime : 1575375233000
         * status : 0
         * title : 系统通知
         * userId : 13790
         */

        private String content;
        private int id;
        private long pushTime;
        private int status;
        private String title;
        private int userId;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getPushTime() {
            return pushTime;
        }

        public void setPushTime(long pushTime) {
            this.pushTime = pushTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
