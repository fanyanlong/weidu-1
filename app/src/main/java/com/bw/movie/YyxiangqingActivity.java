package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bw.movie.app.Login;
import com.bw.movie.bean.GzyyBean;
import com.bw.movie.bean.QxgzyyBean;
import com.bw.movie.bean.YyxiangqingBean;
import com.bw.movie.contract.IYyxqContract;
import com.bw.movie.fragment.yyxiangqing.Fragment_yypj;
import com.bw.movie.fragment.yyxiangqing.Fragment_yyxq;
import com.bw.movie.presenter.IYyxqPresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：YyxiangqingActivity
 * @data（日期）: 2019/12/3
 * @time（时间）: 13:57
 * @author（作者）: 李泽楷
 **/

public class YyxiangqingActivity extends BaseActivity<IYyxqPresenter> implements IYyxqContract.IYyxqView {


    private static final String TAG = "YyxiangqingActivity1";
    @BindView(R.id.simp_yy_gh)
    SimpleDraweeView simpYyGh;
    @BindView(R.id.xiangqing_name)
    TextView xiangqing_name;
    @BindView(R.id.xiangqing_tab)
    TabLayout xiangqingTab;
    @BindView(R.id.xiangqing_vp)
    ViewPager xiangqingVp;
    @BindView(R.id.button_paiqi)
    Button buttonPaiqi;
    @BindView(R.id.checkbox_xin)
    CheckBox checkboxXin;
    private String id;
    private String cinemaId;
    Login login=new Login();
    @Override
    protected IYyxqPresenter providePresenter() {
        return new IYyxqPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_yyxiangqing;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Logger.i(TAG, id);
        mPresenter.getYyxqPresenter(id);
        List<String> list = new ArrayList<>();
        List<Fragment> list1 = new ArrayList<>();
        list.add("影院详情");
        list.add("影院评价");
        list1.add(new Fragment_yyxq());
        list1.add(new Fragment_yypj());
        xiangqingVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list1.get(position);
            }

            @Override
            public int getCount() {
                return list1.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        xiangqingTab.setupWithViewPager(xiangqingVp);
        checkboxXin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Logger.i(TAG+"3",cinemaId);
                    mPresenter.getGzyyPresenter(login.userId,login.sessionId,cinemaId);
                }else {
                    mPresenter.getQxgzyyPresenter(login.userId,login.sessionId,cinemaId);
                }
            }
        });
    }

    @Override
    public void onYyxqSuccess(YyxiangqingBean bean) {
        Logger.i(TAG, bean.getMessage());
        xiangqing_name.setText(bean.getResult().getName());
        cinemaId=bean.getResult().getId()+"";
        Logger.i(TAG+"3",cinemaId);
        Logger.i(TAG+"2",bean.getResult().getFollowCinema()+"");
        if (bean.getResult().getFollowCinema()==1){
            checkboxXin.setChecked(true);
        }else {
            checkboxXin.setChecked(false);
        }
    }

    @Override
    public void onGzyySuccess(GzyyBean bean) {
            if (bean.getStatus().equals("0000")){
                Toast.makeText(this, "关注成功", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
                return;
            }
    }

    @Override
    public void onQxgzyySuccess(QxgzyyBean bean) {
            if (bean.getStatus().equals("0000")){
                Toast.makeText(this, "取消关注", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
                return;
            }
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.simp_yy_gh, R.id.button_paiqi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simp_yy_gh:
                finish();
                break;
            case R.id.button_paiqi:
                Intent intent = new Intent(this, YyDypqActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;
        }
    }
}
