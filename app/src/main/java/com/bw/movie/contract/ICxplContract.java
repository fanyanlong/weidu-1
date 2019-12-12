package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/29
 *@Time:13:56
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.CxdyplBean;
import com.bw.movie.bean.CxyyplBean;

public interface ICxplContract {
    interface ICxplView extends IBaseView {
        void onCxdyplSuccess(CxdyplBean bean);
        void onCxyyplSuccess(CxyyplBean bean);
        void onFailure(Throwable e);
    }
    interface ICxplModel{
        void getCxdyplData(String userId,String sessionId,String page,String count, ICxdyplModelCallback iCxdyplModelCallback) ;
        interface ICxdyplModelCallback{
            void onCxdyplSuccess(CxdyplBean bean);
            void onFailure(Throwable e);
        }
        void getCxyyplData(String userId,String sessionId,String page,String count, ICxyyplModelCallback iCxyyplModelCallback) ;
        interface ICxyyplModelCallback{
            void onCxyyplSuccess(CxyyplBean bean);
            void onFailure(Throwable e);
        }
    }


    interface ICxplPresenter{
        void getCxyyplPresenter(String userId,String sessionId,String page,String count);
        void getCxdyplPresenter(String userId,String sessionId,String page,String count);
    }
}
