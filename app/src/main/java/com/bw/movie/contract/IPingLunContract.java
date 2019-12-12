package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:20:41
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.PingLunBean;
import com.bw.movie.bean.RegionBean;

public interface IPingLunContract {
    interface IPingLunView extends IBaseView {
        void onPingLunSuccess(PingLunBean bean);
        void onPingLunFailure(Throwable e);
    }
    interface IPingLunModel{
        void getPingLunData(String movieId,String page,String count, IPingLunModelCallback iPingLunModelCallback) ;
        interface IPingLunModelCallback{
            void onPingLunSuccess(PingLunBean bean);
            void onPingLunFailure(Throwable e);
        }
        }


    interface IPingLunPresenter{
        void getPingLunPresenter(String movieId,String page,String count);
    }
}
