package com.bw.movie.fragment.yyxiangqing;
/*
 *@auther:李泽楷
 *@Date: 2019/12/1
 *@Time:14:54
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.bw.movie.R;
import com.bw.movie.XiangqingActivity;
import com.bw.movie.adapter.xiangqing.RecyclerYypqgAdapter;
import com.bw.movie.bean.YypqBean;
import com.bw.movie.contract.IYypqContract;
import com.bw.movie.presenter.IYypqPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_yypq extends BaseFragment<IYypqPresenter> implements IYypqContract.IYypqView {
    private static final String TAG = "Fragment_yypq";
    @BindView(R.id.recycler_yypq)
    RecyclerView recyclerYypq;

    @Override
    protected IYypqPresenter providePresenter() {
        return new IYypqPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_yypq;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        mPresenter.getYypqPresenter(id, "1", "5");
    }

    @Override
    public void onYypqSuccess(YypqBean bean) {
        Logger.i(TAG, bean.getMessage());
        if (bean.getMessage().equals("查询数据为空")){
            Toast.makeText(getActivity(), "查询数据为空", Toast.LENGTH_SHORT).show();
            return;
        }
        List<YypqBean.ResultBean> list = new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            list.add(bean.getResult().get(i));
        }
        RecyclerYypqgAdapter adapter = new RecyclerYypqgAdapter(list, getActivity());
        recyclerYypq.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerYypq.setAdapter(adapter);
        adapter.getonClickCallBack(new RecyclerYypqgAdapter.onClickCallBack() {
            @Override
            public void getMovieId(int id) {
                Intent intent1 = new Intent(getActivity(), XiangqingActivity.class);
                intent1.putExtra("movieId",id+"");
                getActivity().startActivity(intent1);
            }
        });
    }

    @Override
    public void onYypqFailure(Throwable e) {

    }
}
