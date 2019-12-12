package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/11/30
 *@Time:12:46
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.YyplBean;
import com.bw.movie.contract.IYyplContract;
import com.bw.movie.utils.RetrofitManager;

public class IYyplModel implements IYyplContract.IYyplModel {


    @Override
    public void getYyplData(String userId, String sessionId, String cinemaId, String page, String count, IYyplModelCallback iYyplModelCallback) {
        RetrofitManager.getInstance().create().getYypl(userId, sessionId, cinemaId, page, count).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<YyplBean>() {
                    @Override
                    public void onNext(YyplBean yyplBean) {
                        iYyplModelCallback.onYyplSuccess(yyplBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iYyplModelCallback.onYyplFailure(e);
                    }
                });
    }
}
