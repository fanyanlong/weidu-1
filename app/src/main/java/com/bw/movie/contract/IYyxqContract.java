package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/29
 *@Time:13:56
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.GzyyBean;
import com.bw.movie.bean.QxgzyyBean;
import com.bw.movie.bean.YyxiangqingBean;

public interface IYyxqContract {
    interface IYyxqView extends IBaseView {
        void onYyxqSuccess(YyxiangqingBean bean);
        void onGzyySuccess(GzyyBean bean);
        void onQxgzyySuccess(QxgzyyBean bean);
        void onFailure(Throwable e);
    }
    interface IYyxqModel{
        void getYyxqData(String cinemaId,IYyxqModelCallback iYyxqModelCallback) ;
        interface IYyxqModelCallback{
            void onYyxqSuccess(YyxiangqingBean bean);
            void onFailure(Throwable e);
        }

        void getGzyyData(String userId,String sessionId,String cinemaId, IGzyyModelCallback iGzyygModelCallback) ;
        interface IGzyyModelCallback{
            void onGzyySuccess(GzyyBean bean);
            void onFailure(Throwable e);
        }
        void getQxgzyyData(String userId,String sessionId,String cinemaId, IQxgzyyModelCallback iQxgzyyModelCallback) ;
        interface IQxgzyyModelCallback{
            void onQxgzyySuccess(QxgzyyBean bean);
            void onFailure(Throwable e);
        }
    }


    interface IYyxqPresenter{
        void getYyxqPresenter(String cinemaId);
        void getGzyyPresenter(String userId,String sessionId,String cinemaId);
        void getQxgzyyPresenter(String userId,String sessionId,String cinemaId);
    }
}
