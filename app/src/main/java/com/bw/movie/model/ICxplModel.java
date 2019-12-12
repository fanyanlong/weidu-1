package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/12/2
 *@Time:21:47
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.CxdyplBean;
import com.bw.movie.bean.CxyyplBean;
import com.bw.movie.contract.ICxplContract;
import com.bw.movie.utils.RetrofitManager;

public class ICxplModel implements ICxplContract.ICxplModel {
    @Override
    public void getCxdyplData(String userId, String sessionId, String page, String count, ICxdyplModelCallback iCxdyplModelCallback) {
        RetrofitManager.getInstance().create().getCxdypl(userId, sessionId, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CxdyplBean>() {
                    @Override
                    public void onNext(CxdyplBean cxdyplBean) {
                        iCxdyplModelCallback.onCxdyplSuccess(cxdyplBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iCxdyplModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getCxyyplData(String userId, String sessionId, String page, String count, ICxyyplModelCallback iCxyyplModelCallback) {
        RetrofitManager.getInstance().create().getCxyypl(userId, sessionId, page, count).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CxyyplBean>() {
                    @Override
                    public void onNext(CxyyplBean cxyyplBean) {
                        iCxyyplModelCallback.onCxyyplSuccess(cxyyplBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iCxyyplModelCallback.onFailure(e);
                    }
                });
    }
}
