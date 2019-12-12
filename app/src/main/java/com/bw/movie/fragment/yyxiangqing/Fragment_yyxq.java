package com.bw.movie.fragment.yyxiangqing;
/*
 *@auther:李泽楷
 *@Date: 2019/11/30
 *@Time:12:00
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.bean.GzyyBean;
import com.bw.movie.bean.QxgzyyBean;
import com.bw.movie.bean.YyxiangqingBean;
import com.bw.movie.contract.IYyxqContract;
import com.bw.movie.presenter.IYyxqPresenter;

import butterknife.BindView;

public class Fragment_yyxq extends BaseFragment<IYyxqPresenter> implements IYyxqContract.IYyxqView {
    @BindView(R.id.img_cinemalocation)
    ImageView imgCinemalocation;
    @BindView(R.id.name_xiangqing)
    TextView nameXiangqing;
    @BindView(R.id.img_cinemadianhua)
    ImageView imgCinemadianhua;
    @BindView(R.id.phone_number)
    TextView phoneNumber;
    @BindView(R.id.luxian_text)
    TextView luxianText;

    @Override
    protected IYyxqPresenter providePresenter() {
        return new IYyxqPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        mPresenter.getYyxqPresenter(id);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_yyxq_yyxq;
    }

    @Override
    public void onYyxqSuccess(YyxiangqingBean bean) {
                nameXiangqing.setText(bean.getResult().getAddress());
                phoneNumber.setText(bean.getResult().getPhone());
                luxianText.setText(bean.getResult().getVehicleRoute());
    }

    @Override
    public void onGzyySuccess(GzyyBean bean) {

    }

    @Override
    public void onQxgzyySuccess(QxgzyyBean bean) {

    }

    @Override
    public void onFailure(Throwable e) {

    }


}
