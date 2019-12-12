package com.bw.movie.bean;

/**
 * date:2019/10/23
 * author:贺少伟(盗)
 * function:
 */
public class WxLogBean {
    public ResultBean result;
    public String message;
    public String status;

    public static class ResultBean {
        /**
         * sessionId : 157551655108613748
         * userId : 13748
         * userInfo : {"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKCfd6uSmW6F3FJJwXLcGEeNFm3Bd9Dnn1USEiafa2zeZD7FVjGVNQ5eT0iaQzBRQMGz7Y60iaDmb2vg/132","id":13748,"lastLoginTime":1575516371000,"nickName":"m._Sxi","sex":1}
         */

        public String sessionId;
        public int userId;
        public UserInfoBean userInfo;

        public static class UserInfoBean {
            /**
             * headPic : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKCfd6uSmW6F3FJJwXLcGEeNFm3Bd9Dnn1USEiafa2zeZD7FVjGVNQ5eT0iaQzBRQMGz7Y60iaDmb2vg/132
             * id : 13748
             * lastLoginTime : 1575516371000
             * nickName : m._Sxi
             * sex : 1
             */

            public String headPic;
            public int id;
            public long lastLoginTime;
            public String nickName;
            public int sex;
        }
    }

}
