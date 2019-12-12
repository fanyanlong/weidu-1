package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/29
 *@Time:13:56
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.DyssBean;

public interface IDyssContract {
    interface IDyssView extends IBaseView {
        void onDyssSuccess(DyssBean bean);
        void onDyssFailure(Throwable e);
    }
    interface IDyssModel{
        void getDyssData(String keyword,String page,String count,IDyssModelCallback iDyssModelCallback) ;
        interface IDyssModelCallback{
            void onDyssSuccess(DyssBean bean);
            void onDyssFailure(Throwable e);
        }
    }


    interface IDyssPresenter{
        void getDyssPresenter(String keyword,String page,String count);
    }
}
