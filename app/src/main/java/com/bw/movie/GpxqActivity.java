package com.bw.movie;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bw.movie.app.App;
import com.bw.movie.app.Login;
import com.bw.movie.bean.DdxqBean;
import com.bw.movie.bean.GpjlBean;
import com.bw.movie.bean.ZfBean;
import com.bw.movie.contract.IGpjlContract;
import com.bw.movie.presenter.IGpjlPresenter;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *@describe(描述)：GpxqActivity
 *@data（日期）: 2019/12/3
 *@time（时间）: 13:57
 *@author（作者）: 李泽楷
 **/

public class GpxqActivity extends BaseActivity<IGpjlPresenter> implements IGpjlContract.IGpjlView {

    public static final String TAG = "GpxqActivity";
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
    @BindView(R.id.pay_btn)
    Button payBtn;
    private DdxqBean.ResultBean result;
    private String orderId1;
    Login login = new Login();
    private double price1;

    @Override
    protected IGpjlPresenter providePresenter() {
        return new IGpjlPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        orderId1 = intent.getStringExtra("orderId");
        mPresenter.getDdxqPresenter(login.userId, login.sessionId, orderId1);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_gpxq;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.details_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onGpjlSuccess(GpjlBean bean) {

    }

    @Override
    public void onDdxqSuccess(DdxqBean bean) {
        if (bean.getStatus().equals("0000")) {
            if (bean.getResult() == null) {
                finish();
                Toast.makeText(this, "空", Toast.LENGTH_SHORT).show();
                return;
            }
            result = bean.getResult();
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
            price.setText("￥" + result.getPrice()*result.getAmount());
            price1 = result.getPrice();
            payBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    initPopWindow(view);
                }
            });
        }else {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onZfSuccess(ZfBean bean) {
        if (bean.getStatus().equals("0000")){
            PayReq payReq = new PayReq();
            payReq.appId = bean.getAppId();
            payReq.nonceStr = bean.getNonceStr();
            payReq.partnerId = bean.getPartnerId();
            payReq.prepayId = bean.getPrepayId();
            payReq.sign = bean.getSign();
            payReq.timeStamp = bean.getTimeStamp();
            payReq.packageValue = bean.getPackageValue();
            payReq.extData = "app data";
            App.api.sendReq(payReq);
         payBtn.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }

    private void initPopWindow(View v1) {
        Logger.i(TAG, 123 + "");
        View inflate = View.inflate(this, R.layout.layout_zf, null);
        RadioGroup radioGroup = inflate.findViewById(R.id.radio_zx_zffs);
        RadioButton radioButton_wx = inflate.findViewById(R.id.radiobutt_wx);
        RadioButton radioButton_zfb = inflate.findViewById(R.id.radiobutt_wx);
        PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.showAsDropDown(v1, 50, -550);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobutt_wx:
                        payBtn.setText("微信支付" + String.format("%.2f", price1));
                        payBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Logger.i(TAG, "微信支付");
                                mPresenter.getZfPresenter(login.userId, login.sessionId, "1", orderId1);
                            }
                        });
                        popupWindow.dismiss();
                        break;
                    case R.id.radiobutt_zfb:
                        payBtn.setText("支付宝支付" + String.format("%.2f", price1));
                        payBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Logger.i(TAG, "支付宝支付");
                            }
                        });
                        popupWindow.dismiss();
                        break;
                }
            }
        });

    }
}
