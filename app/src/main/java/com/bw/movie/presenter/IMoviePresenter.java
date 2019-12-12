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
import com.bw.movie.bean.XbannerBean;
import com.bw.movie.contract.IMovieContract;
import com.bw.movie.model.IMovieModel;

import java.util.Map;

public class IMoviePresenter extends BasePresenter<IMovieContract.IMovieView> implements IMovieContract.IMoviePresenter {

    private IMovieModel iMovieModel;

    @Override
    protected void initModel() {
        iMovieModel = new IMovieModel();
    }

    @Override
    public void getXbannerPresenter() {
        iMovieModel.getXbannerData(new IMovieContract.IMovieModel.IXbannerModelCallback() {
            @Override
            public void onXbannerSuccess(XbannerBean bean) {
                getView().onXbannerSuccess(bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getShowingrPresenter(String page, String count) {
        iMovieModel.getShowingData(page, count, new IMovieContract.IMovieModel.IShowingModelCallback() {
            @Override
            public void onShowingSuccess(ShowingBean bean) {
                getView().onShowingSuccess(bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getShowPresenter(String page, String count, Map<String, String> map) {
            iMovieModel.getShowData(page, count, map, new IMovieContract.IMovieModel.IShowModelCallback() {
                @Override
                public void onShowSuccess(ShowBean bean) {
                    getView().onShowSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getHotPresenter(String page, String count) {
            iMovieModel.getHotData(page, count, new IMovieContract.IMovieModel.IHotModelCallback() {
                @Override
                public void onHotSuccess(HotBean bean) {
                    getView().onHotSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }
}
