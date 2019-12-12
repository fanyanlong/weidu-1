package com.bw.movie.fragment;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:16:47
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.YyxiangqingActivity;
import com.bw.movie.adapter.RecyclerQuAdapter;
import com.bw.movie.adapter.RecyclerRegionAdapter;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.contract.IRegionContract;
import com.bw.movie.presenter.IRegionPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Frag_qy extends BaseFragment<IRegionPresenter> implements IRegionContract.IRegionView {

    @BindView(R.id.recycler_qu)
    RecyclerView recyclerQu;
    @BindView(R.id.recycler_yy)
    RecyclerView recyclerYy;



    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_cinema_qy;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected IRegionPresenter providePresenter() {
        return new IRegionPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        List<String>quList=new ArrayList<>();
        quList.add("海淀区");
        quList.add("朝阳区");
        quList.add("东城区");
        quList.add("西城区");
        quList.add("石景山区");
        quList.add("丰台区");
        quList.add("大兴区");
        quList.add("通州区");
        quList.add("顺义区");
        quList.add("昌平区");
        quList.add("房山区");
        RecyclerQuAdapter adapter=new RecyclerQuAdapter(quList,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerQu.setLayoutManager(linearLayoutManager);
        recyclerQu.setAdapter(adapter);
        adapter.setGetOnClick(new RecyclerQuAdapter.getOnClick() {
            @Override
            public void getClick(int i) {
                mPresenter.getRegionPresenter(i+"");
            }
        });
    }

    @Override
    public void onRegionSuccess(RegionBean bean) {
        List<RegionBean.ResultBean>list=new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            list.add(bean.getResult().get(i));
        }
        RecyclerRegionAdapter adapter=new RecyclerRegionAdapter(list,getActivity());
        recyclerYy.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerYy.setAdapter(adapter);
        adapter.setGetOnClick(new RecyclerRegionAdapter.getOnClick() {
            @Override
            public void getClick(int i) {
                Intent intent=new Intent(getActivity(), YyxiangqingActivity.class);
                intent.putExtra("id",i+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRegionFailure(Throwable e) {

    }
}
