package com.kulomady.freesky.view.fragment.home;

import com.kulomady.freesky.model.home.MusicModel;

import java.util.List;

/**
 * Created by Anshari Furqan on 6/22/2016.
 */
public interface HomeFragmentView {
    void displayDealData(List<MusicModel> dealList);
    void displayVideoData(List<MusicModel> videoList);
    void displayMusicData(List<MusicModel> musicList);
    void displayAppData(List<MusicModel> appList);
}
