package com.bw.movie;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bw.movie.adapter.RecyclerDyssgAdapter;
import com.bw.movie.bean.DyssBean;
import com.bw.movie.contract.IDyssContract;
import com.bw.movie.presenter.IDyssPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *@describe(描述)：DyssActivity
 *@data（日期）: 2019/12/3
 *@time（时间）: 13:58
 *@author（作者）: 李泽楷
 **/

public class DyssActivity extends BaseActivity<IDyssPresenter> implements IDyssContract.IDyssView {


    private static final String TAG = "DyssActivity";
    @BindView(R.id.image_dy_ss)
    ImageView imageDySs;
    @BindView(R.id.edit_dy_sousuo)
    EditText editDySousuo;
    @BindView(R.id.recycler_dy_sousuo)
    RecyclerView recyclerDySousuo;

    @Override
    protected IDyssPresenter providePresenter() {
        return new IDyssPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_dyss;
    }

    @Override
    protected void initData() {
        super.initData();
        editDySousuo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = editable.toString();
                mPresenter.getDyssPresenter(s,"1","5");
            }
        });
    }

    @Override
    public void onDyssSuccess(DyssBean bean) {
        Logger.i(TAG,bean.getMessage());
        if (bean.getMessage().equals("未查到相关电影")){
            return;
        }
        List<DyssBean.ResultBean>list=new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            list.add(bean.getResult().get(i));
        }
        RecyclerDyssgAdapter adapter=new RecyclerDyssgAdapter(list,DyssActivity.this);
        recyclerDySousuo.setLayoutManager(new LinearLayoutManager(DyssActivity.this));
        recyclerDySousuo.setAdapter(adapter);
    }

    @Override
    public void onDyssFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.image_dy_ss)
    public void onClick() {
        finish();
    }
}
