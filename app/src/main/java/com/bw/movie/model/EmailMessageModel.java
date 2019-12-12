package com.bw.movie.model;

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.EmailMessageBean;
import com.bw.movie.contract.EmailMessageContract;
import com.bw.movie.utils.RetrofitManager;

/**
 * @author: 李泽楷
 * @description:
 * @date :2019/12/3 20:56
 */
public class EmailMessageModel implements EmailMessageContract.IModel {
    @Override
    public void getEmailMessageData(String userId, String sessionId, String page, String count, EmailMessageContractCallBack emailMessageContractCallBack) {
        RetrofitManager.getInstance().create().EmailMessage(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<EmailMessageBean>() {
                    @Override
                    public void onNext(EmailMessageBean emailMessageBean) {
                      emailMessageContractCallBack.onEmailSuccess(emailMessageBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        emailMessageContractCallBack.onEmailFailure(e);
                    }
                });
    }


}
