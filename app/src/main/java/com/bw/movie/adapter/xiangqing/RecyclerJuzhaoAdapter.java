package com.bw.movie.adapter.xiangqing;
/*
 *@auther:李泽楷
 *@Date: 2019/11/18
 *@Time:20:20
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.XiangqingBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class RecyclerJuzhaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<String>list;
        private Context context;

    public RecyclerJuzhaoAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = View.inflate(context, R.layout.layout_xiangqing_jz, null);
            return new MyViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof MyViewHolder){

                ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
        class MyViewHolder extends RecyclerView.ViewHolder {
            private final SimpleDraweeView simpleDraweeView;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                simpleDraweeView=itemView.findViewById(R.id.simp_xiangqing_jz);
            }
        }
}
