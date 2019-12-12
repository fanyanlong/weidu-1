package com.bw.movie.fragment.xiangqing;
/*
 *@auther:李泽楷
 *@Date: 2019/11/15
 *@Time:21:24
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.xiangqing.RecyclerYuGaoAdapter;
import com.bw.movie.bean.GzdyBean;
import com.bw.movie.bean.QxgzdyBean;
import com.bw.movie.bean.XiangqingBean;
import com.bw.movie.contract.IXiangqingContract;
import com.bw.movie.presenter.IXiangqingPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class Frag_yg extends BaseFragment<IXiangqingPresenter> implements IXiangqingContract.IXiangqingView {

    @BindView(R.id.recycler_xiangqing_yugao)
    RecyclerView recyclerXiangqingYugao;

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_xiangqing_yg;
    }

    @Override
    protected IXiangqingPresenter providePresenter() {
        return new IXiangqingPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        String movieId = intent.getStringExtra("movieId");
        Map<String, Object> map = new HashMap<>();
        map.put("userId", "13798");
        map.put("sessionId", "157356295970613798");
        mPresenter.getXiangqingPresenter(map, movieId);
        recyclerXiangqingYugao.setNestedScrollingEnabled(false);
    }

    @Override
    public void onXiangqingSuccess(XiangqingBean bean) {
        List<XiangqingBean.ResultBean.ShortFilmListBean> listBeans = new ArrayList<>();
        for (int i = 0; i < bean.getResult().getShortFilmList().size(); i++) {
            listBeans.add(bean.getResult().getShortFilmList().get(i));
        }
        RecyclerYuGaoAdapter recyclerYuGaoAdapter = new RecyclerYuGaoAdapter(listBeans, getActivity());
        recyclerXiangqingYugao.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerXiangqingYugao.setAdapter(recyclerYuGaoAdapter);
    }

    @Override
    public void onGzdySuccess(GzdyBean bean) {

    }

    @Override
    public void onQxgzdySuccess(QxgzdyBean bean) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayerStandard.releaseAllVideos();
    }
}
