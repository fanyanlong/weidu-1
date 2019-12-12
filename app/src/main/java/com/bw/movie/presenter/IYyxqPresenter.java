package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/29
 *@Time:14:11
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.GzyyBean;
import com.bw.movie.bean.QxgzyyBean;
import com.bw.movie.bean.YyxiangqingBean;
import com.bw.movie.contract.IYyxqContract;
import com.bw.movie.model.IYyxqModel;

public class IYyxqPresenter extends BasePresenter<IYyxqContract.IYyxqView> implements IYyxqContract.IYyxqPresenter {

    private IYyxqModel iYyxqModel;

    @Override
    protected void initModel() {
        iYyxqModel = new IYyxqModel();
    }

    @Override
    public void getYyxqPresenter(String cinemaId) {
            iYyxqModel.getYyxqData(cinemaId, new IYyxqContract.IYyxqModel.IYyxqModelCallback() {
                @Override
                public void onYyxqSuccess(YyxiangqingBean bean) {
                    getView().onYyxqSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getGzyyPresenter(String userId, String sessionId, String cinemaId) {
            iYyxqModel.getGzyyData(userId, sessionId, cinemaId, new IYyxqContract.IYyxqModel.IGzyyModelCallback() {
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
            iYyxqModel.getQxgzyyData(userId, sessionId, cinemaId, new IYyxqContract.IYyxqModel.IQxgzyyModelCallback() {
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
}
