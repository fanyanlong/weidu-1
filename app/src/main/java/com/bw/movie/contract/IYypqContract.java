package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/29
 *@Time:13:56
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.YypqBean;

public interface IYypqContract {
    interface IYypqView extends IBaseView {
        void onYypqSuccess(YypqBean bean);
        void onYypqFailure(Throwable e);
    }
    interface IYypqModel{
        void getYypqData(String cinemaId,String page,String count, IYypqModelCallback iYypqModelCallback) ;
        interface IYypqModelCallback{
            void onYypqSuccess(YypqBean bean);
            void onYypqFailure(Throwable e);
        }
    }


    interface IYypqPresenter{
        void getYypqPresenter(String cinemaId,String page,String count);
    }
}
