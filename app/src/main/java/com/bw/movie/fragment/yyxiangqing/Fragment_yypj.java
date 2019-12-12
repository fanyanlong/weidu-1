package com.bw.movie.fragment.yyxiangqing;
/*
 *@auther:李泽楷
 *@Date: 2019/11/30
 *@Time:12:01
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bw.movie.R;
import com.bw.movie.adapter.xiangqing.RecyclerYYYingPingAdapter;
import com.bw.movie.app.Login;
import com.bw.movie.bean.YyplBean;
import com.bw.movie.contract.IYyplContract;
import com.bw.movie.presenter.IYyplPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_yypj extends BaseFragment<IYyplPresenter> implements IYyplContract.IYyplView {


    private static final String TAG = "Fragment_yypj";
    @BindView(R.id.recycler_yy_pl)
    RecyclerView recyclerYyPl;

    @Override
    protected IYyplPresenter providePresenter() {
        return new IYyplPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_yyxq_yypj;

    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        Login login=new Login();

        mPresenter.getYyplPresenter(login.userId, login.sessionId, id, "1", "10");
    }

    @Override
    public void onYyplSuccess(YyplBean bean) {
        String message = bean.getMessage();
        Logger.i(TAG,message);
        if (bean.getStatus().equals("0000")) {
            if (bean.getMessage().equals("无数据")){
                return;
            }
            Logger.i(TAG, bean.getMessage());
            List<YyplBean.ResultBean> list = new ArrayList<>();
            for (int i = 0; i < bean.getResult().size(); i++) {
                list.add(bean.getResult().get(i));
            }
            RecyclerYYYingPingAdapter adapter = new RecyclerYYYingPingAdapter(list, getActivity());
            recyclerYyPl.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerYyPl.setAdapter(adapter);
        }else {
            Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onYyplFailure(Throwable e) {

    }
}
