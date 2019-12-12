package com.bw.movie.fragment.xiangqing;
/*
 *@auther:李泽楷
 *@Date: 2019/11/15
 *@Time:21:24
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.R;
import com.bw.movie.adapter.xiangqing.RecyclerDaoyanAdapter;
import com.bw.movie.adapter.xiangqing.RecyclerYanyuanAdapter;
import com.bw.movie.bean.GzdyBean;
import com.bw.movie.bean.QxgzdyBean;
import com.bw.movie.bean.XiangqingBean;
import com.bw.movie.bean.XuanZuoEventBus;
import com.bw.movie.contract.IXiangqingContract;
import com.bw.movie.presenter.IXiangqingPresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class Frag_js extends BaseFragment<IXiangqingPresenter> implements IXiangqingContract.IXiangqingView {
    @BindView(R.id.juqingjianjie)
    TextView juqingjianjie;
    @BindView(R.id.jieshao_rlv1)
    RecyclerView jieshaoRlv1;
    @BindView(R.id.jieshao_rlv2)
    RecyclerView jieshaoRlv2;



    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_xiangqing_js;
    }

    @Override
    protected void initView() {
        super.initView();

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
    }

    @Override
    public void onXiangqingSuccess(XiangqingBean bean) {
        juqingjianjie.setText(bean.getResult().getSummary());
        List<XiangqingBean.ResultBean.MovieDirectorBean>movieDirectorBeanList=new ArrayList<>();
        List<XiangqingBean.ResultBean.MovieActorBean>movieActorBeans=new ArrayList<>();
        for (int i = 0; i < bean.getResult().getMovieDirector().size(); i++) {
            movieDirectorBeanList.add(bean.getResult().getMovieDirector().get(i));
        }
        for (int i = 0; i < bean.getResult().getMovieActor().size(); i++) {
            movieActorBeans.add(bean.getResult().getMovieActor().get(i));
        }
        RecyclerDaoyanAdapter recyclerDaoyanAdapter=new RecyclerDaoyanAdapter(movieDirectorBeanList,getActivity());
        RecyclerYanyuanAdapter recyclerYanyuanAdapter=new RecyclerYanyuanAdapter(movieActorBeans,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),4);
        jieshaoRlv1.setLayoutManager(linearLayoutManager);
        jieshaoRlv1.setAdapter(recyclerDaoyanAdapter);
        jieshaoRlv2.setLayoutManager(gridLayoutManager);
        jieshaoRlv2.setAdapter(recyclerYanyuanAdapter);
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


}
