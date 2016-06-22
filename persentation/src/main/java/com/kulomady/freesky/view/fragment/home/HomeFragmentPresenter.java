package com.kulomady.freesky.view.fragment.home;

import com.kulomady.freesky.model.home.MusicModel;

import java.util.List;

/**
 * Created by Anshari Furqan on 6/22/2016.
 */
public interface HomeFragmentPresenter {
    void loadDeal();
    void loadVideo();
    void loadMusic();
    void loadApp();
    List<MusicModel> getDealDataList();
    List<MusicModel> getVideoDataList();
    List<MusicModel> getMusicDataList();
    List<MusicModel> getAppDataList();
}
