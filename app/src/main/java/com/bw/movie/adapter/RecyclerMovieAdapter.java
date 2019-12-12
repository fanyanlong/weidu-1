package com.bw.movie.adapter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/14
 *@Time:20:56
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.GddyActivity;
import com.bw.movie.R;
import com.bw.movie.XiangqingActivity;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.ShowBean;
import com.bw.movie.bean.ShowingBean;
import com.bw.movie.bean.XbannerBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class RecyclerMovieAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    private static final String TAG = "RecyclerMovieAdapter";



    private List<Object> list;
    private Context context;

    public RecyclerMovieAdapter(List<Object> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else if (position == 1) {
            return 2;
        } else if (position == 2) {
            return 3;
        } else if (position == 3) {
            return 4;
        }
        return 0;

    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = View.inflate(context, R.layout.layout_movie_1, null);
            return new MyViewHolder(inflate);
        } else if (viewType == 2) {
            View inflate = View.inflate(context, R.layout.layout_movie_2, null);
            return new MyViewHolder2(inflate);
        } else if (viewType == 3) {
            View inflate = View.inflate(context, R.layout.layout_movie_3, null);
            return new MyViewHolder3(inflate);
        } else if (viewType == 4) {
            View inflate = View.inflate(context, R.layout.layout_movie_4, null);
            return new MyViewHolder4(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 1:
                if (holder instanceof MyViewHolder) {
                    XbannerBean bean = (XbannerBean) list.get(0);
                    List<String> xbannerList = new ArrayList<>();
                    for (int i = 0; i < bean.getResult().size(); i++) {
                        xbannerList.add(bean.getResult().get(i).getImageUrl());
                    }
                    ((MyViewHolder) holder).bean.setBannerData(R.layout.image_fresco, new AbstractList<SimpleBannerInfo>() {
                        @Override
                        public SimpleBannerInfo get(int i) {
                            return null;
                        }

                        @Override
                        public int size() {
                            return xbannerList.size();
                        }
                    });
                    ((MyViewHolder) holder).bean.loadImage(new XBanner.XBannerAdapter() {
                        @Override
                        public void loadBanner(XBanner banner, Object model, View view, int position) {
                            SimpleDraweeView simpleDraweeView = view.findViewById(R.id.my_image_view);
                            Uri uri = Uri.parse(xbannerList.get(position));
//                Log.i(TAG, "loadBanner: "+xbannerList.get(position));
                            simpleDraweeView.setImageURI(uri);
                            DraweeController controller = Fresco.newDraweeControllerBuilder()
                                    .setUri(uri)
                                    .setAutoPlayAnimations(true)
                                    .build();
                            simpleDraweeView.setController(controller);
                            simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String jumpUrl = bean.getResult().get(position).getJumpUrl();
                                    String[] split = jumpUrl.split("=");
                                    Intent intent = new Intent(context, XiangqingActivity.class);
                                    int id= Integer.parseInt(split[1]);
                                    intent.putExtra("movieId",id+"");
                                    context.startActivity(intent);
                                }
                            });
                        }
                    });


                }
                break;
            case 2:
                if (holder instanceof MyViewHolder2) {
                    ShowingBean bean = (ShowingBean) list.get(1);
                    Log.i(TAG, "onBindViewHolder: " + bean.getMessage());
                    List<ShowingBean.ResultBean> showingBeans = new ArrayList<>();
                    for (int i = 0; i < bean.getResult().size(); i++) {
                        showingBeans.add(bean.getResult().get(i));
                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                    RecyclorShowingAdapter recyclorShowingAdapter = new RecyclorShowingAdapter(showingBeans, context);
                    ((MyViewHolder2) holder).recyclerView.setLayoutManager(linearLayoutManager);
                    ((MyViewHolder2) holder).recyclerView.setAdapter(recyclorShowingAdapter);
                    recyclorShowingAdapter.getonClickCallBack(new RecyclorShowingAdapter.onClickCallBack() {
                        @Override
                        public void getMovieId(int id) {
                            Intent intent = new Intent(context, XiangqingActivity.class);
                            intent.putExtra("movieId", id + "");
                            context.startActivity(intent);
                        }
                    });
                    ((MyViewHolder2) holder).relativeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            context.startActivity(new Intent(context, GddyActivity.class));
                        }
                    });
                }
                break;
            case 3:
                if (holder instanceof MyViewHolder3) {
                    ShowBean bean = (ShowBean) list.get(2);
                    Log.i(TAG, "onBindViewHolder: " + bean.getMessage());
                    List<ShowBean.ResultBean> showList = new ArrayList<>();
                    for (int i = 0; i < bean.getResult().size(); i++) {
                        showList.add(bean.getResult().get(i));
                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    RecyclorShowAdapter recyclorShowingAdapter = new RecyclorShowAdapter(showList, context);
                    ((MyViewHolder3) holder).recyclerView.setLayoutManager(linearLayoutManager);
                    ((MyViewHolder3) holder).recyclerView.setAdapter(recyclorShowingAdapter);
                    recyclorShowingAdapter.getonClickCallBack(new RecyclorShowAdapter.onClickCallBack() {
                        @Override
                        public void getMovieId(int id) {
                            Intent intent = new Intent(context, XiangqingActivity.class);
                            intent.putExtra("movieId", id + "");
                            context.startActivity(intent);
                        }
                    });
                    ((MyViewHolder3) holder).relativeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            context.startActivity(new Intent(context, GddyActivity.class));

                        }
                    });
                }
                break;
            case 4:
                if (holder instanceof MyViewHolder4) {
                    HotBean bean = (HotBean) list.get(3);
                    Log.i(TAG, "onBindViewHolder: " + bean.getMessage());
                    List<HotBean.ResultBean> hotList = new ArrayList<>();
                    for (int i = 0; i < bean.getResult().size(); i++) {
                        hotList.add(bean.getResult().get(i));
                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                    RecyclorHotAdapter recyclorHotAdapter = new RecyclorHotAdapter(hotList, context);
                    ((MyViewHolder4) holder).recyclerView.setLayoutManager(linearLayoutManager);
                    ((MyViewHolder4) holder).recyclerView.setAdapter(recyclorHotAdapter);
                    recyclorHotAdapter.getonClickCallBack(new RecyclorHotAdapter.onClickCallBack() {
                        @Override
                        public void getMovieId(int id) {
                            Intent intent = new Intent(context, XiangqingActivity.class);
                            intent.putExtra("movieId", id + "");
                            context.startActivity(intent);
                        }
                    });
                    ((MyViewHolder4) holder).relativeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            context.startActivity(new Intent(context, GddyActivity.class));

                        }
                    });
                }
                break;
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends XRecyclerView.ViewHolder {
        private final XBanner bean;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bean = itemView.findViewById(R.id.xbander_movie);
            ButterKnife.bind(this, itemView);
        }
    }

    class MyViewHolder2 extends XRecyclerView.ViewHolder {
        private final RecyclerView recyclerView;
        private final RelativeLayout relativeLayout;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_movie_2);
            relativeLayout = itemView.findViewById(R.id.relat_zzry);
        }
    }

    class MyViewHolder3 extends XRecyclerView.ViewHolder {
        private final RecyclerView recyclerView;
        private final RelativeLayout relativeLayout;

        public MyViewHolder3(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_movie_3);
            relativeLayout = itemView.findViewById(R.id.relat_jjsy);

        }
    }

    class MyViewHolder4 extends XRecyclerView.ViewHolder {
        private final RecyclerView recyclerView;
        private final RelativeLayout relativeLayout;

        public MyViewHolder4(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_movie_4);
            relativeLayout = itemView.findViewById(R.id.relat_rmdy);

        }
    }

}
