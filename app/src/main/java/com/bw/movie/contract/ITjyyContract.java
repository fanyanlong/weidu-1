package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:20:41
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.TjyyBean;

public interface ITjyyContract {
    interface ITjyyView extends IBaseView {
        void onTjyySuccess(TjyyBean bean);
        void onTjyyFailure(Throwable e);
    }
    interface ITjyyModel{
        void getTjyyData(String page,String count, ITjyyModelCallback iTjyyModelCallback) ;
        interface ITjyyModelCallback{
            void onTjyySuccess(TjyyBean bean);
            void onTjyyFailure(Throwable e);
        }
        }


    interface ITjyyPresenter{
        void getTjyyPresenter(String page,String count);
    }
}
