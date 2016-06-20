package com.kulomady.freesky.view.activity.login;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by macaris on 6/20/16.
 */
public class LoginPresenterImpl implements LoginPresenter{
    Context mContext;
    LoginView mView;

    public LoginPresenterImpl(Context mContext, LoginView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void processLogin(String number) {
        if(number.trim().length() > 0){
            mView.gotoVideoPage();
        } else {
            Toast.makeText(mContext, "Mobile number is required!", Toast.LENGTH_LONG).show();
        }
    }
}
