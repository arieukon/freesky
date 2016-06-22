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
    public void loadMusic() {
        mView.displayMusicData(getMusicDataList());
    }

    @Override
    public void loadApp() {
        mView.displayAppData(getAppDataList());
    }

    @Override
    public List<MusicModel> getDealDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] titles = new String[]{
                "Beats Audio",
                "Navy Sweater",
                "iPhone SE",
                "Samsung Galaxy S7",
                "Yonex Voltric"
        };
        String[] artists = new String[]{
                "Rp 1.500.000",
                "Rp 245.000",
                "Rp 8.999.100",
                "Rp 9.000.000",
                "Rp 2.300.00"
        };
        String[] covers = new String[]{
                "http://tinyurl.com/hwspj46",
                "http://tinyurl.com/zd4epj6",
                "http://tinyurl.com/gmoxe2l",
                "http://tinyurl.com/gl32zdq",
                "http://tinyurl.com/hx69gjw"
        };

        for (int i = 0; i < artists.length; i++) {
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage(covers[i]);
            musicList.add(musicModel);
        }
        return musicList;
    }

    @Override
    public List<MusicModel> getVideoDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] artists = new String[]{
                "Raisa",
                "Taylor Swift",
                "Justin Bieber",
                "Linkin Park"};
        String[] titles = new String[]{
                "Mantan Terindah",
                "Wildest Dreams",
                "What Do You Mean",
                "Waiting for The End"};
        String[] covers = new String[]{
                "http://tinyurl.com/h26667n",
                "https://i.ytimg.com/vi/IdneKLhsWOQ/maxresdefault.jpg",
                "http://tinyurl.com/z2zxxfe",
                "http://tinyurl.com/zndb7ah"};

        for (int i = 0; i < artists.length; i++) {
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage(covers[i]);
            musicList.add(musicModel);
        }
        return musicList;
    }

    @Override
    public List<MusicModel> getMusicDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] titles = new String[]{
                "New Romantic",
                "Love is Not A Bad Things",
                "Kali Kedua",
                "When We Were Young",
                "Dangerous Woman"
        };
        String[] artists = new String[]{
                "Taylor Swift",
                "Michael Jacksons",
                "Ran",
                "Adele",
                "Ariana Grande"
        };
        String[] covers = new String[]{
                "http://tinyurl.com/huat3aw",
                "http://www.michaeljacksonsightings.com/resources/Xscpe.jpg",
                "https://rannersjakarta.files.wordpress.com/2014/11/gambar-ran-19.jpg",
                "http://104.131.185.116/wp-content/uploads/2011/03/rollinginthedeep.jpg",
                "http://static.spin.com/files/2015/10/ariana-grande-focus.jpg"
        };

        for (int i = 0; i < artists.length; i++) {
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage(covers[i]);
            musicList.add(musicModel);
        }
        return musicList;
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

        for (int i = 0; i < artists.length; i++) {
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage(logos[i]);
            musicList.add(musicModel);
        }
        return musicList;
    }
}
