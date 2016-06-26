package com.kulomady.freesky.view.fragment.video;

import android.content.Context;

import com.kulomady.freesky.model.home.MusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshari Furqan on 6/25/2016.
 */
public class VideoFragmentPresenterImpl implements VideoFragmentPresenter {
    Context mContext;
    VideoFragmentView mView;

    public VideoFragmentPresenterImpl(Context mContext, VideoFragmentView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }


    @Override
    public void loadVideo() {
        mView.displayVideoData(getVideoDataList());
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

}
