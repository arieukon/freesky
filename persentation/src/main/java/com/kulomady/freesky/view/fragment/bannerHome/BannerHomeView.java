package com.kulomady.freesky.view.fragment.bannerHome;

import com.kulomady.freesky.model.home.BannerModel;
import com.kulomady.freesky.model.home.MovieModel;

/**
 * Created by macaris on 6/24/16.
 */
public interface BannerHomeView {
    void displayBannerData(BannerModel bannerModel);
    void gotoWebPage(String url);
}
