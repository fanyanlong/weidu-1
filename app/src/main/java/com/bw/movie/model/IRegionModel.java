package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/11/13
 *@Time:19:48
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.contract.IRegionContract;
import com.bw.movie.utils.RetrofitManager;

public class IRegionModel implements IRegionContract.IRegionModel {

    @Override
    public void getRegionData(String regionId, IRegionModelCallback iRegionModelCallback) {
        RetrofitManager.getInstance().create().getRegion(regionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<RegionBean>() {
                    @Override
                    public void onNext(RegionBean regionBean) {
                        iRegionModelCallback.onRegionSuccess(regionBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iRegionModelCallback.onRegionFailure(e);
                    }
                });
    }
}
