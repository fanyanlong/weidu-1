package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/12/4
 *@Time:8:41
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.FkBean;

public interface IFkContract {
    interface IFkView extends IBaseView {
        void onFkSuccess(FkBean bean);
        void onFkFailure(Throwable e);
    }
    interface IFkModel{
        void getFkData(String userId,String sessionId,String content, IFkModelCallback iFkModelCallback) ;
        interface IFkModelCallback{
            void onFkSuccess(FkBean bean);
            void onFkFailure(Throwable e);
        }
    }


    interface IFkPresenter{
        void getFkPresenter(String userId,String sessionId,String content);
    }
}
