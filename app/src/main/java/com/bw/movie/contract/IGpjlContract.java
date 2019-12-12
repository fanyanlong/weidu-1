package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/29
 *@Time:13:56
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.DdxqBean;
import com.bw.movie.bean.GpjlBean;
import com.bw.movie.bean.ZfBean;

public interface IGpjlContract {
    interface IGpjlView extends IBaseView {
        void onGpjlSuccess(GpjlBean bean);
        void onDdxqSuccess(DdxqBean bean);
        void onZfSuccess(ZfBean bean);

        void onFailure(Throwable e);
    }
    interface IGpjlModel{
        void getGpjlData(String userId,String sessionId, String page, String count,String status,IGpjlModelCallback iGpjlModelCallback) ;
        interface IGpjlModelCallback{
            void onGpjlSuccess(GpjlBean bean);
            void onGpjlFailure(Throwable e);
        }
        void getDdxqData(String userId,String sessionId,String orderId, IDdxqModelCallback iYyxqModelCallback) ;
        interface IDdxqModelCallback{
            void onDdxqSuccess(DdxqBean bean);
            void onFailure(Throwable e);
        }

        void getZfData(String userId,String sessionId,String payType,String orderId,getZfModelCallback getZfModelCallback);
        interface getZfModelCallback{
            void onZfSuccess(ZfBean bean);
            void onFailure(Throwable e);
        }
    }


    interface IGpjlPresenter{
        void getGpjlPresenter(String userId,String sessionId, String page, String count,String status);
        void getDdxqPresenter(String userId,String sessionId,String orderId);
        void getZfPresenter(String userId,String sessionId,String payType,String orderId);

    }
}
