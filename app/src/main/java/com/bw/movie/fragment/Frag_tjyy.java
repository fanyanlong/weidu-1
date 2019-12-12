package com.bw.movie.fragment;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:16:47
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.YyxiangqingActivity;
import com.bw.movie.adapter.RecycloerTjyyAdapter;
import com.bw.movie.bean.TjyyBean;
import com.bw.movie.contract.ITjyyContract;
import com.bw.movie.presenter.ITjyyPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Frag_tjyy extends BaseFragment<ITjyyPresenter> implements ITjyyContract.ITjyyView {

    private static final String TAG = "Frag_tjyy";
    @BindView(R.id.xrecycler_tjyy)
    XRecyclerView xrecyclerTjyy;

    @Override
    protected ITjyyPresenter providePresenter() {
        return new ITjyyPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_cinema_tjyy;
    }

    @Override
    protected void initView() {
        super.initView();
    }


    @Override
    protected void initData() {
        super.initData();
        mPresenter.getTjyyPresenter("1","10");
        xrecyclerTjyy.setPullRefreshEnabled(true);
        xrecyclerTjyy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xrecyclerTjyy.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xrecyclerTjyy.loadMoreComplete();
            }
        });
    }

    @Override
    public void onTjyySuccess(TjyyBean bean) {
        List<TjyyBean.ResultBean>list=new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            list.add(bean.getResult().get(i));
        }
        RecycloerTjyyAdapter adapter=new RecycloerTjyyAdapter(list,getActivity());
        xrecyclerTjyy.setLayoutManager(new LinearLayoutManager(getActivity()));
        xrecyclerTjyy.setAdapter(adapter);
        adapter.getClick(new RecycloerTjyyAdapter.onClick() {
            @Override
            public void setClick(int id) {
                Intent intent=new Intent(getActivity(), YyxiangqingActivity.class);
                intent.putExtra("id",id+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onTjyyFailure(Throwable e) {

    }
}
