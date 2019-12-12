package com.bw.movie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.CxgzyyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/*
 *@auther:李泽楷
 *@Date: 2019/12/3
 *@Time:9:40
 *@Description:关注的影院适配器
 **/
public class MyYingYuanGuanZhuAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CxgzyyBean.ResultBean> list;
    private Context context;

    public MyYingYuanGuanZhuAdapter(List<CxgzyyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.yingyaun_show_gz, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position).getLogo());
            ((MyViewHolder) holder).text_name.setText(list.get(position).getName());
            ((MyViewHolder) holder).text_address.setText(list.get(position).getAddress());
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

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.image_more_gzyy);
            text_name=itemView.findViewById(R.id.text_show_more_gzyy);
            text_address=itemView.findViewById(R.id.text_show_2_more_gzyy);

        }
    }

}
