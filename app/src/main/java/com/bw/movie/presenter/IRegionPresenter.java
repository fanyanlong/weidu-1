package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/13
 *@Time:19:46
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.contract.IRegionContract;
import com.bw.movie.model.IRegionModel;

public class IRegionPresenter extends BasePresenter<IRegionContract.IRegionView> implements IRegionContract.IRegionPresenter {

    private IRegionModel iRegionModel;

    @Override
    protected void initModel() {
        iRegionModel = new IRegionModel();
    }

    @Override
    public void getRegionPresenter(String regionId) {
        iRegionModel.getRegionData(regionId, new IRegionContract.IRegionModel.IRegionModelCallback() {
            @Override
            public void onRegionSuccess(RegionBean bean) {
                    getView().onRegionSuccess(bean);
            }

            @Override
            public void onRegionFailure(Throwable e) {
                    getView().onRegionFailure(e);
            }
        });
    }
}
