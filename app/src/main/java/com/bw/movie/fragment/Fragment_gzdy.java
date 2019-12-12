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
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bw.movie.R;
import com.bw.movie.adapter.MyGuanZhuAdapter;
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

public class Fragment_gzdy extends BaseFragment<IWdgzPresenter> implements IWdgzContract.IWdgzView {
    Login login = new Login();
    @BindView(R.id.movie_gz)
    XRecyclerView movieGz;
    @BindView(R.id.nolike)
    ImageView nolike;
    @BindView(R.id.nono)
    TextView nono;
    int page=1;
    @Override
    protected IWdgzPresenter providePresenter() {
        return new IWdgzPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_gzdy;
    }

    @Override
    protected void initData() {
        super.initData();
        Logger.i("onCxgzdySuccess","123");

        mPresenter.getCxgzdyPresenter(login.userId,login.sessionId,"1","10");
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
        Logger.i("onCxgzdySuccess",bean.getMessage());
        if (bean.getStatus().equals("0000")){
            if (bean.getMessage().equals("无关注电影")){
                Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
            }else {
                if (bean==null){
                    nolike.setVisibility(View.VISIBLE);
                    nono.setVisibility(View.VISIBLE);
                }else {
                    Logger.i("onCxgzdySuccess",bean.getMessage());
                    List<CxgzdyBean.ResultBean> result = bean.getResult();
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                    movieGz.setLayoutManager(linearLayoutManager);
                    movieGz.setLoadingMoreEnabled(true);
                    movieGz.setPullRefreshEnabled(true);
                    movieGz.setAdapter(new MyGuanZhuAdapter(result,getActivity()));
                    movieGz.setLoadingListener(new XRecyclerView.LoadingListener() {
                        @Override
                        public void onRefresh() {
                            page=1;
                            movieGz.refreshComplete();
                        }

                        @Override
                        public void onLoadMore() {
                            page++;
                            movieGz.loadMoreComplete();
                        }
                    });
            }

        }
        }else {
            Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCxgzyySuccess(CxgzyyBean bean) {

    }

    @Override
    public void onFailure(Throwable e) {

    }
}
