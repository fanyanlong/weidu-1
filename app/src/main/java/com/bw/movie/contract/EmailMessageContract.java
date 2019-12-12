package com.bw.movie.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.bw.movie.bean.EmailMessageBean;

/**
 * @author: 李泽楷
 * @description:
 * @date :2019/12/3 20:52
 */
public interface EmailMessageContract {
    interface IView extends IBaseView{
        void onEmailSuccess(EmailMessageBean bean);
        void onEmailFailure(Throwable e);
    }

    interface IModel{
        void getEmailMessageData(String userId, String sessionId, String page, String count, EmailMessageContractCallBack emailMessageContractCallBack);
        interface EmailMessageContractCallBack{
            void onEmailSuccess(EmailMessageBean bean);
            void onEmailFailure(Throwable e);
        }
    }

    interface IPresenter{
        void getEmailMessageData(String userId, String sessionId, String page, String count);
    }
}
