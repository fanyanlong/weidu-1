package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/12/3
 *@Time:15:35
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.CxgzdyBean;
import com.bw.movie.bean.CxgzyyBean;
import com.bw.movie.bean.GzdyBean;
import com.bw.movie.bean.GzyyBean;
import com.bw.movie.bean.QxgzdyBean;
import com.bw.movie.bean.QxgzyyBean;
import com.bw.movie.contract.IWdgzContract;
import com.bw.movie.utils.RetrofitManager;

public class IWdgzModel implements IWdgzContract.IWdgzModel {
    @Override
    public void getGzdyData(String userId, String sessionId, String movieId, IGzdyModelCallback iGzdygModelCallback) {
        RetrofitManager.getInstance().create().getGzdy(userId, sessionId, movieId).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<GzdyBean>() {
                    @Override
                    public void onNext(GzdyBean gzdyBean) {
                        iGzdygModelCallback.onGzdySuccess(gzdyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iGzdygModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getQxgzdyData(String userId, String sessionId, String movieId, IQxgzdyModelCallback iQxgzdyModelCallback) {
        RetrofitManager.getInstance().create().getQxgzdy(userId, sessionId, movieId).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<QxgzdyBean>() {
                    @Override
                    public void onNext(QxgzdyBean qxgzdyBean) {
                        iQxgzdyModelCallback.onQxgzdySuccess(qxgzdyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iQxgzdyModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getGzyyData(String userId, String sessionId, String cinemaId, IGzyyModelCallback iGzyygModelCallback) {
        RetrofitManager.getInstance().create().getGzyy(userId, sessionId, cinemaId).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<GzyyBean>() {
                    @Override
                    public void onNext(GzyyBean gzyyBean) {
                        iGzyygModelCallback.onGzyySuccess(gzyyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iGzyygModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getQxgzyyData(String userId, String sessionId, String cinemaId, IQxgzyyModelCallback iQxgzyyModelCallback) {
        RetrofitManager.getInstance().create().getQxgzyy(userId, sessionId, cinemaId).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<QxgzyyBean>() {
                    @Override
                    public void onNext(QxgzyyBean qxgzyyBean) {
                        iQxgzyyModelCallback.onQxgzyySuccess(qxgzyyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iQxgzyyModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getCxgzdyData(String userId, String sessionId, String page, String count, ICxgzdyModelCallback iCxgzdyModelCallback) {
        RetrofitManager.getInstance().create().getCxgzdy(userId, sessionId, page, count).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CxgzdyBean>() {
                    @Override
                    public void onNext(CxgzdyBean bean) {
                        iCxgzdyModelCallback.onCxgzdySuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iCxgzdyModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getCxgzyyData(String userId, String sessionId, String page, String count, ICxgzyyModelCallback iCxgzyyModelCallback) {
        RetrofitManager.getInstance().create().getCxgzyy(userId, sessionId, page, count).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CxgzyyBean>() {
                    @Override
                    public void onNext(CxgzyyBean cxgzyyBean) {
                        iCxgzyyModelCallback.onCxgzyySuccess(cxgzyyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iCxgzyyModelCallback.onFailure(e);
                    }
                });
    }
}
