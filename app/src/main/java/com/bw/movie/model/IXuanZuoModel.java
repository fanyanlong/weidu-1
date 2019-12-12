package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/11/20
 *@Time:17:34
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.DypqBean;
import com.bw.movie.bean.XdBean;
import com.bw.movie.bean.XuanZuoBean;
import com.bw.movie.bean.ZfBean;
import com.bw.movie.contract.IXuanZuoContract;
import com.bw.movie.utils.RetrofitManager;

public class IXuanZuoModel implements IXuanZuoContract.IXuanZuoModel {


    @Override
    public void getXuanZuoData(String hallId, IXuanZuoModelCallback iXuanZuoModelCallback) {
        RetrofitManager.getInstance().create().getXuanZuo(hallId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<XuanZuoBean>() {
                    @Override
                    public void onNext(XuanZuoBean xuanZuoBean) {
                        iXuanZuoModelCallback.onXuanZuoSuccess(xuanZuoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iXuanZuoModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getDypqData(String movieId, String cinemaId, IDypqModelCallback iDypqModelCallback) {
            RetrofitManager.getInstance().create().getDypq(movieId, cinemaId)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new CommonObserver<DypqBean>() {
                        @Override
                        public void onNext(DypqBean dypqBean) {
                            iDypqModelCallback.onDypqSuccess(dypqBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iDypqModelCallback.onFailure(e);
                        }
                    });
    }

    @Override
    public void getXdData(String userId, String sessionId, String scheduleId, String seat, String sign, IXdModelCallback iXdModelCallback) {
                RetrofitManager.getInstance().create().getXd(userId, sessionId, scheduleId, seat, sign).compose(CommonSchedulers.io2main())
                        .subscribe(new CommonObserver<XdBean>() {
                            @Override
                            public void onNext(XdBean bean) {
                                iXdModelCallback.onXdSuccess(bean);
                            }

                            @Override
                            public void onError(Throwable e) {
                                iXdModelCallback.onFailure(e);
                            }
                        });
    }

    @Override
    public void getZfData(String userId, String sessionId, String payType, String orderId, getZfModelCallback getZfModelCallback) {
            RetrofitManager.getInstance().create().getZf(userId, sessionId, payType, orderId).compose(CommonSchedulers.io2main())
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
