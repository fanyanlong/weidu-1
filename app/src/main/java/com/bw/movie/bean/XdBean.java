package com.bw.movie.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/11/28
 *@Time:20:24
 *@Description:${DESCRIPTION}
 **/

public class XdBean {

    /**
     * orderId : 20180807084055347
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
