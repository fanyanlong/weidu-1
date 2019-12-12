package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:20:41
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.GzdyBean;
import com.bw.movie.bean.QxgzdyBean;
import com.bw.movie.bean.XiangqingBean;

import java.util.Map;

public interface IXiangqingContract {
    interface IXiangqingView extends IBaseView {
        void onXiangqingSuccess(XiangqingBean bean);
        void onGzdySuccess(GzdyBean bean);
        void onQxgzdySuccess(QxgzdyBean bean);
        void onFailure(Throwable e);
    }
    interface IXiangqingModel{

        void getXiangqingData(Map<String,Object> map,String movieId, IXiangqingModelCallback iXiangqingModelCallback) ;
        interface IXiangqingModelCallback{
            void onXiangqingSuccess(XiangqingBean bean);
            void onFailure(Throwable e);
        }
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
        }


    interface IXiangqingPresenter{
        void getXiangqingPresenter(Map<String,Object> map,String movieId);
        void getGzdyPresenter(String userId,String sessionId,String movieId);
        void getQxgzdyPresenter(String userId,String sessionId,String movieId);
    }
}
