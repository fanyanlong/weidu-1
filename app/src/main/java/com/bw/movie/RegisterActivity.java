package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.WxLogBean;
import com.bw.movie.contract.IUserContract;
import com.bw.movie.md5.EncryptUtil;
import com.bw.movie.presenter.IUserPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *@describe(描述)：RegisterActivity
 *@data（日期）: 2019/11/12
 *@time（时间）: 8:45
 *@author（作者）: 李泽楷
 **/

public class RegisterActivity extends BaseActivity<IUserPresenter> implements IUserContract.IUserlView {


    @BindView(R.id.edit_register_name)
    EditText editRegisterName;
    @BindView(R.id.edit_register_email)
    EditText editRegisterEmail;
    @BindView(R.id.edit_register_pwd)
    EditText editRegisterPwd;

    @BindView(R.id.butt_register_register)
    Button buttRegisterRegister;
    @BindView(R.id.butt_register_email)
    Button buttRegisterEmail;
    @BindView(R.id.text_register_login)
    TextView textRegisterLogin;
    @BindView(R.id.edit_register_yzm)
    EditText editRegisterYzm;
    private FragmentManager manager = getSupportFragmentManager();

    private long firstTime;// 记录点击返回时第一次的时间毫秒值
    @Override
    protected IUserPresenter providePresenter() {
        return new IUserPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void onEmailSuccess(EmailBean bean) {
        String message = bean.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterSuccess(RegisterBean bean) {
        String message = bean.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(LoginBean bean) {

    }

    @Override
    public void onWxloginSuccess(WxLogBean bean) {

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


    @OnClick({R.id.butt_register_email, R.id.butt_register_register, R.id.text_register_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.butt_register_email:
                String email = editRegisterEmail.getText().toString().trim();
                mPresenter.getEmailPresenter(email);
                break;
            case R.id.butt_register_register:
                String email2 = editRegisterEmail.getText().toString().trim();
                String name = editRegisterName.getText().toString().trim();
                String yzm = editRegisterYzm.getText().toString().trim();
                String pwd = editRegisterPwd.getText().toString().trim();
                String MD5_pwd = EncryptUtil.encrypt(pwd);
                mPresenter.getRegisterPresenter(name, MD5_pwd,email2,yzm );
                break;
            case R.id.text_register_login:
                finish();
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){// 点击了返回按键
            if(manager.getBackStackEntryCount() != 0){
                manager.popBackStack();
            }else {
                exitApp(2000);// 退出应用
            }
            return true;// 返回true，防止该事件继续向下传播
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 退出应用
     * @param timeInterval 设置第二次点击退出的时间间隔
     */
    private void exitApp(long timeInterval) {
        // 第一次肯定会进入到if判断里面，然后把firstTime重新赋值当前的系统时间
        // 然后点击第二次的时候，当点击间隔时间小于2s，那么退出应用；反之不退出应用
        if(System.currentTimeMillis() - firstTime >= timeInterval){
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = System.currentTimeMillis();
        }else {
            finish();// 销毁当前activity
            System.exit(0);// 完全退出应用
        }
    }
}

