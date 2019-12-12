package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/20
 *@Time:14:28
 *@Description:${DESCRIPTION}
 **/

import android.util.Log;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.IdTimeYingYuanBean;
import com.bw.movie.bean.JgcxBean;
import com.bw.movie.bean.QyBean;
import com.bw.movie.bean.QycxBean;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.bean.XiangqingBean;
import com.bw.movie.contract.IXzContract;
import com.bw.movie.model.IXzModel;

import java.util.Map;

public class IXzPresenter extends BasePresenter<IXzContract.IXzView> implements IXzContract.IXzPresenter {

    private IXzModel model;
    public static final String TAG="IXzPresenter";
    @Override
    protected void initModel() {
        model = new IXzModel();
    }

    @Override
    public void getIdTimeYingPresenter(String movieId, String date, String page, String count) {
            model.getIdTimeYingData(movieId, date, page, count, new IXzContract.IXzModel.IIdTimeYingModelCallback() {
                @Override
                public void onIdTimeYingSuccess(IdTimeYingYuanBean bean) {
                    getView().onIdTimeYingSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getTimePresenter() {
            model.getTimeData(new IXzContract.IXzModel.ITimeModelCallback() {
                @Override
                public void onTimeSuccess(TimeBean bean) {
                    getView().onTimeSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getXiangqingPresenter(Map<String, Object> map, String movieId) {
                model.getXiangqingData(map, movieId, new IXzContract.IXzModel.IXiangqingModelCallback() {
                    @Override
                    public void onXiangqingSuccess(XiangqingBean bean) {
                        getView().onXiangqingSuccess(bean);
                        Log.i(TAG, "onXiangqingSuccess: "+bean.getMessage());
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        getView().onFailure(e);
                    }
                });
    }

    @Override
    public void getQycxPresenter(String movieId,String regionId,String page,String count) {
                model.getQycxData(movieId, regionId, page, count, new IXzContract.IXzModel.IQycxModelCallback() {
                    @Override
                    public void onQycxSuccess(QycxBean bean) {
                        getView().onQycxSuccess(bean);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        getView().onFailure(e);
                    }
                });
    }

    @Override
    public void getJgcxPresenter(String movieId, String page, String count) {
                model.getJgcxData(movieId, page, count, new IXzContract.IXzModel.IJgcxModelCallback() {
                    @Override
                    public void onJgcxSuccess(JgcxBean bean) {
                        getView().onJgcxSuccess(bean);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        getView().onFailure(e);
                    }
                });
    }

    @Override
    public void getQyPresenter() {
            model.getQyData(new IXzContract.IXzModel.IQyModelCallback() {
                @Override
                public void onQySuccess(QyBean bean) {
                    getView().onQySuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }
}
