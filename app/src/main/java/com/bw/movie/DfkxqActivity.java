package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bw.movie.app.Login;
import com.bw.movie.bean.DdxqBean;
import com.bw.movie.bean.GpjlBean;
import com.bw.movie.bean.ZfBean;
import com.bw.movie.contract.IGpjlContract;
import com.bw.movie.presenter.IGpjlPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *@describe(描述)：DfkxqActivity
 *@data（日期）: 2019/12/3
 *@time（时间）: 13:58
 *@author（作者）: 李泽楷
 **/

public class DfkxqActivity extends BaseActivity<IGpjlPresenter> implements IGpjlContract.IGpjlView {


    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.movie_name_seat)
    TextView movieNameSeat;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.position)
    TextView position;
    @BindView(R.id.home)
    TextView home;
    @BindView(R.id.count)
    TextView count;
    @BindView(R.id.seat)
    TextView seat;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.orderId)
    TextView orderId;
    @BindView(R.id.createtime)
    TextView createtime;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.line)
    LinearLayout line;
    @BindView(R.id.pay)
    Button pay;
    private String orderId1;

    @Override
    protected IGpjlPresenter providePresenter() {
        return new IGpjlPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_dfkxq;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        orderId1 = intent.getStringExtra("orderId");
        Login login=new Login();
        mPresenter.getDdxqPresenter(login.userId, login.sessionId, orderId1);
    }

    @Override
    public void onGpjlSuccess(GpjlBean bean) {

    }

    @Override
    public void onDdxqSuccess(DdxqBean bean) {
        if (bean.getMessage().equals("0000")){

        DdxqBean.ResultBean result = bean.getResult();
        name.setText(result.getMovieName());
        position.setText(result.getCinemaName());
        home.setText(result.getScreeningHall());
        count.setText(result.getAmount() + "张");
        seat.setText(result.getSeat());
        time.setText(result.getBeginTime() + "-" + result.getEndTime());
        orderId.setText(orderId1);
        Date date = new Date(result.getCreateTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        createtime.setText(simpleDateFormat.format(date));
        price.setText("￥" + result.getPrice());
        }else {
            Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onZfSuccess(ZfBean bean) {

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

    @OnClick({R.id.details_back, R.id.pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.details_back:
                finish();
                break;

        }
    }
}
