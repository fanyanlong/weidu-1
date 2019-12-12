package com.bw.movie;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.contract.ITimeContract;
import com.bw.movie.fragment.yyxiangqing.Fragment_yypq;
import com.bw.movie.presenter.ITimePresenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *@describe(描述)：YyDypqActivity
 *@data（日期）: 2019/12/3
 *@time（时间）: 13:57
 *@author（作者）: 李泽楷
 **/

public class YyDypqActivity extends BaseActivity<ITimePresenter> implements ITimeContract.ITimeView {


    private static final String TAG = "YyDypqActivity";
    @BindView(R.id.image_yypq)
    ImageView imageYypq;
    @BindView(R.id.tab_yypq)
    TabLayout tabYypq;
    @BindView(R.id.viewpager_yypq)
    ViewPager viewpagerYypq;
    private List<String> datas;

    @Override
    protected ITimePresenter providePresenter() {
        return new ITimePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_yy_dypq;
    }

    @Override
    protected void initView() {
        super.initView();
        Fresco.initialize(this);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getTimePresenter();

    }

    @Override
    public void onTimeSuccess(TimeBean bean) {
        Logger.i(TAG,bean.getMessage());
        datas = new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            datas.add(bean.getResult().get(i));
        }
        viewpagerYypq.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabYypq.setupWithViewPager(viewpagerYypq);
    }

    @Override
    public void onTimeFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.image_yypq)
    public void onClick() {
        finish();
    }
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        //带参的构造方法
        @Override
        public int getCount() {
            return datas.size();
        }

        //返回选项卡的文本 ，，，添加选项卡
        @Override
        public CharSequence getPageTitle(int position) {
            return datas.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            //创建fragment对象并返回
            //实例化Fragment
            Fragment_yypq fragment_yypq = new Fragment_yypq();
            return fragment_yypq;
        }
    }

}
