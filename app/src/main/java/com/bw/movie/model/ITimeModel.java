package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/11/20
 *@Time:15:43
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.contract.ITimeContract;
import com.bw.movie.utils.RetrofitManager;

public class ITimeModel implements ITimeContract.ITimeModel {
    @Override
    public void getTimeData(ITimeModelCallback iTimeModelCallback) {
        RetrofitManager.getInstance().create().gettime().compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<TimeBean>() {
                    @Override
                    public void onNext(TimeBean timeBean) {
                        iTimeModelCallback.onTimeSuccess(timeBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        iTimeModelCallback.onTimeFailure(e);
                    }
                });
    }
}
