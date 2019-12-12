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

public class RecyclerGpTimeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<IdTimeYingYuanBean.ResultBean>list;
    private Context context;

    public RecyclerGpTimeAdapter(List<IdTimeYingYuanBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_gy_yy, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof MyViewHolder){
                ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position).getLogo());
                ((MyViewHolder) holder).text_name.setText(list.get(position).getName());
                ((MyViewHolder) holder).text_address.setText(list.get(position).getAddress());
                ((MyViewHolder) holder).text_price.setText(list.get(position).getPrice()+"元");
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClickId.getClickId(list.get(position).getCinemaId());
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
        private final TextView text_price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.simp_gy);
            text_name=itemView.findViewById(R.id.text_gy_name);
            text_address=itemView.findViewById(R.id.text_gy_address);
            text_price=itemView.findViewById(R.id.text_gy_price);
        }
    }
    public onClickId onClickId;
    public void setClickId(onClickId clickId){
        this.onClickId=clickId;
    }
   public interface onClickId{
        void getClickId(int id);
    }
}
