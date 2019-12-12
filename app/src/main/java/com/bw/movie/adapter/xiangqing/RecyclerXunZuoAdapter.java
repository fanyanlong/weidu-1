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
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.XuanZuoBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerXunZuoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private List<XuanZuoBean.ResultBean> list;
    private Context context;

    public RecyclerXunZuoAdapter(List<XuanZuoBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        int status = list.get(position).getStatus();
        if (status == 2) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = View.inflate(context, R.layout.layout_xuanzuo_chebox2, null);
            return new MyViewHolder2(inflate);
        } else {
            View inflate = View.inflate(context, R.layout.layout_xuanzuo_chebox, null);
            return new MyViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 1) {
            if (holder instanceof MyViewHolder2) {

            }
        }
        if (itemViewType == 2){

        if (holder instanceof MyViewHolder) {
                ((MyViewHolder) holder).checkboxXuanzuo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        list.get(position).setCheck(b);
                        check.setCheck();
                        if (b){
                          String seat=  list.get(position).getRow()+"-"+list.get(position).getSeat();
                            onBoolean.setBoolean(b,seat);
                        }else {
                            String seat=  list.get(position).getRow()+"-"+list.get(position).getSeat();
                            onBoolean.setBoolean(b,seat);
                        }
                    }
                });
        }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.checkbox_xuanzuo)
        CheckBox checkboxXuanzuo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.image_xuanzuo)
        CheckBox imageXuanzuo;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public onCheck check;
    public void getoncheck(onCheck onCheck){
        this.check=onCheck;
    }
    public interface onCheck{
        void setCheck();
    }
    public onBoolean onBoolean;
    public void getBoolean(onBoolean onBoolean){
        this.onBoolean=onBoolean;
    }
    public interface onBoolean{
        void setBoolean(boolean b,String seat);
    }
}
