package com.bw.movie;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.utils.NetUtil;
import com.bw.movie.fragment.Frag_cinema;
import com.bw.movie.fragment.Frag_movie;
import com.bw.movie.fragment.Frag_my;
import com.bw.movie.presenter.IUserPresenter;
import com.bw.movie.view.NoScrollViewPager;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：MainActivity
 * @data（日期）: 2019/11/11
 * @time（时间）: 16:03
 * @author（作者）: 李泽楷
 **/

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.viewpager_main)
    NoScrollViewPager viewpagerMain;
    @BindView(R.id.mevie_a)
    ImageView mevieA;
    @BindView(R.id.mevie_b)
    LinearLayout mevieB;
    @BindView(R.id.left)
    LinearLayout left;
    @BindView(R.id.cinema_a)
    ImageView cinemaA;
    @BindView(R.id.cinema_b)
    LinearLayout cinemaB;
    @BindView(R.id.middle)
    LinearLayout middle;
    @BindView(R.id.my_a)
    ImageView myA;
    @BindView(R.id.my_b)
    LinearLayout myB;
    @BindView(R.id.right)
    LinearLayout right;
    private FragmentManager manager = getSupportFragmentManager();

    private long firstTime;// 记录点击返回时第一次的时间毫秒值

    @Override
    protected IUserPresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        Fresco.initialize(this);

    }

    @Override
    protected void initData() {
        super.initData();
        boolean b = NetUtil.hasNetwork(this);
        if (b){
            Toast.makeText(this, "有网", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "没网", Toast.LENGTH_SHORT).show();
        }
        List<Fragment> fragList = new ArrayList<>();
        fragList.add(new Frag_movie());
        fragList.add(new Frag_cinema());
        fragList.add(new Frag_my());

        viewpagerMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragList.get(position);
            }

            @Override
            public int getCount() {
                return fragList.size();
            }
        });
        viewpagerMain.setOffscreenPageLimit(3);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.left, R.id.middle, R.id.right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left:
                mevieA.setVisibility(View.GONE);
                mevieB.setVisibility(View.VISIBLE);
                cinemaA.setVisibility(View.VISIBLE);
                cinemaB.setVisibility(View.GONE);
                myA.setVisibility(View.VISIBLE);
                myB.setVisibility(View.GONE);
                viewpagerMain.setCurrentItem(0);
                break;
            case R.id.middle:
                mevieA.setVisibility(View.VISIBLE);
                mevieB.setVisibility(View.GONE);
                cinemaA.setVisibility(View.GONE);
                cinemaB.setVisibility(View.VISIBLE);
                myA.setVisibility(View.VISIBLE);
                myB.setVisibility(View.GONE);
                viewpagerMain.setCurrentItem(1);

                break;
            case R.id.right:
                mevieA.setVisibility(View.VISIBLE);
                mevieB.setVisibility(View.GONE);
                cinemaA.setVisibility(View.VISIBLE);
                cinemaB.setVisibility(View.GONE);
                myA.setVisibility(View.GONE);
                myB.setVisibility(View.VISIBLE);
                viewpagerMain.setCurrentItem(2);

                break;
        }
    }
    /**
     * 重写该方法，判断用户按下返回按键的时候，执行退出应用方法
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){// 点击了返回按键
            if(manager.getBackStackEntryCount() != 0){
                manager.popBackStack();
            }else {
                exitApp(2000);// 退出应用
            }
            return true;// 返回true，防止该事件继续向下传播
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 退出应用
     * @param timeInterval 设置第二次点击退出的时间间隔
     */
    private void exitApp(long timeInterval) {
        // 第一次肯定会进入到if判断里面，然后把firstTime重新赋值当前的系统时间
        // 然后点击第二次的时候，当点击间隔时间小于2s，那么退出应用；反之不退出应用
        if(System.currentTimeMillis() - firstTime >= timeInterval){
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = System.currentTimeMillis();
        }else {
            finish();// 销毁当前activity
            System.exit(0);// 完全退出应用
        }
    }

}
