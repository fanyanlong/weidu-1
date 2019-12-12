package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/12/4
 *@Time:8:48
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.FkBean;
import com.bw.movie.contract.IFkContract;
import com.bw.movie.model.IFkModel;

public class IFkPresenter extends BasePresenter<IFkContract.IFkView> implements IFkContract.IFkPresenter {

    private IFkModel model;

    @Override
    protected void initModel() {
        model = new IFkModel();
    }

    @Override
    public void getFkPresenter(String userId, String sessionId, String content) {
            model.getFkData(userId, sessionId, content, new IFkContract.IFkModel.IFkModelCallback() {
                @Override
                public void onFkSuccess(FkBean bean) {
                    getView().onFkSuccess(bean);
                }

                @Override
                public void onFkFailure(Throwable e) {
                    getView().onFkFailure(e);
                }
            });
    }
}
