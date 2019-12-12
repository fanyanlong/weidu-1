package com.bw.movie;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.fragment.gengduo.Fragment_jjsy;
import com.bw.movie.fragment.gengduo.Fragment_rmdy;
import com.bw.movie.fragment.gengduo.Fragment_zzry;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *@describe(描述)：GddyActivity
 *@data（日期）: 2019/12/3
 *@time（时间）: 13:58
 *@author（作者）: 李泽楷
 **/

public class GddyActivity extends BaseActivity {


    @BindView(R.id.image_dy)
    ImageView imageDy;
    @BindView(R.id.image_gd_ss)
    ImageView imageGdSs;
    @BindView(R.id.tab_gd)
    TabLayout tabGd;
    @BindView(R.id.viewpager_gd)
    ViewPager viewpagerGd;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_gddy;
    }

    @Override
    protected void initView() {
        super.initView();
        Fresco.initialize(this);
    }

    @Override
    protected void initData() {
        super.initData();
        List<String>namelist=new ArrayList<>();
        namelist.add("正在热映");
        namelist.add("即将上映");
        namelist.add("热门电影");
        List<Fragment> list=new ArrayList<>();
        list.add(new Fragment_zzry());
        list.add(new Fragment_jjsy());
        list.add(new Fragment_rmdy());
        viewpagerGd.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return namelist.get(position);
            }
        });
        tabGd.setupWithViewPager(viewpagerGd);
        viewpagerGd.setOffscreenPageLimit(3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.image_dy, R.id.image_gd_ss})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_dy:
                finish();
                break;
            case R.id.image_gd_ss:
                break;
        }
    }
}
