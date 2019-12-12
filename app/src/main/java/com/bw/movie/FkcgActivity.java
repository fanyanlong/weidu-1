package com.bw.movie;

import android.os.Bundle;
import android.widget.ImageView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FkcgActivity extends BaseActivity {


    @BindView(R.id.title_fanhui)
    ImageView titleFanhui;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_fkcg;
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.title_fanhui)
    public void onClick() {
        finish();
    }
}
