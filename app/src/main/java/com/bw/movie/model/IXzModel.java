package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/11/20
 *@Time:14:28
 *@Description:${DESCRIPTION}
 **/

import android.util.Log;

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.IdTimeYingYuanBean;
import com.bw.movie.bean.JgcxBean;
import com.bw.movie.bean.QyBean;
import com.bw.movie.bean.QycxBean;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.bean.XiangqingBean;
import com.bw.movie.contract.IXzContract;
import com.bw.movie.utils.RetrofitManager;

import java.util.Map;

public class IXzModel implements IXzContract.IXzModel {
    public static final String TAG="IXzModel";
    @Override
    public void getQyData(IQyModelCallback iQyModelCallback) {
        RetrofitManager.getInstance().create().getQy().compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<QyBean>() {
                    @Override
                    public void onNext(QyBean bean) {
                        iQyModelCallback.onQySuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iQyModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getJgcxData(String movieId, String page, String count, IJgcxModelCallback iJgcxModelCallback) {
                RetrofitManager.getInstance().create().getJgcx(movieId, page, count).compose(CommonSchedulers.io2main())
                        .subscribe(new CommonObserver<JgcxBean>() {
                            @Override
                            public void onNext(JgcxBean jgcxBean) {
                                iJgcxModelCallback.onJgcxSuccess(jgcxBean);
                            }

                            @Override
                            public void onError(Throwable e) {
                                iJgcxModelCallback.onFailure(e);
                            }
                        });
    }

    @Override
    public void getQycxData(String movieId,String regionId,String page,String count, IQycxModelCallback iQycxModelCallback) {
            RetrofitManager.getInstance().create().getQycx(movieId, regionId, page, count)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new CommonObserver<QycxBean>() {
                        @Override
                        public void onNext(QycxBean qycxBean) {
                            iQycxModelCallback.onQycxSuccess(qycxBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iQycxModelCallback.onFailure(e);
                        }
                    });
    }

    @Override
    public void getXiangqingData(Map<String,Object> map, String movieId, IXiangqingModelCallback iXiangqingModelCallback) {
                RetrofitManager.getInstance().create().getXiangqing(map,movieId)
                        .compose(CommonSchedulers.io2main())
                        .subscribe(new CommonObserver<XiangqingBean>() {
                            @Override
                            public void onNext(XiangqingBean xiangqingBean) {
                                Log.i(TAG, "onXiangqingSuccess: "+xiangqingBean.getMessage());

                                iXiangqingModelCallback.onXiangqingSuccess(xiangqingBean);
                            }

                            @Override
                            public void onError(Throwable e) {
                                iXiangqingModelCallback.onFailure(e);
                            }
                        });
    }

    @Override
    public void getTimeData(ITimeModelCallback iTimeModelCallback) {
            RetrofitManager.getInstance().create().gettime().compose(CommonSchedulers.io2main())
                    .subscribe(new CommonObserver<TimeBean>() {
                        @Override
                        public void onNext(TimeBean timeBean) {
                            iTimeModelCallback.onTimeSuccess(timeBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iTimeModelCallback.onFailure(e);
                        }
                    });
    }

    @Override
    public void getIdTimeYingData(String movieId, String date, String page, String count, IIdTimeYingModelCallback iIdTimeYingModelCallback) {
        RetrofitManager.getInstance().create().getIdTimeYingYuan(movieId, date, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<IdTimeYingYuanBean>() {
                    @Override
                    public void onNext(IdTimeYingYuanBean idTimeYingYuanBean) {
                        iIdTimeYingModelCallback.onIdTimeYingSuccess(idTimeYingYuanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iIdTimeYingModelCallback.onFailure(e);
                    }
                });
    }
}
