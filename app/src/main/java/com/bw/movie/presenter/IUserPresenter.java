package com.bw.movie.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/11/11
 *@Time:19:41
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.WxLogBean;
import com.bw.movie.contract.IUserContract;
import com.bw.movie.model.IUserModel;

public class IUserPresenter extends BasePresenter<IUserContract.IUserlView> implements IUserContract.IUserPresenter {

    private IUserModel iUserModel;

    @Override
    protected void initModel() {
        iUserModel = new IUserModel();
    }

    @Override
    public void getEmailPresenter(String email) {
        iUserModel.getEmailData(email, new IUserContract.IUserlModel.IEmailModelCallback() {
            @Override
            public void onEmailSuccess(EmailBean bean) {
                getView().onEmailSuccess(bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getRegisterPresenter(String nickName, String pwd, String email, String code) {
            iUserModel.getRegisterData(nickName, pwd, email, code, new IUserContract.IUserlModel.IRegisterModelCallback() {
                @Override
                public void onRegisterSuccess(RegisterBean bean) {
                    getView().onRegisterSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getLoginPresenter(String email, String pwd) {
            iUserModel.getLoginData(email, pwd, new IUserContract.IUserlModel.ILoginModelCallback() {
                @Override
                public void onLoginSuccess(LoginBean bean) {
                    getView().onLoginSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getWxloginPresenter(String code) {
        iUserModel.getWxloginData(code, new IUserContract.IUserlModel.IWxloginModelCallback() {
            @Override
            public void onWxloginSuccess(WxLogBean bean) {
                getView().onWxloginSuccess(bean);
            }

            @Override
            public void onWxloginFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }
}
