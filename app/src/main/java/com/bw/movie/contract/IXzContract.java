package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/20
 *@Time:14:23
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.IdTimeYingYuanBean;
import com.bw.movie.bean.JgcxBean;
import com.bw.movie.bean.QyBean;
import com.bw.movie.bean.QycxBean;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.bean.XiangqingBean;

import java.util.Map;

public interface IXzContract {
    interface IXzView extends IBaseView {
        void onIdTimeYingSuccess(IdTimeYingYuanBean bean);
        void onQySuccess(QyBean bean);
        void onJgcxSuccess(JgcxBean bean);
        void onQycxSuccess(QycxBean bean);
        void onXiangqingSuccess(XiangqingBean bean);
        void onTimeSuccess(TimeBean bean);
        void onFailure(Throwable e);
    }
    interface IXzModel{
        void getQyData( IQyModelCallback iQyModelCallback) ;
        interface IQyModelCallback{
            void onQySuccess(QyBean bean);
            void onFailure(Throwable e);
        }
        void getJgcxData(String movieId,String page,String count, IJgcxModelCallback iJgcxModelCallback) ;
        interface IJgcxModelCallback{
            void onJgcxSuccess(JgcxBean bean);
            void onFailure(Throwable e);
        }
        void getQycxData(String movieId,String regionId,String page,String count, IQycxModelCallback iQycxModelCallback) ;
        interface IQycxModelCallback{
            void onQycxSuccess(QycxBean bean);
            void onFailure(Throwable e);
        }
        void getXiangqingData(Map<String,Object> map,String movieId, IXiangqingModelCallback iXiangqingModelCallback) ;
        interface IXiangqingModelCallback{
            void onXiangqingSuccess(XiangqingBean bean);
            void onFailure(Throwable e);
        }
        void getTimeData( ITimeModelCallback iTimeModelCallback) ;
        interface ITimeModelCallback{
            void onTimeSuccess(TimeBean bean);
            void onFailure(Throwable e);
        }
        void getIdTimeYingData(String movieId,String date,String page,String count, IIdTimeYingModelCallback iIdTimeYingModelCallback) ;
        interface IIdTimeYingModelCallback{
            void onIdTimeYingSuccess(IdTimeYingYuanBean bean);
            void onFailure(Throwable e);
        }
    }


    interface IXzPresenter{
        void getIdTimeYingPresenter(String movieId,String date,String page,String count);
        void getTimePresenter();
        void getXiangqingPresenter(Map<String,Object> map, String movieId);
        void getQycxPresenter(String movieId,String regionId,String page,String count);
        void getJgcxPresenter(String movieId,String page,String count);
        void getQyPresenter();

    }
}
