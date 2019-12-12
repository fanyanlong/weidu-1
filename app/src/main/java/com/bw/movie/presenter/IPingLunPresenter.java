package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/19
 *@Time:15:58
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.PingLunBean;
import com.bw.movie.contract.IPingLunContract;
import com.bw.movie.model.IPingLunModel;

public class IPingLunPresenter extends BasePresenter<IPingLunContract.IPingLunView> implements IPingLunContract.IPingLunPresenter {

    private IPingLunModel iPingLunModel;

    @Override
    protected void initModel() {
        iPingLunModel = new IPingLunModel();
    }

    @Override
    public void getPingLunPresenter(String movieId, String page, String count) {
            iPingLunModel.getPingLunData(movieId, page, count, new IPingLunContract.IPingLunModel.IPingLunModelCallback() {
                @Override
                public void onPingLunSuccess(PingLunBean bean) {
                    getView().onPingLunSuccess(bean);
                }

                @Override
                public void onPingLunFailure(Throwable e) {
                    getView().onPingLunFailure(e);
                }
            });
    }
}
