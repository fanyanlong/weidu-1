package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bw.movie.app.Login;
import com.bw.movie.bean.FkBean;
import com.bw.movie.contract.IFkContract;
import com.bw.movie.presenter.IFkPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FkActivity extends BaseActivity<IFkPresenter> implements IFkContract.IFkView {


    @BindView(R.id.title_fanhui)
    ImageView titleFanhui;
    @BindView(R.id.title_biaoti)
    TextView titleBiaoti;
    @BindView(R.id.dankui_edit)
    EditText dankuiEdit;
    @BindView(R.id.fankui_bt)
    Button fankuiBt;
    Login login=new Login();
    @Override
    protected IFkPresenter providePresenter() {
        return new IFkPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_fk;
    }

    @Override
    public void onFkSuccess(FkBean bean) {
        if (bean.getStatus().equals("0000")){
            startActivity(new Intent(FkActivity.this,FkcgActivity.class));
            finish();
        }else {
            Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFkFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.title_fanhui, R.id.fankui_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_fanhui:
                finish();
                break;
            case R.id.fankui_bt:
                String s = dankuiEdit.getText().toString();
                mPresenter.getFkPresenter(login.userId,login.sessionId,s);
                break;
        }
    }
}
