package com.bw.movie.fragment;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:16:47
 *@Description:${DESCRIPTION}
 **/

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bw.movie.DyssActivity;
import com.bw.movie.R;
import com.bw.movie.adapter.RecyclerMovieAdapter;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.ShowBean;
import com.bw.movie.bean.ShowingBean;
import com.bw.movie.bean.XbannerBean;
import com.bw.movie.contract.IMovieContract;
import com.bw.movie.presenter.IMoviePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class Frag_movie extends BaseFragment<IMoviePresenter> implements IMovieContract.IMovieView {
    private static final String TAG = "Frag_movie";
    @BindView(R.id.shouye_smart)
    SmartRefreshLayout shouyeSmart;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private int GPS_REQUEST_CODE = 10;
    public List<Object> list = new ArrayList<>();
    @BindView(R.id.location)
    ImageView location;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.text_dw)
    TextView textDw;
    @BindView(R.id.xrecycler_movie)
    RecyclerView xrecyclerMovie;
    int page = 0;
    private RecyclerMovieAdapter adapter;

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_movie;
    }


    @Override
    protected IMoviePresenter providePresenter() {
        return new IMoviePresenter();
    }

    @Override
    protected void initView() {
        super.initView();

        mPresenter.getXbannerPresenter();

    }


    @Override
    protected void initData() {
        super.initData();
        shouyeSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 0;
                list.clear();
                mPresenter.getXbannerPresenter();
                adapter.notifyDataSetChanged();
                shouyeSmart.finishRefresh(1000/*,false*/);
            }
        });



       /* xrecyclerMovie.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 0;
                list.clear();
                mPresenter.getXbannerPresenter();
                adapter.notifyDataSetChanged();
                xrecyclerMovie.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                list.clear();
                mPresenter.getXbannerPresenter();
                adapter.notifyDataSetChanged();
                xrecyclerMovie.loadMoreComplete();
            }
        });*/
    }


    @Override
    public void onXbannerSuccess(XbannerBean bean) {
        Log.i(TAG, "onXbannerSuccess: " + bean.getMessage());
        list.add(bean);
        mPresenter.getShowingrPresenter(page % 2 + 1 + "", "5");
        int i = page % 2 + 1;
        Logger.i(TAG, "" + i);
      /*   List<String>xbannerList=new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            xbannerList.add(bean.getResult().get(i).getImageUrl());
        }
       xbanderMovie.setBannerData(R.layout.image_fresco, new AbstractList<SimpleBannerInfo>() {
            @Override
            public SimpleBannerInfo get(int i) {
                return null;
            }

            @Override
            public int size() {
                return xbannerList.size();
            }
        });
        xbanderMovie.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                SimpleDraweeView simpleDraweeView=view.findViewById(R.id.my_image_view);
                Uri uri=Uri.parse(xbannerList.get(position));
//                Log.i(TAG, "loadBanner: "+xbannerList.get(position));
                simpleDraweeView.setImageURI(uri);
            }
        });*/
    }

    @Override
    public void onShowingSuccess(ShowingBean bean) {
        if (bean.getStatus().equals("0000")) {
            if (bean.getMessage().equals("无数据")) {
                page = 1;
            }

            Log.i(TAG, "onShowingSuccess: " + bean.getMessage());
            list.add(bean);
            Map<String, String> map = new HashMap<>();
            map.put("userId", "13798");
            map.put("sessionId", "157356295970613798");
            mPresenter.getShowPresenter(page % 2 + 1 + "", "5", map);
        }

    }

      /*  List<ShowingBean.ResultBean>showingList=new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
                    showingList.add(bean.getResult().get(i));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        RecyclorShowingAdapter recyclorShowingAdapter=new RecyclorShowingAdapter(showingList,getActivity());
        recyclerShowing.setLayoutManager(linearLayoutManager);
        recyclerShowing.setAdapter(recyclorShowingAdapter);*/


    @Override
    public void onShowSuccess(ShowBean bean) {
        if (bean.getMessage().equals("无数据")) {
            page = 1;
        }
        Log.i(TAG, "onShowSuccess: " + bean.getMessage());
        list.add(bean);

        mPresenter.getHotPresenter(page % 2 + 1 + "", "5");
     /*   List<ShowBean.ResultBean>showList=new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            showList.add(bean.getResult().get(i));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        RecyclorShowAdapter recyclorShowingAdapter=new RecyclorShowAdapter(showList,getActivity());
        recyclerShow.setLayoutManager(linearLayoutManager);
        recyclerShow.setAdapter(recyclorShowingAdapter);*/
    }

    @Override
    public void onHotSuccess(HotBean bean) {
        if (bean.getMessage().equals("无数据")) {
            page = 1;
        }
        Log.i(TAG, "onHotSuccess: " + bean.getMessage());
        list.add(bean);
        adapter = new RecyclerMovieAdapter(list, getContext());
        xrecyclerMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        xrecyclerMovie.setAdapter(adapter);
    /*    List<HotBean.ResultBean>hotList=new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            hotList.add(bean.getResult().get(i));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        RecyclorHotAdapter recyclorHotAdapter=new RecyclorHotAdapter(hotList,getActivity());
        recyclerHot.setLayoutManager(linearLayoutManager);
        recyclerHot.setAdapter(recyclorHotAdapter);*/
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @OnClick({R.id.location, R.id.search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.location:
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
                    //开启定位权限,200是标识码
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
                } else {
                    MyLocation(getActivity());//开始定位
                }
                break;
            case R.id.search:
                getActivity().startActivity(new Intent(getActivity(), DyssActivity.class));
                break;
        }
    }

    /*
     * 定位 判断是否开启权限
     * 有 执行
     * 无 弹框提示进入设置开启权限
     * */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 200://刚才的识别码
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {//用户同意权限,执行我们的操作
                    MyLocation(getActivity());//开始定位
                } else {//用户拒绝之后,当然我们也可以弹出一个窗口,直接跳转到系统设置页面
                    Toast.makeText(getActivity(), "未开启定位权限,请手动到设置去开启权限", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    /*
     * 定位成功回调信息，设置相关消息
     * */
    public void MyLocation(Context context) {
        mlocationClient = new AMapLocationClient(context);
        mLocationOption = new AMapLocationClientOption();
        mlocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                try {
                    if (amapLocation != null) {
                        if (amapLocation.getErrorCode() == 0) {
                            //定位成功回调信息，设置相关消息

                            //获取当前定位结果来源，如网络定位结果，详见定位类型表
                            Log.i("定位类型", amapLocation.getLocationType() + "");
                            Log.i("获取纬度", amapLocation.getLatitude() + "");
                            Log.i("获取经度", amapLocation.getLongitude() + "");
                            Log.i("获取精度信息", amapLocation.getAccuracy() + "");
                            //如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                            Log.i("地址", amapLocation.getAddress());
                            Log.i("国家信息", amapLocation.getCountry());
                            Log.i("省信息", amapLocation.getProvince());
                            Log.i("城市信息", amapLocation.getCity());
                            Log.i("城区信息", amapLocation.getDistrict());
                            Log.i("街道信息", amapLocation.getStreet());
                            Log.i("街道门牌号信息", amapLocation.getStreetNum());
                            Log.i("城市编码", amapLocation.getCityCode());
                            Log.i("地区编码", amapLocation.getAdCode());
                            Log.i("获取当前定位点的AOI信息", amapLocation.getAoiName());
                            Log.i("获取当前室内定位的建筑物Id", amapLocation.getBuildingId());
                            Log.i("获取当前室内定位的楼层", amapLocation.getFloor());
                            Log.i("获取GPS的当前状态", amapLocation.getGpsAccuracyStatus() + "");
                            //获取定位时间
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date(amapLocation.getTime());
                            Log.i("获取定位时间", df.format(date));
                            textDw.setText(amapLocation.getAoiName());
                            // 停止定位
                            mlocationClient.stopLocation();
                        } else {
                            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                            Log.e("AmapError", "location Error, ErrCode:"
                                    + amapLocation.getErrorCode() + ", errInfo:"
                                    + amapLocation.getErrorInfo());
                            Toast.makeText(getActivity(), "没有权限，请打开权限...", Toast.LENGTH_SHORT).show();
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("定位服务未开启")
                                    .setMessage("请在系统设置中开启定位服务\n" +
                                            "以便为您提供更好的服务")
                                    .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                            startActivityForResult(intent, GPS_REQUEST_CODE);
                                        }
                                    })
                                    .show();
                        }
                    }
                } catch (Exception e) {
                }

            }
        });
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setInterval(5000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        //启动定位
        mlocationClient.startLocation();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);

        } else {
            MyLocation(getActivity());//开始定位
            //Toast.makeText(getActivity(),"已开启定位权限",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // 停止定位
        if (null != mlocationClient) {
            mlocationClient.stopLocation();
        }

    }

    //内存泄露和定位
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != mlocationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            mlocationClient.onDestroy();
            mlocationClient = null;
        }
    }
}
