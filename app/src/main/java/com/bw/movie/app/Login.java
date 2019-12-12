package com.bw.movie.app;
/*
 *@auther:李泽楷
 *@Date: 2019/12/2
 *@Time:10:55
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.SharedPreferences;

public class Login {
    public String userId;
    public  String sessionId;
    public  String headPic;
    public  String nickName;
    public  String sex;
    public Login(){

        SharedPreferences sp =App.getAppContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        String userId1 = sp.getString("userId", "11");
        userId=userId1;
        String sessionId = sp.getString("sessionId", "11");
        this.sessionId=sessionId;
        String headPic = sp.getString("headPic", "http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ4mmPbWgib79y330UsosUxhVict9nJibwu4bfeGPVUic552SqhKBHLB1NsDgIhdA52BPRqicB0Kz3pj0A/132");
        this.headPic=headPic;
        String nickName = sp.getString("nickName", "未登录");
        this.nickName=nickName;
        String sex = sp.getString("sex", "3");
        this.sex=sex;
    }

}
