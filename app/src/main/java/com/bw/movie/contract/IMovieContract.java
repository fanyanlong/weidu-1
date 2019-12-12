package com.bw.movie.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/11/12
 *@Time:20:41
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.ShowBean;
import com.bw.movie.bean.ShowingBean;
import com.bw.movie.bean.XbannerBean;

import java.util.Map;

public interface IMovieContract {
    interface IMovieView extends IBaseView {
        void onXbannerSuccess(XbannerBean bean);
        void onShowingSuccess(ShowingBean bean);
        void onShowSuccess(ShowBean bean);
        void onHotSuccess(HotBean bean);
        void onFailure(Throwable e);
    }
    interface IMovieModel{
        void getXbannerData(IXbannerModelCallback iXbannerModelCallback) ;
        interface IXbannerModelCallback{
            void onXbannerSuccess(XbannerBean bean);
            void onFailure(Throwable e);

        }
        void getShowingData(String page,String count,IShowingModelCallback iShowingModelCallback);
        interface IShowingModelCallback{
            void onShowingSuccess(ShowingBean bean);
            void onFailure(Throwable e);

        }

        void getShowData(String page, String count, Map<String,String> map, IShowModelCallback iShowModelCallback);
        interface IShowModelCallback{
            void onShowSuccess(ShowBean bean);
            void onFailure(Throwable e);

        }

        void getHotData(String page,String count,IHotModelCallback iHotModelCallback);
        interface IHotModelCallback{
            void onHotSuccess(HotBean bean);
            void onFailure(Throwable e);

        }
    }
    interface IMoviePresenter{
        void getXbannerPresenter();
        void getShowingrPresenter(String page,String count);
        void getShowPresenter(String page, String count, Map<String,String> map);
        void getHotPresenter(String page,String count);
    }
}
