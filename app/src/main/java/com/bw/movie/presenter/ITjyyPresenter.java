package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:21:20
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.ShowBean;
import com.bw.movie.bean.ShowingBean;
import com.bw.movie.bean.TjyyBean;
import com.bw.movie.bean.XbannerBean;
import com.bw.movie.contract.IMovieContract;
import com.bw.movie.contract.ITjyyContract;
import com.bw.movie.model.IMovieModel;
import com.bw.movie.model.ITjyyModel;

import java.util.Map;

public class ITjyyPresenter extends BasePresenter<ITjyyContract.ITjyyView> implements ITjyyContract.ITjyyPresenter {


    private ITjyyModel model;

    @Override
    protected void initModel() {
        model = new ITjyyModel();
    }

    @Override
    public void getTjyyPresenter(String page, String count) {
            model.getTjyyData(page, count, new ITjyyContract.ITjyyModel.ITjyyModelCallback() {
                @Override
                public void onTjyySuccess(TjyyBean bean) {
                    getView().onTjyySuccess(bean);
                }

                @Override
                public void onTjyyFailure(Throwable e) {
                    getView().onTjyyFailure(e);
                }
            });
    }
}
