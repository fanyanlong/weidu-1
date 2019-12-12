package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/12/2
 *@Time:21:47
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.CxdyplBean;
import com.bw.movie.bean.CxyyplBean;
import com.bw.movie.contract.ICxplContract;
import com.bw.movie.model.ICxplModel;

public class ICxplPresenter extends BasePresenter<ICxplContract.ICxplView> implements ICxplContract.ICxplPresenter {

    private ICxplModel model;

    @Override
    protected void initModel() {
        model = new ICxplModel();
    }

    @Override
    public void getCxyyplPresenter(String userId, String sessionId, String page, String count) {
        model.getCxyyplData(userId, sessionId, page, count, new ICxplContract.ICxplModel.ICxyyplModelCallback() {
            @Override
            public void onCxyyplSuccess(CxyyplBean bean) {
                getView().onCxyyplSuccess(bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getCxdyplPresenter(String userId, String sessionId, String page, String count) {
        model.getCxdyplData(userId, sessionId, page, count, new ICxplContract.ICxplModel.ICxdyplModelCallback() {
            @Override
            public void onCxdyplSuccess(CxdyplBean bean) {
                getView().onCxdyplSuccess(bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }
}
