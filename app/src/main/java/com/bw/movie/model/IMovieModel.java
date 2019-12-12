package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:21:21
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.ShowBean;
import com.bw.movie.bean.ShowingBean;
import com.bw.movie.bean.XbannerBean;
import com.bw.movie.contract.IMovieContract;
import com.bw.movie.utils.RetrofitManager;

import java.util.Map;

public class IMovieModel implements IMovieContract.IMovieModel {
    @Override
    public void getXbannerData(IXbannerModelCallback iXbannerModelCallback) {
        RetrofitManager.getInstance().create().getXbanner()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<XbannerBean>() {
                    @Override
                    public void onNext(XbannerBean xbannerBean) {
                        iXbannerModelCallback.onXbannerSuccess(xbannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iXbannerModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getShowingData(String page, String count, IShowingModelCallback iShowingModelCallback) {
        RetrofitManager.getInstance().create().getShowing(page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<ShowingBean>() {
                    @Override
                    public void onNext(ShowingBean showingBean) {
                        iShowingModelCallback.onShowingSuccess(showingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iShowingModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getShowData(String page, String count, Map<String, String> map, IShowModelCallback iShowModelCallback) {
        RetrofitManager.getInstance().create().getShow(page, count, map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<ShowBean>() {
                    @Override
                    public void onNext(ShowBean showBean) {
                        iShowModelCallback.onShowSuccess(showBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iShowModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getHotData(String page, String count, IHotModelCallback iHotModelCallback) {
        RetrofitManager.getInstance().create().getHot(page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<HotBean>() {
                    @Override
                    public void onNext(HotBean hotBean) {
                        iHotModelCallback.onHotSuccess(hotBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
