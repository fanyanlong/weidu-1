package com.bw.movie.fragment.gengduo;
/*
 *@auther:李泽楷
 *@Date: 2019/12/1
 *@Time:19:29
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.XiangqingActivity;
import com.bw.movie.adapter.RecyclorShowAdapter;
import com.bw.movie.app.Login;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.ShowBean;
import com.bw.movie.bean.ShowingBean;
import com.bw.movie.bean.XbannerBean;
import com.bw.movie.contract.IMovieContract;
import com.bw.movie.presenter.IMoviePresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class Fragment_jjsy extends BaseFragment<IMoviePresenter> implements IMovieContract.IMovieView {

    @BindView(R.id.recycler_jjsy)
    RecyclerView recyclerJjsy;

    @Override
    protected IMoviePresenter providePresenter() {
        return new IMoviePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_jjsy;
    }

    @Override
    protected void initData() {
        super.initData();
        Map<String, String> map = new HashMap<>();
        Login login=new Login();
        map.put("userId", login.userId);
        map.put("sessionId", login.sessionId);
        mPresenter.getShowPresenter("1", "10", map);
    }

    @Override
    public void onXbannerSuccess(XbannerBean bean) {

    }

    @Override
    public void onShowingSuccess(ShowingBean bean) {

    }

    @Override
    public void onShowSuccess(ShowBean bean) {
        if (bean.getMessage().equals("0000")) {
            List<ShowBean.ResultBean> list = new ArrayList<>();
            for (int i = 0; i < bean.getResult().size(); i++) {
                list.add(bean.getResult().get(i));
            }
            RecyclorShowAdapter adapter = new RecyclorShowAdapter(list, getActivity());
            recyclerJjsy.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerJjsy.setAdapter(adapter);
            adapter.getonClickCallBack(new RecyclorShowAdapter.onClickCallBack() {
                @Override
                public void getMovieId(int id) {
                    Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                    intent.putExtra("movieId", id + "");
                    getActivity().startActivity(intent);
                }
            });
        }
        else {
            Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHotSuccess(HotBean bean) {

    }

    @Override
    public void onFailure(Throwable e) {

    }
}
