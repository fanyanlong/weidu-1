package com.bw.movie;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.service.DownloadIntentService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *@describe(描述)：GxActivity
 *@data（日期）: 2019/11/14
 *@time（时间）: 20:07
 *@author（作者）: 李泽楷
 **/

public class GxActivity extends BaseActivity {
    private Intent intent;
    private static final int DOWNLOADAPK_ID = 10;
    @BindView(R.id.btn_update)
    Button btnUpdate;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_gx;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_update)
    public void onClick() {
        if (isServiceRunning(DownloadIntentService.class.getName())) {
            Toast.makeText(GxActivity.this, "正在下载", Toast.LENGTH_SHORT).show();
            return;
        }
        String downloadUrl = "/media/movie.apk";
        intent = new Intent(GxActivity.this, DownloadIntentService.class);
        Bundle bundle = new Bundle();
        bundle.putString("download_url", downloadUrl);
        bundle.putInt("download_id", DOWNLOADAPK_ID);
        bundle.putString("download_file", downloadUrl.substring(downloadUrl.lastIndexOf('/') + 1));
        intent.putExtras(bundle);
        startService(intent);
    }




    //关闭服务 停止下载
    public void stopFinishSer() {

    }
    /**
     * 用来判断服务是否运行.
     *
     * @param className 判断的服务名字
     * @return true 在运行 false 不在运行
     */
    private boolean isServiceRunning(String className) {

        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) this
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager
                .getRunningServices(Integer.MAX_VALUE);
        if (!(serviceList.size() > 0)) {
            return false;
        }
        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }
}
