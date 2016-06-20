package com.kulomady.freesky.view.activity.home;

import android.content.Context;

/**
 * Created by macaris on 6/20/16.
 */
public class HomePresenterImpl {
    Context mContext;
    HomeView mView;

    public HomePresenterImpl(Context mContext, HomeView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }
}
