package com.bw.movie.fragment;
/*
 *@auther:李泽楷
 *@Date: 2019/12/3
 *@Time:20:27
 *@Description:${DESCRIPTION}
 **/

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.MyYingYuanGuanZhuAdapter;
import com.bw.movie.app.Login;
import com.bw.movie.bean.CxgzdyBean;
import com.bw.movie.bean.CxgzyyBean;
import com.bw.movie.bean.GzdyBean;
import com.bw.movie.bean.GzyyBean;
import com.bw.movie.bean.QxgzdyBean;
import com.bw.movie.bean.QxgzyyBean;
import com.bw.movie.contract.IWdgzContract;
import com.bw.movie.presenter.IWdgzPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

public class Fragment_gzyy extends BaseFragment<IWdgzPresenter> implements IWdgzContract.IWdgzView {
    @BindView(R.id.yingyuan_gz)
    XRecyclerView yingyuanGz;
    @BindView(R.id.nolike)
    ImageView nolike;
    @BindView(R.id.nono)
    TextView nono;
    int page =1;
    Login login=new Login();
    @Override
    protected IWdgzPresenter providePresenter() {
        return new IWdgzPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_gzyy;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getCxgzyyPresenter(login.userId,login.sessionId,"1","10");
    }

    @Override
    public void onGzdySuccess(GzdyBean bean) {

    }

    @Override
    public void onQxgzdySuccess(QxgzdyBean bean) {

    }

    @Override
    public void onGzyySuccess(GzyyBean bean) {

    }

    @Override
    public void onQxgzyySuccess(QxgzyyBean bean) {

    }

    @Override
    public void onCxgzdySuccess(CxgzdyBean bean) {

    }

    @Override
    public void onCxgzyySuccess(CxgzyyBean bean) {
        if (bean.getStatus().equals("0000")) {
            if (bean.getMessage().equals("无关注影院")){
                Toast.makeText(getActivity(), bean.getMessage(), Toast.LENGTH_SHORT).show();
            }else {
                if (bean == null) {
                    nolike.setVisibility(View.VISIBLE);
                    nono.setVisibility(View.VISIBLE);
                } else {
                    List<CxgzyyBean.ResultBean> result = bean.getResult();
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                    yingyuanGz.setLayoutManager(linearLayoutManager);
                    yingyuanGz.setAdapter(new MyYingYuanGuanZhuAdapter(result, getActivity()));
                    yingyuanGz.setLoadingMoreEnabled(true);
                    yingyuanGz.setPullRefreshEnabled(true);
                    yingyuanGz.setLoadingListener(new XRecyclerView.LoadingListener() {
                        @Override
                        public void onRefresh() {
                            page = 1;
                            yingyuanGz.refreshComplete();
                        }

                        @Override
                        public void onLoadMore() {
                            page++;
                            yingyuanGz.loadMoreComplete();
                        }
                    });
            }

            }
        }else {
            Toast.makeText(getActivity(), bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }
}
