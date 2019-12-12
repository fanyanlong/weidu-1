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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.ShowingBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URL;
import java.util.List;

import retrofit2.http.Url;

public class RecyclorHotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private List<HotBean.ResultBean>list;
    private Context context;

    public RecyclorHotAdapter(List<HotBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_hot, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof MyViewHolder){
                ((MyViewHolder) holder).textView.setText(list.get(position).getName());
                Uri uri = Uri.parse(list.get(position).getImageUrl());
                ((MyViewHolder) holder).imageView.setImageURI(uri);
                int movieId = list.get(position).getMovieId();
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClickCallBack.getMovieId(movieId);
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView imageView;
        private final TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_hot);
            textView=itemView.findViewById(R.id.text_hot);
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
