package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/12/3
 *@Time:15:36
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.CxgzdyBean;
import com.bw.movie.bean.CxgzyyBean;
import com.bw.movie.bean.GzdyBean;
import com.bw.movie.bean.GzyyBean;
import com.bw.movie.bean.QxgzdyBean;
import com.bw.movie.bean.QxgzyyBean;
import com.bw.movie.contract.IWdgzContract;
import com.bw.movie.model.IWdgzModel;

public class IWdgzPresenter extends BasePresenter<IWdgzContract.IWdgzView> implements IWdgzContract.IWdgzPresenter {

    private IWdgzModel model;

    @Override
    protected void initModel() {
        model = new IWdgzModel();
    }

    @Override
    public void getGzdyPresenter(String userId, String sessionId, String movieId) {
model.getGzdyData(userId, sessionId, movieId, new IWdgzContract.IWdgzModel.IGzdyModelCallback() {
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
        model.getQxgzdyData(userId, sessionId, movieId, new IWdgzContract.IWdgzModel.IQxgzdyModelCallback() {
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

    @Override
    public void getGzyyPresenter(String userId, String sessionId, String cinemaId) {
        model.getGzyyData(userId, sessionId, cinemaId, new IWdgzContract.IWdgzModel.IGzyyModelCallback() {
            @Override
            public void onGzyySuccess(GzyyBean bean) {
                getView().onGzyySuccess(bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getQxgzyyPresenter(String userId, String sessionId, String cinemaId) {
            model.getQxgzyyData(userId, sessionId, cinemaId, new IWdgzContract.IWdgzModel.IQxgzyyModelCallback() {
                @Override
                public void onQxgzyySuccess(QxgzyyBean bean) {
                    getView().onQxgzyySuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getCxgzdyPresenter(String userId, String sessionId, String page, String count) {
            model.getCxgzdyData(userId, sessionId, page, count, new IWdgzContract.IWdgzModel.ICxgzdyModelCallback() {
                @Override
                public void onCxgzdySuccess(CxgzdyBean bean) {
                    getView().onCxgzdySuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getCxgzyyPresenter(String userId, String sessionId, String page, String count) {
            model.getCxgzyyData(userId, sessionId, page, count, new IWdgzContract.IWdgzModel.ICxgzyyModelCallback() {
                @Override
                public void onCxgzyySuccess(CxgzyyBean bean) {
                    getView().onCxgzyySuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }
}
