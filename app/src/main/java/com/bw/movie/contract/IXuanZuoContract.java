package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/20
 *@Time:17:27
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.DypqBean;
import com.bw.movie.bean.XdBean;
import com.bw.movie.bean.XuanZuoBean;
import com.bw.movie.bean.ZfBean;

public interface IXuanZuoContract {
    interface IXuanZuoView extends IBaseView {
        void onXuanZuoSuccess(XuanZuoBean bean);
        void onDypqSuccess(DypqBean bean);
        void onXdSuccess(XdBean bean);
        void onZfSuccess(ZfBean bean);
        void onFailure(Throwable e);
    }
    interface IXuanZuoModel{
        void getXuanZuoData(String hallId, IXuanZuoModelCallback iXuanZuoModelCallback) ;
        interface IXuanZuoModelCallback{
            void onXuanZuoSuccess(XuanZuoBean bean);
            void onFailure(Throwable e);
        }
        void getDypqData(String movieId,String cinemaId, IDypqModelCallback iDypqModelCallback) ;
        interface IDypqModelCallback{
            void onDypqSuccess(DypqBean bean);
            void onFailure(Throwable e);
        }
        void getXdData(String userId,String sessionId,String scheduleId,String seat,String sign,IXdModelCallback iXdModelCallback);
        interface IXdModelCallback{
            void onXdSuccess(XdBean bean);
            void onFailure(Throwable e);
        }
        void getZfData(String userId,String sessionId,String payType,String orderId,getZfModelCallback getZfModelCallback);
        interface getZfModelCallback{
            void onZfSuccess(ZfBean bean);
            void onFailure(Throwable e);
        }

    }


    interface IXuanZuogPresenter{
        void getXuanZuoPresenter(String hallId);
        void getDypqPresenter(String movieId,String cinemaId);
        void getXdPresenter(String userId,String sessionId,String scheduleId,String seat,String sign);
        void getZfPresenter(String userId,String sessionId,String payType,String orderId);
    }
}
