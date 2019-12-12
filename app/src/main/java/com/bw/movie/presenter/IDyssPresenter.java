package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/12/1
 *@Time:17:32
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.DyssBean;
import com.bw.movie.contract.IDyssContract;
import com.bw.movie.model.IDyssModel;

public class IDyssPresenter extends BasePresenter<IDyssContract.IDyssView> implements IDyssContract.IDyssPresenter {

    private IDyssModel model;

    @Override
    protected void initModel() {
        model = new IDyssModel();
    }

    @Override
    public void getDyssPresenter(String keyword, String page, String count) {
        model.getDyssData(keyword, page, count, new IDyssContract.IDyssModel.IDyssModelCallback() {
            @Override
            public void onDyssSuccess(DyssBean bean) {
                getView().onDyssSuccess(bean);
            }

            @Override
            public void onDyssFailure(Throwable e) {
                getView().onDyssFailure(e);
            }
        });
    }
}
