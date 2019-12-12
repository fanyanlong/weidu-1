package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/15
 *@Time:20:31
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.GzdyBean;
import com.bw.movie.bean.QxgzdyBean;
import com.bw.movie.bean.XiangqingBean;
import com.bw.movie.contract.IXiangqingContract;
import com.bw.movie.model.IXiangqingModel;

import java.util.Map;

public class IXiangqingPresenter extends BasePresenter<IXiangqingContract.IXiangqingView>implements IXiangqingContract.IXiangqingPresenter {

    private IXiangqingModel model;

    @Override
    protected void initModel() {
        model = new IXiangqingModel();
    }

    @Override
    public void getXiangqingPresenter(Map<String, Object> map, String movieId) {
        model.getXiangqingData(map, movieId, new IXiangqingContract.IXiangqingModel.IXiangqingModelCallback() {
            @Override
            public void onXiangqingSuccess(XiangqingBean bean) {
                getView().onXiangqingSuccess(bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getGzdyPresenter(String userId, String sessionId, String movieId) {
            model.getGzdyData(userId, sessionId, movieId, new IXiangqingContract.IXiangqingModel.IGzdyModelCallback() {
                @Override
                public void onGzdySuccess(GzdyBean bean) {
                    getView().onGzdySuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getQxgzdyPresenter(String userId, String sessionId, String movieId) {
            model.getQxgzdyData(userId, sessionId, movieId, new IXiangqingContract.IXiangqingModel.IQxgzdyModelCallback() {
                @Override
                public void onQxgzdySuccess(QxgzdyBean bean) {
                    getView().onQxgzdySuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }
}
