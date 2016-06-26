package com.kulomady.freesky.view.fragment.app;

import com.kulomady.freesky.model.home.MusicModel;

import java.util.List;

/**
 * Created by Anshari Furqan on 6/25/2016.
 */
public interface AppFragmentView {
    void displayAppData(List<MusicModel> appList);
    void gotoPlayStore(String url);
}
