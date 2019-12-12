package com.bw.movie.fragment.gpjl;
/*
 *@auther:李泽楷
 *@Date: 2019/12/1
 *@Time:21:17
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bw.movie.DfkxqActivity;
import com.bw.movie.R;
import com.bw.movie.adapter.MyRecyAdapterO;
import com.bw.movie.app.Login;
import com.bw.movie.bean.DdxqBean;
import com.bw.movie.bean.GpjlBean;
import com.bw.movie.bean.ZfBean;
import com.bw.movie.contract.IGpjlContract;
import com.bw.movie.presenter.IGpjlPresenter;

import java.util.List;

import butterknife.BindView;

public class Fragment_yfk extends BaseFragment<IGpjlPresenter> implements IGpjlContract.IGpjlView {
    public static final String TAG = "Fragment_yfk";
    @BindView(R.id.recy_dai)
    RecyclerView recyDai;
    @BindView(R.id.text)
    TextView text;

    @Override
    protected IGpjlPresenter providePresenter() {
        return new IGpjlPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_over;
    }

    @Override
    protected void initData() {
        super.initData();
        Login login = new Login();
        mPresenter.getGpjlPresenter(login.userId, login.sessionId, "1", "8", "2");
    }

    @Override
    public void onGpjlSuccess(GpjlBean bean) {
        Logger.i(TAG, bean.getMessage());
        if (bean.getStatus().equals("0000")) {
            if (bean.getMessage().contains("无购票记录")) {
                text.setVisibility(View.VISIBLE);
            } else {
                List<GpjlBean.ResultBean> list = bean.getResult();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyDai.setLayoutManager(linearLayoutManager);
                MyRecyAdapterO myRecyAdaptero = new MyRecyAdapterO(list, getActivity());
                recyDai.setAdapter(myRecyAdaptero);
                myRecyAdaptero.setOnClickListener(new MyRecyAdapterO.OnClickListener() {
                    @Override
                    public void onclick(String orderId) {
                        Logger.i(TAG, orderId);
                        Intent intent = new Intent(getActivity(), DfkxqActivity.class);
                        intent.putExtra("orderId", orderId);
                        startActivity(intent);
                    }
                });
            }
        }else {
            Toast.makeText(getActivity(), bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDdxqSuccess(DdxqBean bean) {

    }

    @Override
    public void onZfSuccess(ZfBean bean) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

}
