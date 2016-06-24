package com.kulomady.freesky.view.fragment.bannerHome;

import android.content.Context;

import com.google.gson.Gson;
import com.kulomady.freesky.R;
import com.kulomady.freesky.model.home.BannerModel;
import com.kulomady.freesky.model.home.MovieModel;
import com.squareup.picasso.Picasso;

/**
 * Created by macaris on 6/24/16.
 */
public class BannerHomePresenterImpl implements BannerHomePresenter {
    Context mContext;
    BannerHomeView mView;

    public BannerHomePresenterImpl(Context mContext, BannerHomeView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void receiveBannerData(String bannerDataJSON, int tabPosition) {
        BannerModel bannerModel = new Gson().fromJson(bannerDataJSON, BannerModel.class);
        mView.displayBannerData(bannerModel);
    }
}
