package com.bw.movie.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/11/11
 *@Time:16:42
 *@Description:${DESCRIPTION}
 **/

public class EmailBean {

    /**
     * message : 发送成功
     * status : 0000
     */

    private String message;
    private String status;

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
