package com.bw.movie.adapter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/14
 *@Time:20:24
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.TjyyBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class RecycloerTjyyAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    private List<TjyyBean.ResultBean>list;
    private Context context;

    public RecycloerTjyyAdapter(List<TjyyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_tj_fj, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder holder, int position) {
            if (holder instanceof MyViewHolder){
                ((MyViewHolder) holder).textView.setText(list.get(position).getName());
                ((MyViewHolder) holder).textView2.setText(list.get(position).getAddress());
                Uri uri=Uri.parse(list.get(position).getLogo());
                ((MyViewHolder) holder).imageView.setImageURI(uri);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClick.setClick(list.get(position).getId());
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView textView2;
        private final SimpleDraweeView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text_tj_name);
            textView2=itemView.findViewById(R.id.text_tj_address);
            imageView=itemView.findViewById(R.id.image_tj_logo);
        }
    }
    private onClick onClick;
    public void getClick(onClick onClick){
        this.onClick=onClick;
    }
    public interface onClick{
        void setClick(int id);
    }
}
