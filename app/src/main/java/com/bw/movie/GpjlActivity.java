package com.bw.movie;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.fragment.gpjl.Fragment_dfk;
import com.bw.movie.fragment.gpjl.Fragment_yfk;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *@describe(描述)：GpjlActivity
 *@data（日期）: 2019/12/3
 *@time（时间）: 13:58
 *@author（作者）: 李泽楷
 **/

public class GpjlActivity extends BaseActivity {


    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.pager)
    ViewPager pager;
    private ArrayList<Fragment> list;
    private ArrayList<String> tablist;
    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_gpjl;
    }

    @Override
    protected void initView() {
        super.initView();
        Fresco.initialize(this);
    }

    @Override
    protected void initData() {
        super.initData();
        list = new ArrayList();
        list.add(new Fragment_dfk());
        list.add(new Fragment_yfk());
        tablist = new ArrayList<>();
        tablist.add("待付款");
        tablist.add("已付款");
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tablist.get(position);
            }
        });
        tab.setupWithViewPager(pager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.details_back)
    public void onClick() {
        finish();
    }
}
