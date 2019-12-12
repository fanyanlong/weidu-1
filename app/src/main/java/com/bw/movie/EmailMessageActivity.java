package com.bw.movie;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bw.movie.adapter.EmailMessageAdapter;
import com.bw.movie.app.Login;
import com.bw.movie.bean.EmailMessageBean;
import com.bw.movie.contract.EmailMessageContract;
import com.bw.movie.presenter.EmailMessagePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmailMessageActivity extends BaseActivity<EmailMessagePresenter> implements EmailMessageContract.IView {


    @BindView(R.id.message_fanhui)
    SimpleDraweeView messageFanhui;
    @BindView(R.id.write_relation)
    RelativeLayout writeRelation;
    @BindView(R.id.xrecy_email)
    XRecyclerView xrecyEmail;
    private Login login;
    int page = 1;
    @Override
    protected EmailMessagePresenter providePresenter() {
        return new EmailMessagePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_email_message;
    }

    @Override
    protected void initData() {
        super.initData();
        login = new Login();
        mPresenter.getEmailMessageData(login.userId, login.sessionId, page + "", "9");
    }

    @Override
    public void onEmailSuccess(EmailMessageBean bean) {
        if (bean.getStatus().equals("0000")){
            if (bean.getResult() == null) {
                finish();
                Toast.makeText(this, "空", Toast.LENGTH_SHORT).show();
                return;
            }
            List<EmailMessageBean.ResultBean> result = bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(EmailMessageActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            xrecyEmail.setLayoutManager(linearLayoutManager);
            xrecyEmail.setAdapter(new EmailMessageAdapter(result, EmailMessageActivity.this));
            xrecyEmail.setPullRefreshEnabled(true);
            xrecyEmail.setLoadingMoreEnabled(true);
            xrecyEmail.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    page = 1;
                    xrecyEmail.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    page++;
                    xrecyEmail.loadMoreComplete();
                }
            });
        }else {
            Toast.makeText(this, ""+bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onEmailFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.message_fanhui)
    public void onClick() {
        finish();
    }
}
