package com.bw.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.GpjlBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/11/29
 *@Time:16:30
 *@Description:以付款是适配器、
 **/
public class MyRecyAdapterO extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GpjlBean.ResultBean> list;
    private Context context;

    public MyRecyAdapterO(List<GpjlBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_o, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            ((MyHolder)holder).img.setImageURI(list.get(position).getImageUrl()+"");
            ((MyHolder)holder).name.setText(list.get(position).getMovieName());
            ((MyHolder)holder).orderId.setText("订 单 号 "+list.get(position).getOrderId()+"");
            Date date = new Date(list.get(position).getCreateTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            ((MyHolder)holder).time.setText("付款时间 "+simpleDateFormat.format(date));
            ((MyHolder)holder).xiang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onclick(list.get(position).getOrderId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView img;
        private TextView name,orderId,time,xiang;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
            orderId=itemView.findViewById(R.id.orderId);
            time=itemView.findViewById(R.id.time);
            xiang=itemView.findViewById(R.id.xiang);
        }
    }

    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onclick(String orderId);
    }
}
