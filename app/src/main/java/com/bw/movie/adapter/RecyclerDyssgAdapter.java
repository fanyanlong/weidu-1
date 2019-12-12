package com.bw.movie.adapter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/19
 *@Time:19:05
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.XiangqingActivity;
import com.bw.movie.bean.DyssBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerDyssgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<DyssBean.ResultBean> list;
    private Context context;

    public RecyclerDyssgAdapter(List<DyssBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_item_dyss, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).simpDyssImageUrl.setImageURI(list.get(position).getImageUrl());
            ((MyViewHolder) holder).textDyssName.setText(list.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(context, XiangqingActivity.class);
                    intent1.putExtra("movieId",list.get(position).getMovieId()+"");
                    context.startActivity(intent1);
                }
            });
            ((MyViewHolder) holder).textDyssDirector.setText("导演:"+list.get(position).getDirector());
            ((MyViewHolder) holder).textDyssScore.setText("评分:"+list.get(position).getScore()+"");
            ((MyViewHolder) holder).textDyssStarring.setText("主演:"+list.get(position).getStarring());

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_dyss_name)
        TextView textDyssName;
        @BindView(R.id.text_dyss_director)
        TextView textDyssDirector;
        @BindView(R.id.text_dyss_starring)
        TextView textDyssStarring;
        @BindView(R.id.text_dyss_score)
        TextView textDyssScore;
        @BindView(R.id.simp_dyss_imageUrl)
        SimpleDraweeView simpDyssImageUrl;
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
