package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/11/15
 *@Time:20:29
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.GzdyBean;
import com.bw.movie.bean.QxgzdyBean;
import com.bw.movie.bean.XiangqingBean;
import com.bw.movie.contract.IXiangqingContract;
import com.bw.movie.utils.RetrofitManager;

import java.util.Map;

public class IXiangqingModel implements IXiangqingContract.IXiangqingModel {
    @Override
    public void getXiangqingData(Map<String, Object> map, String movieId, IXiangqingModelCallback iXiangqingModelCallback) {
        RetrofitManager.getInstance().create().getXiangqing(map, movieId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<XiangqingBean>() {
                    @Override
                    public void onNext(XiangqingBean xiangqingBean) {
                        iXiangqingModelCallback.onXiangqingSuccess(xiangqingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iXiangqingModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getGzdyData(String userId, String sessionId, String movieId, IGzdyModelCallback iGzdygModelCallback) {
        RetrofitManager.getInstance().create().getGzdy(userId, sessionId, movieId)
                .compose(CommonSchedulers.io2main())
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
        RetrofitManager.getInstance().create().getQxgzdy(userId, sessionId, movieId)
                .compose(CommonSchedulers.io2main())
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
}
