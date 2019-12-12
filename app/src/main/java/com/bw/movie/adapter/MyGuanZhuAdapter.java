package com.bw.movie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.CxgzdyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/*
 *@auther:李泽楷
 *@Date: 2019/12/3
 *@Time:9:14
 *@Description:关注电影适配器
 **/
public class MyGuanZhuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CxgzdyBean.ResultBean> list;
    private Context context;

    public MyGuanZhuAdapter(List<CxgzdyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.movie_show_gz, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position).getImageUrl());
            ((MyViewHolder) holder).text_name.setText(list.get(position).getName());
            ((MyViewHolder) holder).text_address.setText("导演："+list.get(position).getDirector().trim());
            ((MyViewHolder) holder).textViewZY.setText("主演:"+list.get(position).getStarring());
            ((MyViewHolder) holder).textViewPF.setText("评分："+list.get(position).getScore()+"分");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView simpleDraweeView;
        private final TextView text_name;
        private final TextView text_address;
        private final TextView textViewZY;
        private final TextView textViewPF;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.image_more_gz);
            text_name=itemView.findViewById(R.id.text_show_more_gz);
            text_address=itemView.findViewById(R.id.text_show_2_more_gz);
            textViewZY = itemView.findViewById(R.id.text_show_3_more_gz);
            textViewPF = itemView.findViewById(R.id.text_show_4_more_gz);
        }
    }

}
