package com.kulomady.freesky.view.fragment.home;

import com.kulomady.freesky.model.home.BannerModel;
import com.kulomady.freesky.model.home.MovieModel;
import com.kulomady.freesky.model.home.MusicModel;

import java.util.List;

/**
 * Created by Anshari Furqan on 6/22/2016.
 */
public interface HomeFragmentPresenter {
    void loadBanner();
    void loadDeal();
    void loadVideo();
    void loadMovie();
    void loadMusic();
    void loadApp();

    List<BannerModel> getBannerDataList();
    List<MusicModel> getDealDataList();
    List<MusicModel> getVideoDataList();
    List<MovieModel> getMovieDataList();
    List<MusicModel> getMusicDataList();
    List<MusicModel> getAppDataList();
}
