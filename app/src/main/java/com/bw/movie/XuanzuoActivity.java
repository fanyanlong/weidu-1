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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bumptech.glide.Glide;
import com.bw.movie.adapter.xiangqing.RecyclerDypqAdapter;
import com.bw.movie.adapter.xiangqing.RecyclerXunZuoAdapter;
import com.bw.movie.app.App;
import com.bw.movie.app.Login;
import com.bw.movie.bean.DypqBean;
import com.bw.movie.bean.XdBean;
import com.bw.movie.bean.XuanZuoBean;
import com.bw.movie.bean.XuanZuoEventBus;
import com.bw.movie.bean.ZfBean;
import com.bw.movie.contract.IXuanZuoContract;
import com.bw.movie.md5.MD5Util;
import com.bw.movie.presenter.IXuanZuoPresenter;
import com.tencent.mm.opensdk.modelpay.PayReq;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * @describe(描述)：XuanzuoActivity
 * @data（日期）: 2019/11/21
 * @time（时间）: 10:39
 * @author（作者）: 李泽楷
 **/

public class XuanzuoActivity extends BaseActivity<IXuanZuoPresenter> implements IXuanZuoContract.IXuanZuoView {


    private static final String TAG = "XuanzuoActivity1";
    @BindView(R.id.text_xz_name)
    TextView textXzName;
    @BindView(R.id.jcvideoplayer_xuanzuo)
    JCVideoPlayerStandard jcvideoplayerXuanzuo;
    @BindView(R.id.image_xz_fh)
    ImageView imageXzFh;
    @BindView(R.id.recycler_xz)
    RecyclerView recyclerXz;
    @BindView(R.id.recycler_dypq)
    RecyclerView recyclerDypq;
    @BindView(R.id.butt_xuanzuo_price)
    Button buttXuanzuoPrice;
    @BindView(R.id.radiobutt_wx)
    RadioButton radiobuttWx;
    @BindView(R.id.radiobutt_zfb)
    RadioButton radiobuttZfb;
    @BindView(R.id.radio_zx_zffs)
    RadioGroup radioZxZffs;
    @BindView(R.id.relat_xz_fk)
    RelativeLayout relatXzFk;
    private String cinemaId;
    private String movieId;
    private double Fare;
    private int scheduleId;
    private StringBuffer buffer;
    private double v;
    private String orderId;
    private int hallId1;
    Login login=new Login();

    @Override
    protected IXuanZuoPresenter providePresenter() {
        return new IXuanZuoPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_xuanzuo;
    }

