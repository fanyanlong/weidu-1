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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.XiangqingBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RecyclerDaoyanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<XiangqingBean.ResultBean.MovieDirectorBean>list;
        private Context context;

    public RecyclerDaoyanAdapter(List<XiangqingBean.ResultBean.MovieDirectorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = View.inflate(context, R.layout.layout_jieshao_daoyan, null);
            return new MyViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof MyViewHolder){
                ((MyViewHolder) holder).textView.setText(list.get(position).getName());
                ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position).getPhoto());
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
        class MyViewHolder extends RecyclerView.ViewHolder {
            private final SimpleDraweeView simpleDraweeView;
            private final TextView textView;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                simpleDraweeView=itemView.findViewById(R.id.simp_xiangqing_daoyan);
                textView=itemView.findViewById(R.id.text_xiangqing_daoyan);
            }
        }
}
