package com.bw.movie.fragment.gengduo;
/*
 *@auther:李泽楷
 *@Date: 2019/12/1
 *@Time:19:29
 *@Description:${DESCRIPTION}
 **/

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.RecyclerGdrmdyAdapter;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.ShowBean;
import com.bw.movie.bean.ShowingBean;
import com.bw.movie.bean.XbannerBean;
import com.bw.movie.contract.IMovieContract;
import com.bw.movie.presenter.IMoviePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_rmdy extends BaseFragment<IMoviePresenter> implements IMovieContract.IMovieView {

    @BindView(R.id.recycler_rmdy)
    RecyclerView recyclerRmdy;

    @Override
    protected IMoviePresenter providePresenter() {
        return new IMoviePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_rmdy;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getShowingrPresenter("1", "10");
    }

    @Override
    public void onXbannerSuccess(XbannerBean bean) {

    }

    @Override
    public void onShowingSuccess(ShowingBean bean) {
        List<ShowingBean.ResultBean> list = new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            list.add(bean.getResult().get(i));
        }
        RecyclerGdrmdyAdapter adapter = new RecyclerGdrmdyAdapter(list, getActivity());
        recyclerRmdy.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerRmdy.setAdapter(adapter);
    }

    @Override
    public void onShowSuccess(ShowBean bean) {

    }

    @Override
    public void onHotSuccess(HotBean bean) {

    }

    @Override
    public void onFailure(Throwable e) {

    }
}
