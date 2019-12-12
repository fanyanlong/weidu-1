package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/20
 *@Time:17:34
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.DypqBean;
import com.bw.movie.bean.XdBean;
import com.bw.movie.bean.XuanZuoBean;
import com.bw.movie.bean.ZfBean;
import com.bw.movie.contract.IXuanZuoContract;
import com.bw.movie.model.IXuanZuoModel;

public class IXuanZuoPresenter extends BasePresenter<IXuanZuoContract.IXuanZuoView> implements IXuanZuoContract.IXuanZuogPresenter {


    private IXuanZuoModel model;

    @Override
    protected void initModel() {
        model = new IXuanZuoModel();
    }


    @Override
    public void getXuanZuoPresenter(String hallId) {
        model.getXuanZuoData(hallId, new IXuanZuoContract.IXuanZuoModel.IXuanZuoModelCallback() {
            @Override
            public void onXuanZuoSuccess(XuanZuoBean bean) {
                getView().onXuanZuoSuccess(bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getDypqPresenter(String movieId, String cinemaId) {
            model.getDypqData(movieId, cinemaId, new IXuanZuoContract.IXuanZuoModel.IDypqModelCallback() {
                @Override
                public void onDypqSuccess(DypqBean bean) {
                    getView().onDypqSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getXdPresenter(String userId, String sessionId, String scheduleId, String seat, String sign) {
                model.getXdData(userId, sessionId, scheduleId, seat, sign, new IXuanZuoContract.IXuanZuoModel.IXdModelCallback() {
                    @Override
                    public void onXdSuccess(XdBean bean) {
                        getView().onXdSuccess(bean);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        getView().onFailure(e);
                    }
                });
    }

    @Override
    public void getZfPresenter(String userId, String sessionId, String payType, String orderId) {
            model.getZfData(userId, sessionId, payType, orderId, new IXuanZuoContract.IXuanZuoModel.getZfModelCallback() {
                @Override
                public void onZfSuccess(ZfBean bean) {
                    getView().onZfSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }
}
