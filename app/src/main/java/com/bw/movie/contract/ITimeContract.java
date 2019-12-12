package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:20:41
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.TimeBean;

public interface ITimeContract {
    interface ITimeView extends IBaseView {
        void onTimeSuccess(TimeBean bean);
        void onTimeFailure(Throwable e);
    }
    interface ITimeModel{
        void getTimeData(ITimeModelCallback iTimeModelCallback) ;
        interface ITimeModelCallback{
            void onTimeSuccess(TimeBean bean);
            void onTimeFailure(Throwable e);
        }
        }


    interface ITimePresenter{
        void getTimePresenter();
    }
}
