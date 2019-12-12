package com.bw.movie.adapter.xiangqing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.TimeBean;

import java.util.List;

/*
 *@auther:王晓义
 *@Date: 2019/11/12
 *@Time:20:10
 *@Description:${DESCRIPTION}
 **/
public class ZhouPaiqiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private TimeBean zhouPaiTimeBean;

    public ZhouPaiqiAdapter(Context context, TimeBean zhouPaiTimeBean) {
        this.context = context;
        this.zhouPaiTimeBean = zhouPaiTimeBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zhoupaiqi_adapter, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        List<String> result = zhouPaiTimeBean.getResult();
        if (viewHolder instanceof ViewHolder){
            ((ViewHolder) viewHolder).text_riqi.setText(result.get(i));
            ((ViewHolder) viewHolder).paititime_lin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClicks.onChangeData(result.get(i));
                }
            });
        }
    }



    @Override
    public int getItemCount() {
        return zhouPaiTimeBean.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_riqi;
        LinearLayout paititime_lin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_riqi = itemView.findViewById(R.id.text_riqi);
            paititime_lin = itemView.findViewById(R.id.paititime_lin);
        }
    }
    //接口回调
    onItemClicks onItemClicks;
    public void setOnItemClicks( onItemClicks onItemClicks){
        this.onItemClicks = onItemClicks;
    }
    public interface onItemClicks{
        void onChangeData(String p);
    }
}
