package com.bw.movie;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.app.Login;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GrxxActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.sView_user_mine)
    SimpleDraweeView sViewUserMine;
    @BindView(R.id.tv_name_user_mine)
    TextView tvNameUserMine;
    @BindView(R.id.tv_sex_user_mine)
    TextView tvSexUserMine;
    @BindView(R.id.tv_data_user_mine)
    TextView tvDataUserMine;
    @BindView(R.id.tv_email_user_mine)
    TextView tvEmailUserMine;
    private Login login;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_grxx;
    }

    @Override
    protected void initData() {
        super.initData();
        login = new Login();
        sViewUserMine.setImageURI(login.headPic);
        tvNameUserMine.setText(login.nickName);
        if (login.sex.equals("1")){
            tvSexUserMine.setText("男");
        }else if (login.sex.equals("2")){
            tvSexUserMine.setText("女");

        }
        else {
            tvSexUserMine.setText("请先登录");
        }
        tvDataUserMine.setText("12月9日");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
