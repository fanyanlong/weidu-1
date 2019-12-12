package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/20
 *@Time:15:44
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.contract.ITimeContract;
import com.bw.movie.model.ITimeModel;

public class ITimePresenter extends BasePresenter<ITimeContract.ITimeView> implements ITimeContract.ITimePresenter {

    private ITimeModel iTimeModel;

    @Override
    protected void initModel() {
        iTimeModel = new ITimeModel();
    }

    @Override
    public void getTimePresenter() {
            iTimeModel.getTimeData(new ITimeContract.ITimeModel.ITimeModelCallback() {
                @Override
                public void onTimeSuccess(TimeBean bean) {
                    getView().onTimeSuccess(bean);
                }

                @Override
                public void onTimeFailure(Throwable e) {
                    getView().onTimeFailure(e);
                }
            });
    }
}