    @Override
    protected void initView() {
        super.initView();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        cinemaId = intent.getStringExtra("id");
        Logger.i(TAG,"initData"+ cinemaId);
        mPresenter.getDypqPresenter(movieId, cinemaId);
        Logger.i(TAG, movieId + "  " + cinemaId);

    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onEvent(XuanZuoEventBus evBean) {
        String name = evBean.getName();
        String yugao = evBean.getYugao();
        movieId = evBean.getMovieId();
        textXzName.setText(name);
        Logger.i(TAG, name);
        Logger.i(TAG, yugao);
        jcvideoplayerXuanzuo.setUp(yugao,  JCVideoPlayer.SCREEN_LAYOUT_NORMAL, "");
        Glide.with(this).load(yugao).into(jcvideoplayerXuanzuo.thumbImageView);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onXuanZuoSuccess(XuanZuoBean bean) {
        buttXuanzuoPrice.setVisibility(View.GONE);
        relatXzFk.setVisibility(View.GONE);
        String message = bean.getMessage();
        Logger.i(TAG, "onXuanZuoSuccess" + message);
        List<XuanZuoBean.ResultBean> list = new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            list.add(bean.getResult().get(i));
        }
        RecyclerXunZuoAdapter adapter = new RecyclerXunZuoAdapter(list, XuanzuoActivity.this);
        recyclerXz.setLayoutManager(new GridLayoutManager(XuanzuoActivity.this, 7));
        recyclerXz.setAdapter(adapter);
        buffer = new StringBuffer();
        adapter.getoncheck(new RecyclerXunZuoAdapter.onCheck() {
            @Override
            public void setCheck() {
                int count = 0;
                for (int i = 0; i < bean.getResult().size(); i++) {
                    if (bean.getResult().get(i).isCheck()) {
                        count++;
                    }
                }
                if (count != 0) {
                    buttXuanzuoPrice.setVisibility(View.VISIBLE);
                    v = Fare * count;
                    buttXuanzuoPrice.setText("￥" + String.format("%.2f", v));
                }
                if (count == 0) {
                    buttXuanzuoPrice.setVisibility(View.GONE);

                }
            }
        });
        adapter.getBoolean(new RecyclerXunZuoAdapter.onBoolean() {
            @Override
            public void setBoolean(boolean b, String seat) {
                if (b) {
                    Logger.i(TAG, "setBoolean" + "123   " + seat);
                    buffer.append(seat + ",");
                } else {
                    Logger.i(TAG, "setBoolean" + "321   " + seat);
                    int i = buffer.indexOf(seat);
                    Logger.i(TAG, i + "");
                    String s = buffer.toString();
                    Logger.i(TAG, s);
                    buffer.delete(i, i + 4);
                    String s1 = buffer.toString();
                    Logger.i(TAG, s1);
                }
            }
        });
        buttXuanzuoPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String substring = buffer.substring(0, buffer.length() - 1);
                String sign = null;

                sign = login.userId + scheduleId + "movie";
                String s = MD5Util.MD5(login.userId + scheduleId + "movie");
                Logger.i(TAG, s);
                mPresenter.getXdPresenter(login.userId, login.sessionId, scheduleId + "", substring, s);
                initPopWindow(view);
            }
        });
    }

    @Override
    public void onDypqSuccess(DypqBean bean) {
        Logger.i(TAG, "onDypqSuccess" + bean.getMessage());
        List<DypqBean.ResultBean> list = new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            list.add(bean.getResult().get(i));
        }
        hallId1=bean.getResult().get(0).getHallId();
        Fare = bean.getResult().get(0).getFare();
        scheduleId = bean.getResult().get(0).getId();
        mPresenter.getXuanZuoPresenter(bean.getResult().get(0).getHallId() + "");
        RecyclerDypqAdapter adapter = new RecyclerDypqAdapter(list, XuanzuoActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(XuanzuoActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerDypq.setLayoutManager(linearLayoutManager);
        recyclerDypq.setAdapter(adapter);
        adapter.getClick(new RecyclerDypqAdapter.onClick() {
            @Override
            public void setClick(int id, int hallId, double fare) {
                mPresenter.getXuanZuoPresenter(hallId + "");
                hallId1=hallId;
                Fare = fare;
                scheduleId = id;

            }
        });
    }

    @Override
    public void onXdSuccess(XdBean bean) {
        if (bean.getMessage().equals("下单成功")){
            orderId = bean.getOrderId();
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
            mPresenter.getXuanZuoPresenter(hallId1 + "");
            int length = buffer.length();
            buffer.delete(0,length);
        }else {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }


    @OnClick({R.id.image_xz_fh, R.id.butt_xuanzuo_price})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_xz_fh:
                finish();
                break;

        }

    }

    private void initPopWindow(View v1) {
        Logger.i(TAG,123+"");
        View inflate = View.inflate(this, R.layout.layout_zf, null);
        RadioGroup radioGroup=inflate.findViewById(R.id.radio_zx_zffs);
        RadioButton radioButton_wx=inflate.findViewById(R.id.radiobutt_wx);
        RadioButton radioButton_zfb=inflate.findViewById(R.id.radiobutt_wx);
        PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.showAsDropDown(v1,50,-550);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radiobutt_wx:
                        buttXuanzuoPrice.setText("微信支付"+String.format("%.2f", v));
                        buttXuanzuoPrice.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Logger.i(TAG,"微信支付");
                                mPresenter.getZfPresenter(login.userId,login.sessionId,"1",orderId);
                                buttXuanzuoPrice.setVisibility(View.VISIBLE);
                            }
                        });
                        popupWindow.dismiss();
                        break;
                    case R.id.radiobutt_zfb:
                        buttXuanzuoPrice.setText("支付宝支付"+String.format("%.2f", v));
                        buttXuanzuoPrice.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Logger.i(TAG,"支付宝支付");
                            }
                        });
                        popupWindow.dismiss();

                        break;
                }
            }
        });

    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayerStandard.releaseAllVideos();
    }
}
/* String substring = buffer.substring(0, buffer.length() - 1);
                String sign = null;
                sign = App.userId + scheduleId + "movie";
                String s = MD5Util.MD5(App.userId + scheduleId + "movie");
                Logger.i(TAG, s);
                mPresenter.getXdPresenter(App.userId, App.sessionId, scheduleId + "", substring, s);*/