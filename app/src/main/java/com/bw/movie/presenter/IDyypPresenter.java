package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/12/2
 *@Time:19:02
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.DyypBean;
import com.bw.movie.contract.IDyypContract;
import com.bw.movie.model.IDyypModel;

public class IDyypPresenter extends BasePresenter<IDyypContract.IDyypView> implements IDyypContract.IDyypPresenter {

    private IDyypModel model;

    @Override
    protected void initModel() {
        model = new IDyypModel();
    }

    @Override
    public void getDyypPresenter(String userId, String sessionId, String movieId, String commentContent, String score) {
        model.getDyypData(userId, sessionId, movieId, commentContent, score, new IDyypContract.IDyypModel.IDyypModelCallback() {
            @Override
            public void onDyypSuccess(DyypBean bean) {
                getView().onDyypSuccess(bean);
            }

            @Override
            public void onDyypFailure(Throwable e) {
                getView().onDyypFailure(e);
            }
        });
    }
}
