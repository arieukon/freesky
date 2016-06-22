package com.kulomady.freesky.view.fragment.home;

import android.content.Context;

import com.kulomady.freesky.model.home.MusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshari Furqan on 6/22/2016.
 */
public class HomeFragmentPresenterImpl implements HomeFragmentPresenter {
    Context mContext;
    HomeFragmentView mView;

    public HomeFragmentPresenterImpl(Context mContext, HomeFragmentView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void loadDeal() {
        mView.displayDealData(getDealDataList());
    }

    @Override
    public void loadVideo() {
        mView.displayVideoData(getVideoDataList());
    }

    @Override
    public void loadApp() {
        mView.displayAppData(getAppDataList());
    }

    @Override
    public List<MusicModel> getDealDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] artists = new String[] {"Raisa", "Tulus", "Yura", "Lee Yung Dae"};
        String[] titles = new String[] {"Mantan Terindah", "1001", "2048", "Mix Double"};

        for(int i=0; i<artists.length; i++){
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage("http://tinyurl.com/gwy8x55");
            musicList.add(musicModel);
        }
        return musicList;
    }

    @Override
    public List<MusicModel> getVideoDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] artists = new String[] {"Raisa", "Tulus", "Yura", "Lee Yung Dae"};
        String[] titles = new String[] {"Mantan Terindah", "1001", "2048", "Mix Double"};

        for(int i=0; i<artists.length; i++){
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage("http://tinyurl.com/gwy8x55");
            musicList.add(musicModel);
        }
        return musicList;
    }

    @Override
    public List<MusicModel> getAppDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] artists = new String[] {
                "Instagram",
                "Kaskus",
                "Blibli Commerce",
                "Twitter",
                "Path"};

        String[] titles = new String[] {
                "Instagram",
                "Kaskus",
                "Blibli Commerce",
                "Twitter",
                "Path"};

        String[] logos = new String[] {
                "http://tinyurl.com/zqzk2lq",
                "http://logodatabases.com/wp-content/uploads/2012/04/logo-kaskus.png",
                "https://icon.apkdot.com/blibli.mobile.commerce.png",
                "https://g.twimg.com/Twitter_logo_blue.png",
                "http://icons.iconarchive.com/icons/martz90/circle/512/path-icon.png"
        };

        for(int i=0; i<artists.length; i++){
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage(logos[i]);
            musicList.add(musicModel);
        }
        return musicList;
    }
}
