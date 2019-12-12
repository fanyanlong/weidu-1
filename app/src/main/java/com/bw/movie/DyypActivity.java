package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bw.movie.app.Login;
import com.bw.movie.bean.DyypBean;
import com.bw.movie.contract.IDyypContract;
import com.bw.movie.presenter.IDyypPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *@describe(描述)：DyypActivity
 *@data（日期）: 2019/12/3
 *@time（时间）: 13:58
 *@author（作者）: 李泽楷
 **/

public class DyypActivity extends BaseActivity<IDyypPresenter> implements IDyypContract.IDyypView {


    private static final String TAG = "DyypActivity";
    @BindView(R.id.img_yp_back)
    ImageView imgYpBack;
    @BindView(R.id.tv_yp_name)
    TextView tvYpName;
    @BindView(R.id.tv_pingfen)
    TextView tvPingfen;
    @BindView(R.id.rb_yp_pingfen)
    RatingBar rbYpPingfen;
    @BindView(R.id.et_yp_movie)
    EditText etYpMovie;
    @BindView(R.id.bt_yp_push)
    Button btYpPush;
    private int movieId;
    Login login = new Login();

    @Override
    protected IDyypPresenter providePresenter() {
        return new IDyypPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_dyyp;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        movieId = intent.getIntExtra("movieId", 0);
        String name = intent.getStringExtra("name");
        tvYpName.setText(name);
        rbYpPingfen.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tvPingfen.setText("我的评分("+v+")");
            }
        });
    }

    @Override
    public void onDyypSuccess(DyypBean bean) {
        if (bean.getStatus().equals("0000")){
            String message = bean.getMessage();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            if (bean.getStatus().contains("0000")) {
                setResult(222);
                finish();
            }
        }else {
            Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onDyypFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_yp_back, R.id.bt_yp_push})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_yp_back:
                finish();
                break;
            case R.id.bt_yp_push:
                break;
        }
    }

    @OnClick(R.id.bt_yp_push)
    public void onClick() {
        String trim = etYpMovie.getText().toString();
        float rating = rbYpPingfen.getRating();
        mPresenter.getDyypPresenter(login.userId, login.sessionId, movieId+"", trim, rating+"");
    }
}
