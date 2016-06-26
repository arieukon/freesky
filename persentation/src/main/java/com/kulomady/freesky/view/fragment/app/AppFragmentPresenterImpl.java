package com.kulomady.freesky.view.fragment.app;

import android.content.Context;

import com.kulomady.freesky.model.home.MusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshari Furqan on 6/25/2016.
 */
public class AppFragmentPresenterImpl implements AppFragmentPresenter {
    Context mContext;
    AppFragmentView mView;

    public AppFragmentPresenterImpl(Context mContext, AppFragmentView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void loadApp() {
        mView.displayAppData(getAppDataList());
    }

    @Override
    public List<MusicModel> getAppDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] artists = new String[]{
                "Instagram",
                "Kaskus",
                "Blibli Commerce",
                "Twitter",
                "Path"};

        String[] titles = new String[]{
                "Instagram",
                "Kaskus",
                "Blibli Commerce",
                "Twitter",
                "Path"};

        String[] logos = new String[]{
                "http://tinyurl.com/zqzk2lq",
                "http://logodatabases.com/wp-content/uploads/2012/04/logo-kaskus.png",
                "https://icon.apkdot.com/blibli.mobile.commerce.png",
                "https://g.twimg.com/Twitter_logo_blue.png",
                "http://icons.iconarchive.com/icons/martz90/circle/512/path-icon.png"
        };

        String[] urls = new String[]{
                "https://play.google.com/store/apps/details?id=com.instagram.android&hl=en",
                "https://play.google.com/store/apps/details?id=com.kaskus.android&hl=en",
                "https://play.google.com/store/apps/details?id=blibli.mobile.commerce&hl=en",
                "https://play.google.com/store/apps/details?id=com.twitter.android&hl=en",
                "https://play.google.com/store/apps/details?id=com.path&hl=en"};

        for (int i = 0; i < artists.length; i++) {
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage(logos[i]);
            musicModel.setUrl(urls[i]);
            musicList.add(musicModel);
        }
        return musicList;
    }
}