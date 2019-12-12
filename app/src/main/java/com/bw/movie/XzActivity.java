package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bumptech.glide.Glide;
import com.bw.movie.adapter.xiangqing.DateYYAdapter;
import com.bw.movie.adapter.xiangqing.MovieYYAdapter;
import com.bw.movie.adapter.xiangqing.PriceYYAdapter;
import com.bw.movie.adapter.xiangqing.RecyclerQuAdapter;
import com.bw.movie.adapter.xiangqing.ZhouPaiqiAdapter;
import com.bw.movie.app.Login;
import com.bw.movie.bean.IdTimeYingYuanBean;
import com.bw.movie.bean.JgcxBean;
import com.bw.movie.bean.QyBean;
import com.bw.movie.bean.QycxBean;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.bean.XiangqingBean;
import com.bw.movie.contract.IXzContract;
import com.bw.movie.presenter.IXzPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * @describe(描述)：XzActivity
 * @data（日期）: 2019/12/5
 * @time（时间）: 17:25
 * @author（作者）: 李泽楷
 **/

public class XzActivity extends BaseActivity<IXzPresenter> implements IXzContract.IXzView {


    @BindView(R.id.xuanzuo_fanhui)
    SimpleDraweeView xuanzuoFanhui;
    @BindView(R.id.imgseactseat)
    JCVideoPlayerStandard imgseactseat;
    @BindView(R.id.rela)
    RelativeLayout rela;
    @BindView(R.id.xuan_name)
    TextView xuanName;
    @BindView(R.id.xuanzuo_time)
    TextView xuanzuoTime;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.xuanzuo_fen)
    TextView xuanzuoFen;
    @BindView(R.id.linear2)
    LinearLayout linear2;
    @BindView(R.id.xuanzuo_daoyan)
    TextView xuanzuoDaoyan;
    @BindView(R.id.xuanzuo_quyu)
    TextView xuanzuoQuyu;
    @BindView(R.id.xuanzuo_shijian)
    TextView xuanzuoShijian;
    @BindView(R.id.xuanzuo_price)
    RadioButton xuanzuoPrice;
    @BindView(R.id.img_seatsesrach)
    SimpleDraweeView imgSeatsesrach;
    @BindView(R.id.xuanzuo_rlv)
    RecyclerView xuanzuoRlv;
    Login login = new Login();
    private String movieId;
    public static final String TAG = "XzActivity";

    @Override
    protected IXzPresenter providePresenter() {
        return new IXzPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_xz;
    }

    @Override
    protected void initData() {
        super.initData();

        Intent intent = getIntent();
        movieId = intent.getStringExtra("mis");
        Map<String, Object> map = new HashMap<>();
        map.put("userId", login.userId);
        map.put("sessionId", login.sessionId);
        Logger.i(TAG, "initData1: " + movieId);
        mPresenter.getXiangqingPresenter(map, movieId);
        mPresenter.getJgcxPresenter(movieId,"1","5");
    }

    @Override
    public void onIdTimeYingSuccess(IdTimeYingYuanBean bean) {
        if (bean.getStatus().equals("0000")) {
            List<IdTimeYingYuanBean.ResultBean> result = bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(XzActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            xuanzuoRlv.setLayoutManager(linearLayoutManager);
            DateYYAdapter dateYYAdapter = new DateYYAdapter(result, XzActivity.this);
            dateYYAdapter.setItemClick(new DateYYAdapter.ItemClick() {
                @Override
                public void click(int cinemaId) {
                    Intent intent = new Intent(XzActivity.this, XuanzuoActivity.class);
                    intent.putExtra("id", cinemaId + "");
                    intent.putExtra("movieId", movieId);
                    startActivity(intent);
                }
            });
            xuanzuoRlv.setAdapter(dateYYAdapter);
        }
    }

    @Override
    public void onQySuccess(QyBean bean) {
        if (bean.getStatus().equals("0000")) {
            List<QyBean.ResultBean> result = bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(XzActivity.this);
            RecyclerQuAdapter recyclerQuAdapter = new RecyclerQuAdapter(result, XzActivity.this);
            xuanzuoRlv.setLayoutManager(linearLayoutManager);
            xuanzuoRlv.setAdapter(recyclerQuAdapter);
            recyclerQuAdapter.setGetOnClick(new RecyclerQuAdapter.getOnClick() {
                @Override
                public void getClick(int i,String quyu) {
                    //  mPresenter.getRegionPresenter(i+"");
                    xuanzuoQuyu.setText(quyu);
                    Logger.d(TAG, "getClick: " + i);
                    mPresenter.getQycxPresenter(movieId, i + "", "1", "5");
                }
            });
        } else {
            Toast.makeText(XzActivity.this, "" + bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onJgcxSuccess(JgcxBean bean) {
        if (bean.getStatus().equals("0000")){
            List<JgcxBean.ResultBean> result = bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(XzActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            xuanzuoRlv.setLayoutManager(linearLayoutManager);
            PriceYYAdapter priceYYAdapter = new PriceYYAdapter(result, XzActivity.this);
            xuanzuoRlv.setAdapter(priceYYAdapter);
            priceYYAdapter.setItemClick(new PriceYYAdapter.ItemClick() {
                @Override
                public void click(int cinemaId) {
                    Intent intent = new Intent(XzActivity.this,XuanzuoActivity.class);
                    intent.putExtra("id",cinemaId+"");
                    intent.putExtra("movieId",movieId);
                    startActivity(intent);
                }
            });
        }else {
            Toast.makeText(this, ""+bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onQycxSuccess(QycxBean bean) {
        if (bean.getMessage().equals("查询成功")) {
            List<QycxBean.ResultBean> result = bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(XzActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            xuanzuoRlv.setLayoutManager(linearLayoutManager);
            MovieYYAdapter movieYYAdapter = new MovieYYAdapter(result, XzActivity.this);
            movieYYAdapter.setItemClick(new MovieYYAdapter.ItemClick() {
                @Override
                public void click(int cinemaId) {
                    Intent intent = new Intent(XzActivity.this, XuanzuoActivity.class);
                    intent.putExtra("id", cinemaId + "");
                    intent.putExtra("movieId", movieId);
                    startActivity(intent);
                }
            });
            xuanzuoRlv.setAdapter(movieYYAdapter);
        } else {
            Toast.makeText(this, "" + bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onXiangqingSuccess(XiangqingBean bean) {
        Logger.i(TAG, "onXiangqingSuccess: "+bean.getMessage());
        if (bean.getStatus().equals("0000")) {
            XiangqingBean.ResultBean result = bean.getResult();
            Logger.i(TAG, "onXiangqingSuccess: "+result.getShortFilmList().get(0).getVideoUrl());

            if (result != null) {
                xuanName.setText(result.getName());
                xuanzuoTime.setText(result.getDuration());
                xuanzuoFen.setText(result.getScore() + "分");
                //导演
                xuanzuoDaoyan.setText(result.getMovieDirector().get(0).getName());
                //视频
               // imgseactseat.setUp(result.getShortFilmList().get(0).getVideoUrl(), null);
                //Glide.with(this).load(result.getShortFilmList().get(0).getImageUrl()).into(imgseactseat.ivThumb);
                Logger.i(TAG, "onXiangqingSuccess: "+result.getShortFilmList().get(0).getVideoUrl());
                imgseactseat.setUp(result.getShortFilmList().get(0).getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL, "");
                Glide.with(this).load(result.getShortFilmList().get(0).getVideoUrl()).into(imgseactseat.thumbImageView);
            }
        } else {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onTimeSuccess(TimeBean bean) {
        List<String> result = bean.getResult();
        String s = result.get(0);
        xuanzuoShijian.setText("请选择日期");
        ZhouPaiqiAdapter zhouPaiqiAdapter = new ZhouPaiqiAdapter(XzActivity.this, bean);
        xuanzuoRlv.setAdapter(zhouPaiqiAdapter);
        zhouPaiqiAdapter.setOnItemClicks(new ZhouPaiqiAdapter.onItemClicks() {
            @Override
            public void onChangeData(String p) {
                xuanzuoShijian.setText(p);
                mPresenter.getIdTimeYingPresenter(movieId, p + "", "1", "5");
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(XzActivity.this);
        xuanzuoRlv.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onFailure(Throwable e) {
        Logger.i(TAG, "onFailure: "+e.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.xuanzuo_fanhui, R.id.xuanzuo_quyu, R.id.xuanzuo_shijian, R.id.img_seatsesrach})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.xuanzuo_fanhui:
                finish();
                break;
            case R.id.xuanzuo_quyu:
                mPresenter.getQyPresenter();
                break;
            case R.id.xuanzuo_shijian:
                mPresenter.getTimePresenter();
                break;
            case R.id.img_seatsesrach:
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayerStandard.releaseAllVideos();
    }

    @OnClick(R.id.xuanzuo_price)
    public void onClick() {
        mPresenter.getJgcxPresenter(movieId,"1","9");
    }
}
