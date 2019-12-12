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
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.CxdyplBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerCxdyplAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CxdyplBean.ResultBean> list;
    private Context context;

    public RecyclerCxdyplAdapter(List<CxdyplBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_item_cxdypl, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            Date date = new Date(list.get(position).getCommentTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            ((MyViewHolder) holder).dianuingTime.setText(simpleDateFormat.format(date));
            ((MyViewHolder) holder).dianyingDaoyan.setText(list.get(position).getDirector());
            ((MyViewHolder) holder).dianyingImg.setImageURI(list.get(position).getImageUrl());
            ((MyViewHolder) holder).dianyingName.setText(list.get(position).getMovieName());
            ((MyViewHolder) holder).ratFilmcinecism.setRating((float) list.get(position).getMyCommentScore());
            ((MyViewHolder) holder).dianyingPingfen.setText(list.get(position).getMovieScore()+"");
            ((MyViewHolder) holder).dianyingZhuyan.setText(list.get(position).getStarring());
            ((MyViewHolder) holder).dingyingPinglun.setText(list.get(position).getMyCommentContent());
            ((MyViewHolder) holder).yingpingFenshu.setText("("+list.get(position).getMyCommentScore()+")");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.dianying_img)
        SimpleDraweeView dianyingImg;
        @BindView(R.id.dianying_name)
        TextView dianyingName;
        @BindView(R.id.dianying_daoyan)
        TextView dianyingDaoyan;
        @BindView(R.id.dianying_zhuyan)
        TextView dianyingZhuyan;
        @BindView(R.id.dianying_pingfen)
        TextView dianyingPingfen;
        @BindView(R.id.dingying_pinglun)
        TextView dingyingPinglun;
        @BindView(R.id.rat_filmcinecism)
        RatingBar ratFilmcinecism;
        @BindView(R.id.yingping_fenshu)
        TextView yingpingFenshu;
        @BindView(R.id.dianuing_time)
        TextView dianuingTime;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
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
