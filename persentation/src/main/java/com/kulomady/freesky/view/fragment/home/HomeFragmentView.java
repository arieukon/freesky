package com.kulomady.freesky.view.fragment.home;

import com.kulomady.freesky.model.home.BannerModel;
import com.kulomady.freesky.model.home.MovieModel;
import com.kulomady.freesky.model.home.MusicModel;

import java.util.List;

/**
 * Created by Anshari Furqan on 6/22/2016.
 */
public interface HomeFragmentView {
    void displayBannerData(List<BannerModel> bannerList);
    void displayDealData(List<MusicModel> dealList);
    void displayVideoData(List<MusicModel> videoList);
    void displayMovieData(List<MovieModel> movieList);
    void displayMusicData(List<MusicModel> musicList);
    void displayAppData(List<MusicModel> appList);

    void gotoPlayStore(String url);
}
