package com.bw.movie.adapter.xiangqing;
/*
 *@auther:李泽楷
 *@Date: 2019/11/19
 *@Time:19:05
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.YypqBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerYypqgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<YypqBean.ResultBean> list;
    private Context context;

    public RecyclerYypqgAdapter(List<YypqBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_item_yypq, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).item2Name.setText(list.get(position).getName());
            ((MyViewHolder) holder).item2Time.setText("导演:"+list.get(position).getDirector());
            ((MyViewHolder) holder).item2Zhuyan.setText("主演:"+list.get(position).getStarring());
            ((MyViewHolder) holder).item2Ren.setText("评分:"+list.get(position).getScore());
            ((MyViewHolder) holder).item2Img.setImageURI(list.get(position).getImageUrl());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickCallBack.getMovieId(list.get(position).getMovieId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item2_name)
        TextView item2Name;
        @BindView(R.id.item2_time)
        TextView item2Time;
        @BindView(R.id.item2_zhuyan)
        TextView item2Zhuyan;
        @BindView(R.id.item2_ren)
        TextView item2Ren;
        @BindView(R.id.yuyue_will)
        Button yuyueWill;
        @BindView(R.id.item2_img)
        SimpleDraweeView item2Img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    private onClickCallBack onClickCallBack;
    public void getonClickCallBack(onClickCallBack onClickCallBack){
        this.onClickCallBack=onClickCallBack;
    }
    public interface onClickCallBack{
        void getMovieId(int id);
    }
}
