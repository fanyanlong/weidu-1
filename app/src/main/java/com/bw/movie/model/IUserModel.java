package com.bw.movie.model;
/*
 *@auther:李泽楷
 *@Date: 2019/11/11
 *@Time:19:39
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.WxLogBean;
import com.bw.movie.contract.IUserContract;
import com.bw.movie.utils.RetrofitManager;

public class IUserModel implements IUserContract.IUserlModel {
    @Override
    public void getEmailData(String email, IEmailModelCallback iEmailModelCallback) {
        RetrofitManager.getInstance().create().getEmail(email)
                .compose(CommonSchedulers.<EmailBean>io2main())
                .subscribe(new CommonObserver<EmailBean>() {
                    @Override
                    public void onNext(EmailBean bean) {
                        iEmailModelCallback.onEmailSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iEmailModelCallback.onFailure(e);
                    }
                });

    }

    @Override
    public void getRegisterData(String nickName, String pwd, String email, String code, IRegisterModelCallback iRegisterModelCallback) {
            RetrofitManager.getInstance().create().getRegister(nickName, pwd, email, code)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new CommonObserver<RegisterBean>() {
                        @Override
                        public void onNext(RegisterBean bean) {
                            iRegisterModelCallback.onRegisterSuccess(bean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iRegisterModelCallback.onFailure(e);
                        }
                    });
    }

    @Override
    public void getLoginData(String email, String pwd, ILoginModelCallback iLoginModelCallback) {
                RetrofitManager.getInstance().create()
                        .getLogin(email, pwd)
                        .compose(CommonSchedulers.io2main())
                        .subscribe(new CommonObserver<LoginBean>() {
                            @Override
                            public void onNext(LoginBean bean) {
                                iLoginModelCallback.onLoginSuccess(bean);
                            }

                            @Override
                            public void onError(Throwable e) {
                                iLoginModelCallback.onFailure(e);
                            }
                        });
    }

    @Override
    public void getWxloginData(String code, IWxloginModelCallback iWxloginModelCallback) {
            RetrofitManager.getInstance().create().getWxlog(code).compose(CommonSchedulers.io2main())
                    .subscribe(new CommonObserver<WxLogBean>() {
                        @Override
                        public void onNext(WxLogBean wxLogBean) {
                            iWxloginModelCallback.onWxloginSuccess(wxLogBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iWxloginModelCallback.onWxloginFailure(e);
                        }
                    });
    }
}
