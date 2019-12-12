package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/12/1
 *@Time:14:57
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.YypqBean;
import com.bw.movie.contract.IYypqContract;
import com.bw.movie.utils.RetrofitManager;

public class IYypqModel implements IYypqContract.IYypqModel {
    @Override
    public void getYypqData(String cinemaId, String page, String count, IYypqModelCallback iYypqModelCallback) {
        RetrofitManager.getInstance().create().getYypq(cinemaId, page, count).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<YypqBean>() {
                    @Override
                    public void onNext(YypqBean yypqBean) {
                        iYypqModelCallback.onYypqSuccess(yypqBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iYypqModelCallback.onYypqFailure(e);
                    }
                });
    }
}
