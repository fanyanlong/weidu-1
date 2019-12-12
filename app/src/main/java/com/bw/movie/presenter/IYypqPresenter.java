package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/12/1
 *@Time:15:04
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.YypqBean;
import com.bw.movie.contract.IYypqContract;
import com.bw.movie.model.IYypqModel;

public class IYypqPresenter extends BasePresenter<IYypqContract.IYypqView> implements IYypqContract.IYypqPresenter {

    private IYypqModel model;

    @Override
    protected void initModel() {
        model = new IYypqModel();
    }

    @Override
    public void getYypqPresenter(String cinemaId, String page, String count) {
        model.getYypqData(cinemaId, page, count, new IYypqContract.IYypqModel.IYypqModelCallback() {
            @Override
            public void onYypqSuccess(YypqBean bean) {
                getView().onYypqSuccess(bean);
            }

            @Override
            public void onYypqFailure(Throwable e) {
                getView().onYypqFailure(e);
            }
        });
    }
}
