package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/29
 *@Time:13:56
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.YyplBean;

public interface IYyplContract {
    interface IYyplView extends IBaseView {
        void onYyplSuccess(YyplBean bean);
        void onYyplFailure(Throwable e);
    }
    interface IYyplModel{
        void getYyplData(String userId,String sessionId,String cinemaId, String page,String count, IYyplModelCallback iYyplModelCallback) ;
        interface IYyplModelCallback{
            void onYyplSuccess(YyplBean bean);
            void onYyplFailure(Throwable e);
        }
    }


    interface IYyplPresenter{
        void getYyplPresenter(String userId,String sessionId,String cinemaId, String page,String count);
    }
}
