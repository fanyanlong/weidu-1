package com.bw.movie.adapter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/13
 *@Time:17:02
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.RegionBean;

import java.util.List;

public class RecyclerRegionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<RegionBean.ResultBean>list;
    Context context;

    public RecyclerRegionAdapter(List<RegionBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_cinema_region2, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            ((MyViewHolder) holder).text_1.setText(list.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getOnClick.getClick(list.get(position).getId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView text_1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_1=itemView.findViewById(R.id.text_region_1);
        }
    }
    public getOnClick getOnClick;
    public void setGetOnClick(getOnClick getOnClick){
        this.getOnClick=getOnClick;
    }
    public interface getOnClick{
        void getClick(int i);
    }
}
