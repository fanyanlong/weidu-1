package com.bw.movie;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.MovieIdEventBus;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.contract.ITimeContract;
import com.bw.movie.fragment.Frag_gp_time;
import com.bw.movie.presenter.ITimePresenter;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 *@describe(描述)：GouPiaoYingYuanActivity
 *@data（日期）: 2019/11/21
 *@time（时间）: 10:40
 *@author（作者）: 李泽楷
 **/

public class GouPiaoYingYuanActivity extends BaseActivity<ITimePresenter> implements ITimeContract.ITimeView {


    private static final String TAG = "GouPiaoYingYuanActivity";
    @BindView(R.id.tab_gy_time)
    TabLayout tabGyTime;
    @BindView(R.id.viewpager_timeying)
    ViewPager viewpagerTimeying;
    private String movieId;
    private List<String> datas=new ArrayList<>();
    private List<String> result;


    @Override
    protected int provideLayoutId() {
        return R.layout.activity_gou_piao_ying_yuan;
    }

    @Override
    protected void initView() {
        super.initView();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)//true
    public void onMovieIdEventBus(MovieIdEventBus movieIdEventBus) {
        movieId = movieIdEventBus.getMovieId();
    }

    @Override
    protected void initData() {
        super.initData();
        SimpleDateFormat df = new SimpleDateFormat("MM-dd");//设置日期格式
        String format = df.format(new Date());
        String[] split = format.split("-");
        Integer integer= new Integer(split[1]);
        List<Integer> list= new ArrayList<>();
        datas.add(split[0]+"-"+ integer);
        for (int i = 0; i < 5; i++) {
            datas.add(split[0]+"-"+ ++integer);
        }

        mPresenter.getTimePresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected ITimePresenter providePresenter() {
        return new ITimePresenter();
    }

    @Override
    public void onTimeSuccess(TimeBean bean) {
        result = bean.getResult();
        viewpagerTimeying.setAdapter(new MyAdapter(getSupportFragmentManager()));
        //进行关联
        tabGyTime.setupWithViewPager(viewpagerTimeying);
        viewpagerTimeying.setOffscreenPageLimit(7);
    }

    @Override
    public void onTimeFailure(Throwable e) {

    }


    class MyAdapter extends FragmentPagerAdapter {
            public MyAdapter(FragmentManager fm) {
                super(fm);
            }

            //带参的构造方法
            @Override
            public int getCount() {
                return result.size();
            }

            //返回选项卡的文本 ，，，添加选项卡
            @Override
            public CharSequence getPageTitle(int position) {
                return result.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                //创建fragment对象并返回
                Bundle bundle = new Bundle();
                bundle.putString("time", result.get(position));
                //实例化Fragment
              /*  AllFragment allFragment = new AllFragment();
                allFragment.setArguments(bundle);*/
                Frag_gp_time frag_gp_time = new Frag_gp_time();
                frag_gp_time.setArguments(bundle);
                return frag_gp_time;
            }
        }


}
