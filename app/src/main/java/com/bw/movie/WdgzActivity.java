package com.bw.movie;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.fragment.Fragment_gzdy;
import com.bw.movie.fragment.Fragment_gzyy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @describe(描述)：WdgzActivity
 * @data（日期）: 2019/12/3
 * @time（时间）: 15:48
 * @author（作者）: 李泽楷
 **/

public class WdgzActivity extends BaseActivity {


    @BindView(R.id.my_guanzhu_fanhui)
    SimpleDraweeView myGuanzhuFanhui;
    @BindView(R.id.write_relation)
    RelativeLayout writeRelation;
    @BindView(R.id.my_guanzhu_tablayout)
    TabLayout myGuanzhuTablayout;
    @BindView(R.id.my_guanzhu_vp)
    ViewPager myGuanzhuVp;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_wdgz;
    }

    @Override
    protected void initData() {
        super.initData();
        myGuanzhuFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment_gzdy());
        list.add(new Fragment_gzyy());
        List<String> slist = new ArrayList<>();
        slist.add("电影");
        slist.add("影院");
        myGuanzhuVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
                return slist.get(position);
            }
        });
        myGuanzhuTablayout.setupWithViewPager(myGuanzhuVp);
        myGuanzhuVp.setOffscreenPageLimit(2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

