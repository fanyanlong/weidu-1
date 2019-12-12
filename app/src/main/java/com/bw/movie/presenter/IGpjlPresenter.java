package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/12/1
 *@Time:21:13
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.DdxqBean;
import com.bw.movie.bean.GpjlBean;
import com.bw.movie.bean.ZfBean;
import com.bw.movie.contract.IGpjlContract;
import com.bw.movie.model.IGpjlModel;

public class IGpjlPresenter extends BasePresenter<IGpjlContract.IGpjlView> implements IGpjlContract.IGpjlPresenter {

    private IGpjlModel model;

    @Override
    protected void initModel() {
        model = new IGpjlModel();
    }

    @Override
    public void getGpjlPresenter(String userId, String sessionId, String page, String count, String status) {
        model.getGpjlData(userId, sessionId, page, count, status, new IGpjlContract.IGpjlModel.IGpjlModelCallback() {
            @Override
            public void onGpjlSuccess(GpjlBean bean) {
                getView().onGpjlSuccess(bean);
            }

            @Override
            public void onGpjlFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getDdxqPresenter(String userId, String sessionId, String orderId) {
            model.getDdxqData(userId, sessionId, orderId, new IGpjlContract.IGpjlModel.IDdxqModelCallback() {
                @Override
                public void onDdxqSuccess(DdxqBean bean) {
                    getView().onDdxqSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getZfPresenter(String userId, String sessionId, String payType, String orderId) {
        model.getZfData(userId, sessionId, payType, orderId, new IGpjlContract.IGpjlModel.getZfModelCallback() {
            @Override
            public void onZfSuccess(ZfBean bean) {
                getView().onZfSuccess(bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }
}
