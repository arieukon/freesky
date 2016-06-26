package com.kulomady.freesky.view.fragment.app;

import com.kulomady.freesky.model.home.BannerModel;
import com.kulomady.freesky.model.home.MovieModel;
import com.kulomady.freesky.model.home.MusicModel;

import java.util.List;

/**
 * Created by Anshari Furqan on 6/25/2016.
 */
public interface AppFragmentPresenter {
    void loadApp();
    List<MusicModel> getAppDataList();
}
