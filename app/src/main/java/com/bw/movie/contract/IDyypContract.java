package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/29
 *@Time:13:56
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.DyypBean;

public interface IDyypContract {
    interface IDyypView extends IBaseView {
        void onDyypSuccess(DyypBean bean);
        void onDyypFailure(Throwable e);
    }
    interface IDyypModel{
        void getDyypData(String userId,String sessionId,String movieId,String commentContent,String score, IDyypModelCallback iDyypModelCallback) ;
        interface IDyypModelCallback{
            void onDyypSuccess(DyypBean bean);
            void onDyypFailure(Throwable e);
        }
    }


    interface IDyypPresenter{
        void getDyypPresenter(String userId,String sessionId,String movieId,String commentContent,String score);
    }
}
