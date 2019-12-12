package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/12/1
 *@Time:17:31
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.DyssBean;
import com.bw.movie.contract.IDyssContract;
import com.bw.movie.utils.RetrofitManager;

public class IDyssModel implements IDyssContract.IDyssModel {
    @Override
    public void getDyssData(String keyword, String page, String count, IDyssModelCallback iDyssModelCallback) {
        RetrofitManager.getInstance().create().getDyss(keyword, page, count).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DyssBean>() {
                    @Override
                    public void onNext(DyssBean dyssBean) {
                        iDyssModelCallback.onDyssSuccess(dyssBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iDyssModelCallback.onDyssFailure(e);
                    }
                });
    }
}
