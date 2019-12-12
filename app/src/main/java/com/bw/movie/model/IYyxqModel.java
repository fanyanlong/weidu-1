package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/11/29
 *@Time:14:10
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.GzyyBean;
import com.bw.movie.bean.QxgzyyBean;
import com.bw.movie.bean.YyxiangqingBean;
import com.bw.movie.contract.IYyxqContract;
import com.bw.movie.utils.RetrofitManager;

public class IYyxqModel implements IYyxqContract.IYyxqModel {
    @Override
    public void getYyxqData(String cinemaId, IYyxqModelCallback iYyxqModelCallback) {
        RetrofitManager.getInstance().create().getYyxiangqing(cinemaId).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<YyxiangqingBean>() {
                                       @Override
                                       public void onNext(YyxiangqingBean yyxiangqingBean) {
                                           iYyxqModelCallback.onYyxqSuccess(yyxiangqingBean);
                                       }

                                       @Override
                                       public void onError(Throwable e) {
                                           iYyxqModelCallback.onFailure(e);

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
}
