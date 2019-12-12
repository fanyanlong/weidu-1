package com.bw.movie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bw.movie.app.App;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.WxLogBean;
import com.bw.movie.contract.IUserContract;
import com.bw.movie.md5.EncryptUtil;
import com.bw.movie.presenter.IUserPresenter;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：LoginActivity
 * @data（日期）: 2019/11/12
 * @time（时间）: 8:45
 * @author（作者）: 李泽楷
 **/

public class LoginActivity extends BaseActivity<IUserPresenter> implements IUserContract.IUserlView {


    private static final String TAG ="LoginActivity" ;
    @BindView(R.id.edit_login_email)
    EditText editLoginEmail;
    @BindView(R.id.edit_login_pwd)
    EditText editLoginPwd;
    @BindView(R.id.butt_login_wjpwd)
    Button buttLoginWjpwd;
    @BindView(R.id.text_login_register)
    TextView textLoginRegister;
    @BindView(R.id.butt_login_login)
    Button buttLoginLogin;
    @BindView(R.id.butt_weixin_login)
    Button buttWeixinLogin;
    private FragmentManager manager = getSupportFragmentManager();

    private long firstTime;// 记录点击返回时第一次的时间毫秒值

    @Override
    protected IUserPresenter providePresenter() {
        return new IUserPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        String code = intent.getStringExtra("code");
        if (code!=null){
            Logger.i(TAG, "initData: "+code);
            mPresenter.getWxloginPresenter(code);
        }
    }

    @Override
    public void onEmailSuccess(EmailBean bean) {

    }

    @Override
    public void onRegisterSuccess(RegisterBean bean) {

    }

    @Override
    public void onLoginSuccess(LoginBean bean) {
        Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        if (bean.getStatus().equals("0000")) {
            finish();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("userId", bean.getResult().getUserId() + "");
            edit.putString("sessionId", bean.getResult().getSessionId() + "");
            edit.commit();
        }
    }

    @Override
    public void onWxloginSuccess(WxLogBean bean) {
        if (bean.message.equals("登陆成功")){
            SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("userId", bean.result.userId + "");
            edit.putString("sessionId", bean.result.sessionId + "");
            Logger.i(TAG,"onWxloginSuccess: "+bean.result.userInfo.headPic + "");
            Logger.i(TAG,"onWxloginSuccess: "+bean.result.sessionId + "");
            edit.putString("headPic",bean.result.userInfo.headPic);
            edit.putString("nickName",bean.result.userInfo.nickName);
            edit.putString("sex",bean.result.userInfo.sex+"");
            edit.commit();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
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

    @OnClick({R.id.butt_login_wjpwd, R.id.text_login_register, R.id.butt_login_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.butt_login_wjpwd:
                break;
            case R.id.text_login_register:
                finish();
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.butt_login_login:
                String email = editLoginEmail.getText().toString().trim();
                String pwd = editLoginPwd.getText().toString().trim();
                String MD5_pwd = EncryptUtil.encrypt(pwd);
                mPresenter.getLoginPresenter(email, MD5_pwd);
                break;
        }
    }

 /*   @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {// 点击了返回按键
            if (manager.getBackStackEntryCount() != 0) {
                manager.popBackStack();
            } else {
                exitApp(2000);// 退出应用
            }
            return true;// 返回true，防止该事件继续向下传播
        }
        return super.onKeyDown(keyCode, event);
    }

    *//**
     * 退出应用
     *
//     * @param timeInterval 设置第二次点击退出的时间间隔
     *//*
    private void exitApp(long timeInterval) {
        // 第一次肯定会进入到if判断里面，然后把firstTime重新赋值当前的系统时间
        // 然后点击第二次的时候，当点击间隔时间小于2s，那么退出应用；反之不退出应用
        if (System.currentTimeMillis() - firstTime >= timeInterval) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = System.currentTimeMillis();
        } else {
            finish();// 销毁当前activity
            System.exit(0);// 完全退出应用
        }
    }*/

    @OnClick(R.id.butt_weixin_login)
    public void onClick() {
      SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        App.api.sendReq(req);
    }
}
