package com.bw.movie.adapter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/13
 *@Time:8:39
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
import com.bw.movie.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RecyclorShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private List<ShowBean.ResultBean>list;
    private Context context;

    public RecyclorShowAdapter(List<ShowBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_show, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof MyViewHolder){
                ((MyViewHolder) holder).textView.setText(list.get(position).getName());
                Uri uri = Uri.parse(list.get(position).getImageUrl());
                ((MyViewHolder) holder).imageView.setImageURI(uri);
                ((MyViewHolder) holder).textView_2.setText("04月"+list.get(position).getWantSeeNum()+"日上映");
                int movieId = list.get(position).getMovieId();
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClickCallBack.getMovieId(movieId);
                    }
                });
                ((MyViewHolder) holder).textView_3.setText(list.get(position).getWantSeeNum()+"人想看");
            }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView imageView;
        private final TextView textView;
        private final TextView textView_2;
        private final TextView textView_3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_show);
            textView=itemView.findViewById(R.id.text_show);
            textView_2=itemView.findViewById(R.id.text_show_2);
            textView_3=itemView.findViewById(R.id.text_show_3);
        }
    }

    private onClickCallBack onClickCallBack;
    public void getonClickCallBack(onClickCallBack onClickCallBack){
        this.onClickCallBack=onClickCallBack;
    }
    public interface onClickCallBack{
        void getMovieId(int id);
    }
}
