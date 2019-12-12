package com.bw.movie.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.EmailMessageBean;
import com.bw.movie.contract.EmailMessageContract;
import com.bw.movie.model.EmailMessageModel;

/**
 * @author: 李泽楷
 * @description:
 * @date :2019/12/3 20:58
 */
public class EmailMessagePresenter extends BasePresenter<EmailMessageContract.IView> implements EmailMessageContract.IPresenter {

    private EmailMessageModel emailMessageModel;

    @Override
    protected void initModel() {
        emailMessageModel = new EmailMessageModel();
    }

    @Override
    public void getEmailMessageData(String userId, String sessionId, String page, String count) {
        emailMessageModel.getEmailMessageData(userId, sessionId, page, count, new EmailMessageContract.IModel.EmailMessageContractCallBack() {
            @Override
            public void onEmailSuccess(EmailMessageBean bean) {
                getView().onEmailSuccess(bean);
            }



            @Override
            public void onEmailFailure(Throwable e) {
                getView().onEmailFailure(e);
            }
        });
    }

}
