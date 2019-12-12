package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/12/1
 *@Time:21:13
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.DdxqBean;
import com.bw.movie.bean.GpjlBean;
import com.bw.movie.bean.ZfBean;
import com.bw.movie.contract.IGpjlContract;
import com.bw.movie.utils.RetrofitManager;

public class IGpjlModel implements IGpjlContract.IGpjlModel {
    @Override
    public void getGpjlData(String userId, String sessionId, String page, String count, String status, IGpjlModelCallback iGpjlModelCallback) {
        RetrofitManager.getInstance().create().getGpjl(userId, sessionId, page, count, status).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<GpjlBean>() {
                    @Override
                    public void onNext(GpjlBean gpjlBean) {
                        iGpjlModelCallback.onGpjlSuccess(gpjlBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iGpjlModelCallback.onGpjlFailure(e);
                    }
                });
    }

    @Override
    public void getDdxqData(String userId, String sessionId, String orderId, IDdxqModelCallback iYyxqModelCallback) {
        RetrofitManager.getInstance().create().getDdxq(userId, sessionId, orderId).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DdxqBean>() {
                    @Override
                    public void onNext(DdxqBean ddxqBean) {
                        iYyxqModelCallback.onDdxqSuccess(ddxqBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iYyxqModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getZfData(String userId, String sessionId, String payType, String orderId, getZfModelCallback getZfModelCallback) {
            RetrofitManager.getInstance().create().getZf(userId, sessionId, payType, orderId)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new CommonObserver<ZfBean>() {
                        @Override
                        public void onNext(ZfBean bean) {
                            getZfModelCallback.onZfSuccess(bean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            getZfModelCallback.onFailure(e);
                        }
                    });
    }
}
