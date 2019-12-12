package com.bw.movie.fragment;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:16:47
 *@Description:${DESCRIPTION}
 **/

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.R;
import com.bw.movie.presenter.IRegionPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Frag_cinema extends BaseFragment {

    @BindView(R.id.location)
    ImageView location;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.tab_cinema)
    TabLayout tabCinema;
    @BindView(R.id.viewpager_cinema)
    ViewPager viewpagerCinema;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        List<Fragment>cinemaList=new ArrayList<>();
        cinemaList.add(new Frag_tjyy());
        cinemaList.add(new Frag_tjyy());
        cinemaList.add(new Frag_qy());
        List<String> list=new ArrayList<>();
        list.add("推荐影院");
        list.add("附近影院");
        list.add("海淀区");
        viewpagerCinema.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return cinemaList.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        tabCinema.setupWithViewPager(viewpagerCinema);
    }
}
