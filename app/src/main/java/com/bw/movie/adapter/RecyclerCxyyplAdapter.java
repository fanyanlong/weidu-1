package com.bw.movie.adapter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/13
 *@Time:8:39
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.CxyyplBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerCxyyplAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<CxyyplBean.ResultBean> list;
    private Context context;

    public RecyclerCxyyplAdapter(List<CxyyplBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_item_cxyypl, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            Date date = new Date(list.get(position).getCommentTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            ((MyViewHolder) holder).chayingpingTime.setText(simpleDateFormat.format(date));
            ((MyViewHolder) holder).chayingpingName.setText(list.get(position).getCinemaName());
            ((MyViewHolder) holder).chayingpingImg.setImageURI(list.get(position).getLogo());
            ((MyViewHolder) holder).chayingpingDizhi.setText(list.get(position).getAddress());

            ((MyViewHolder) holder).chayingpingPinglun.setText(list.get(position).getMyCommentContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.chayingping_img)
        SimpleDraweeView chayingpingImg;
        @BindView(R.id.chayingping_name)
        TextView chayingpingName;
        @BindView(R.id.chayingping_dizhi)
        TextView chayingpingDizhi;
        @BindView(R.id.chayingping_juli)
        TextView chayingpingJuli;
        @BindView(R.id.chayingping_pinglun)
        TextView chayingpingPinglun;
        @BindView(R.id.chayingping_time)
        TextView chayingpingTime;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private onClickCallBack onClickCallBack;

    public void getonClickCallBack(onClickCallBack onClickCallBack) {
        this.onClickCallBack = onClickCallBack;
    }

    public interface onClickCallBack {
        void getMovieId(int id);
    }
}
