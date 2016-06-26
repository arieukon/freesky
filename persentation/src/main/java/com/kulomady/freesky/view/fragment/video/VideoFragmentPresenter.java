package com.kulomady.freesky.view.fragment.video;

import com.kulomady.freesky.model.home.MusicModel;

import java.util.List;

/**
 * Created by Anshari Furqan on 6/25/2016.
 */
public interface VideoFragmentPresenter {
    void loadVideo();
    List<MusicModel> getVideoDataList();
}
