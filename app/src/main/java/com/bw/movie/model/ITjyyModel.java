package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:21:21
 *@Description:${DESCRIPTION}
 **/


import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.TjyyBean;
import com.bw.movie.contract.IMovieContract;
import com.bw.movie.contract.ITjyyContract;
import com.bw.movie.utils.RetrofitManager;


public class ITjyyModel implements ITjyyContract.ITjyyModel {

    @Override
    public void getTjyyData(String page, String count, ITjyyModelCallback iTjyyModelCallback) {
        RetrofitManager.getInstance().create().getTjyy(page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<TjyyBean>() {
                    @Override
                    public void onNext(TjyyBean tjyyBean) {
                        iTjyyModelCallback.onTjyySuccess(tjyyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iTjyyModelCallback.onTjyyFailure(e);
                    }
                });
    }
}
