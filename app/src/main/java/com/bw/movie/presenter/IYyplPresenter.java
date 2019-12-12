package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/30
 *@Time:12:46
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.YyplBean;
import com.bw.movie.contract.IYyplContract;
import com.bw.movie.model.IYyplModel;

public class IYyplPresenter extends BasePresenter<IYyplContract.IYyplView> implements IYyplContract.IYyplPresenter {

    private IYyplModel model;

    @Override
    protected void initModel() {
        model = new IYyplModel();
    }

    @Override
    public void getYyplPresenter(String userId, String sessionId, String cinemaId, String page, String count) {
        model.getYyplData(userId, sessionId, cinemaId, page, count, new IYyplContract.IYyplModel.IYyplModelCallback() {
            @Override
            public void onYyplSuccess(YyplBean bean) {
                getView().onYyplSuccess(bean);
            }

            @Override
            public void onYyplFailure(Throwable e) {
                getView().onYyplFailure(e);
            }
        });
    }
}
