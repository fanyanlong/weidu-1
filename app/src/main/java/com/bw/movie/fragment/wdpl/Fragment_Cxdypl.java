package com.bw.movie.fragment.wdpl;
/*
 *@auther:李泽楷
 *@Date: 2019/12/3
 *@Time:8:41
 *@Description:${DESCRIPTION}
 **/

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.RecyclerCxdyplAdapter;
import com.bw.movie.app.Login;
import com.bw.movie.bean.CxdyplBean;
import com.bw.movie.bean.CxyyplBean;
import com.bw.movie.contract.ICxplContract;
import com.bw.movie.presenter.ICxplPresenter;

import butterknife.BindView;

public class Fragment_Cxdypl extends BaseFragment<ICxplPresenter> implements ICxplContract.ICxplView {
    Login login = new Login();
    @BindView(R.id.recycler_cxdypl)
    RecyclerView recyclerCxdypl;

    @Override
    protected ICxplPresenter providePresenter() {
        return new ICxplPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_cxdypl;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getCxdyplPresenter(login.userId, login.sessionId, "1", "9");
    }

    @Override
    public void onCxdyplSuccess(CxdyplBean bean) {
        if (bean.getStatus().equals("0000")){
            if (bean.getMessage().equals("无影院评论")){
                Toast.makeText(getActivity(), bean.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }else {
            RecyclerCxdyplAdapter adapter = new RecyclerCxdyplAdapter(bean.getResult(), getActivity());
            recyclerCxdypl.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerCxdypl.setAdapter(adapter);
        }
    }

    @Override
    public void onCxyyplSuccess(CxyyplBean bean) {

    }

    @Override
    public void onFailure(Throwable e) {

    }
}
