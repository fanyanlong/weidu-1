package com.bw.movie.adapter.xiangqing;
/*
 *@auther:李泽楷
 *@Date: 2019/11/20
 *@Time:16:36
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.IdTimeYingYuanBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class DateYYAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<IdTimeYingYuanBean.ResultBean>list;
    private Context context;

    public DateYYAdapter(List<IdTimeYingYuanBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.datayy_item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof MyViewHolder){
                ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position).getLogo());
                ((MyViewHolder) holder).text_name.setText(list.get(position).getName());
                ((MyViewHolder) holder).text_address.setText(list.get(position).getAddress());
                ((MyViewHolder) holder).textViewZY.setText("价格："+list.get(position).getPrice());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       itemClick.click(list.get(position).getCinemaId());
                    }
                });
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
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.date_logo);
            text_name=itemView.findViewById(R.id.date_name);
            text_address=itemView.findViewById(R.id.date_address);
            textViewZY = itemView.findViewById(R.id.date_price);

        }
    }

    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface ItemClick{
        void click(int cinemaId);
    }
}
