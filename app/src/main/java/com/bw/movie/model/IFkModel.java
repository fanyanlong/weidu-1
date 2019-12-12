package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/12/4
 *@Time:8:46
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.FkBean;
import com.bw.movie.contract.IFkContract;
import com.bw.movie.utils.RetrofitManager;

public class IFkModel implements IFkContract.IFkModel {
    @Override
    public void getFkData(String userId, String sessionId, String content, IFkModelCallback iFkModelCallback) {
        RetrofitManager.getInstance().create().getFk(userId, sessionId, content).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FkBean>() {
                    @Override
                    public void onNext(FkBean fkBean) {
                        iFkModelCallback.onFkSuccess(fkBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iFkModelCallback.onFkFailure(e);
                    }
                });
    }
}
