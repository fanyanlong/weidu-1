package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/12/3
 *@Time:15:22
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.CxgzdyBean;
import com.bw.movie.bean.CxgzyyBean;
import com.bw.movie.bean.GzdyBean;
import com.bw.movie.bean.GzyyBean;
import com.bw.movie.bean.QxgzdyBean;
import com.bw.movie.bean.QxgzyyBean;

public interface IWdgzContract {
    interface IWdgzView extends IBaseView {
        void onGzdySuccess(GzdyBean bean);
        void onQxgzdySuccess(QxgzdyBean bean);
        void onGzyySuccess(GzyyBean bean);
        void onQxgzyySuccess(QxgzyyBean bean);
        void onCxgzdySuccess(CxgzdyBean bean);
        void onCxgzyySuccess(CxgzyyBean bean);
        void onFailure(Throwable e);
    }
    interface IWdgzModel{

        void getGzdyData(String userId,String sessionId,String movieId, IGzdyModelCallback iGzdygModelCallback) ;
        interface IGzdyModelCallback{
            void onGzdySuccess(GzdyBean bean);
            void onFailure(Throwable e);
        }
        void getQxgzdyData(String userId,String sessionId,String movieId, IQxgzdyModelCallback iQxgzdyModelCallback) ;
        interface IQxgzdyModelCallback{
            void onQxgzdySuccess(QxgzdyBean bean);
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
        void getCxgzdyData(String userId,String sessionId, String page, String count, ICxgzdyModelCallback iCxgzdyModelCallback) ;
        interface ICxgzdyModelCallback{
            void onCxgzdySuccess(CxgzdyBean bean);
            void onFailure(Throwable e);
        }
        void getCxgzyyData(String userId,String sessionId, String page, String count, ICxgzyyModelCallback iCxgzyyModelCallback) ;
        interface ICxgzyyModelCallback{
            void onCxgzyySuccess(CxgzyyBean bean);
            void onFailure(Throwable e);
        }
    }
    interface IWdgzPresenter{
        void getGzdyPresenter(String userId,String sessionId,String movieId);
        void getQxgzdyPresenter(String userId,String sessionId,String movieId);
        void getGzyyPresenter(String userId,String sessionId,String cinemaId);
        void getQxgzyyPresenter(String userId,String sessionId,String cinemaId);
        void getCxgzdyPresenter(String userId,String sessionId, String page, String count);
        void getCxgzyyPresenter(String userId,String sessionId, String page, String count);
    }
}
