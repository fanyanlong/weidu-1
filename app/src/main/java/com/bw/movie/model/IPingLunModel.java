package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/11/19
 *@Time:15:59
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.PingLunBean;
import com.bw.movie.contract.IPingLunContract;
import com.bw.movie.utils.RetrofitManager;

public class IPingLunModel implements IPingLunContract.IPingLunModel {
    @Override
    public void getPingLunData(String movieId, String page, String count, IPingLunModelCallback iPingLunModelCallback) {
        RetrofitManager.getInstance().create().getPingLun(movieId, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PingLunBean>() {
                    @Override
                    public void onNext(PingLunBean pingLunBean) {
                        iPingLunModelCallback.onPingLunSuccess(pingLunBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iPingLunModelCallback.onPingLunFailure(e);
                    }
                });
    }
}
