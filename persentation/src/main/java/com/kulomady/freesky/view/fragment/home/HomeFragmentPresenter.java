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
<<<<<<< HEAD
    void loadMovie();
=======
>>>>>>> d649156e154ed356ac910aa5669903ce59d09f1a
    void loadMusic();
    void loadApp();

    List<BannerModel> getBannerDataList();
    List<MusicModel> getDealDataList();
    List<MusicModel> getVideoDataList();
<<<<<<< HEAD
    List<MovieModel> getMovieDataList();
=======
>>>>>>> d649156e154ed356ac910aa5669903ce59d09f1a
    List<MusicModel> getMusicDataList();
    List<MusicModel> getAppDataList();
}
