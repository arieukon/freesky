package com.kulomady.freesky.view.activity.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/**
 * Created by macaris on 6/20/16.
 */
public class SplashPresenterImpl implements SplashPresenter {
    Context mContext;
    SplashView mView;

    final int LOADING_DURATION = 3000;

    public SplashPresenterImpl(Context mContext, SplashView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void loadingSplash() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.gotoLogin();
            }
        }, LOADING_DURATION);
    }
}
