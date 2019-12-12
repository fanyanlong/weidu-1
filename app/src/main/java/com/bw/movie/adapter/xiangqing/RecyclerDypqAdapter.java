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
import com.bw.movie.bean.DypqBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerDypqAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DypqBean.ResultBean> list;
    private Context context;

    public RecyclerDypqAdapter(List<DypqBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_xuanzuo_dianyingpaiqi, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            String substring1 = list.get(position).getBeginTime().substring(0, 5);
            ((MyViewHolder) holder).textDypqStart.setText(substring1);
            String substring = list.get(position).getEndTime().substring(0, 5);
            ((MyViewHolder) holder).textDypqEnd.setText(substring);
            ((MyViewHolder) holder).textDypqName.setText(list.get(position).getScreeningHall());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick.setClick(list.get(position).getId(),list.get(position).getHallId(),list.get(position).getFare());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_dypq_name)
        TextView textDypqName;
        @BindView(R.id.text_dypq_start)
        TextView textDypqStart;
        @BindView(R.id.text_dypq_end)
        TextView textDypqEnd;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    private onClick onClick;
    public void getClick(onClick onClick){
        this.onClick=onClick;
    }
    public interface onClick{
        void setClick(int id,int hallId,double fare);
    }
}
