package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/12/2
 *@Time:19:02
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.DyypBean;
import com.bw.movie.contract.IDyypContract;
import com.bw.movie.utils.RetrofitManager;

public class IDyypModel implements IDyypContract.IDyypModel {
    @Override
    public void getDyypData(String userId, String sessionId, String movieId, String commentContent, String score, IDyypModelCallback iDyypModelCallback) {
        RetrofitManager.getInstance().create().getDyyp(userId, sessionId, movieId, commentContent, score).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DyypBean>() {
                    @Override
                    public void onNext(DyypBean dyypBean) {
                        iDyypModelCallback.onDyypSuccess(dyypBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iDyypModelCallback.onDyypFailure(e);
                    }
                });
    }
}
