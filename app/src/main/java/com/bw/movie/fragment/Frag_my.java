package com.bw.movie.fragment;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:16:47
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.CxplActivity;
import com.bw.movie.EmailMessageActivity;
import com.bw.movie.FkActivity;
import com.bw.movie.GpjlActivity;
import com.bw.movie.GrxxActivity;
import com.bw.movie.GxActivity;
import com.bw.movie.LoginActivity;
import com.bw.movie.R;
import com.bw.movie.WdgzActivity;
import com.bw.movie.app.Login;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.OnClick;

public class Frag_my extends BaseFragment {
    @BindView(R.id.mine_)
    TextView mine;
    @BindView(R.id.mine_xinxi)
    ImageView mineXinxi;
    @BindView(R.id.mine_img)
    SimpleDraweeView mineImg;
    @BindView(R.id.mine_name_)
    TextView mineName;
    @BindView(R.id.mine_Setting)
    RelativeLayout mineSetting;
    @BindView(R.id.relat_wdgz)
    RelativeLayout relatWdgz;
    @BindView(R.id.relat_wdyy)
    RelativeLayout relatWdyy;
    @BindView(R.id.relat_gpjl)
    RelativeLayout relatGpjl;
    @BindView(R.id.relat_kgddy)
    RelativeLayout relatKgddy;
    @BindView(R.id.relat_wdpl)
    RelativeLayout relatWdpl;
    @BindView(R.id.relat_yjfk)
    RelativeLayout relatYjfk;
    @BindView(R.id.mine_name)
    RelativeLayout mineName2;
    private Login login;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        super.initView();
        login = new Login();
        mineImg.setImageURI(login.headPic);
        mineName.setText(login.nickName);
        mineImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        mineXinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), EmailMessageActivity.class));
            }
        });
       /* mineImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });*/
    }

    @Override
    protected void initData() {
        super.initData();
        mineSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), GxActivity.class));
            }
        });
    }

    @OnClick({R.id.relat_wdgz, R.id.relat_wdyy, R.id.relat_gpjl, R.id.relat_kgddy, R.id.relat_wdpl, R.id.relat_yjfk,R.id.mine_name})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.relat_wdgz:
                startActivity(new Intent(getActivity(), WdgzActivity.class));
                break;
            case R.id.relat_wdyy:
                break;
            case R.id.relat_gpjl:
                startActivity(new Intent(getActivity(), GpjlActivity.class));
                break;
            case R.id.relat_kgddy:
                break;
            case R.id.relat_wdpl:
                startActivity(new Intent(getActivity(), CxplActivity.class));
                break;
            case R.id.relat_yjfk:
                startActivity(new Intent(getActivity(), FkActivity.class));
                break;
            case R.id.mine_name:
                startActivity(new Intent(getActivity(), GrxxActivity.class));
                break;
        }
    }
}
