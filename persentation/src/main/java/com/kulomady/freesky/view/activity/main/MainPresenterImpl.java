package com.kulomady.freesky.view.activity.main;

import android.content.Context;

import com.kulomady.freesky.model.home.MusicModel;
import com.kulomady.freesky.model.home.PaymentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macaris on 6/16/16.
 */
public class MainPresenterImpl implements MainPresenter {
    Context mContext;
    MainView mMainView;

    public MainPresenterImpl(Context mContext, MainView mMainView) {
        this.mContext = mContext;
        this.mMainView = mMainView;

        loadMusic();
        loadMovie();
        loadApp();
        loadGame();
        loadVideo();
        loadPayment();
    }

    @Override
    public void loadMusic() {
        mMainView.displayMusicData(getMusicData());
    }

    @Override
    public void loadMovie() {
        mMainView.displayMovieData(getAppData());
    }

    @Override
    public void loadApp() {
        mMainView.displayAppData(getAppData());
    }

    @Override
    public void loadGame() {
        mMainView.displayGameData(getGameData());
    }

    @Override
    public void loadVideo() {
        mMainView.displayVideoData(getVideoData());
    }

    @Override
    public void loadPayment() {
        mMainView.displayPaymentData(getPaymentData());
    }

    @Override
    public List<MusicModel> getMusicData() {
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
    public List<MusicModel> getMovieData() {
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
    public List<MusicModel> getAppData() {
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
    public List<MusicModel> getGameData() {
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
    public List<MusicModel> getVideoData() {
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
    public List<PaymentModel> getPaymentData() {
        List<PaymentModel> paymentList = new ArrayList();

        String[] names = new String[] {"DOKU", "Sakuku", "PayPal", "BCAKlik", "VISA", "MasterCard", "GoPay", "GrabPay" , "Apple Pay"};

        for(int i=0; i<names.length; i++){
            PaymentModel paymentModel = new PaymentModel();
            paymentModel.setPaymentName(names[i]);
            paymentModel.setLogo("http://tinyurl.com/jameywy");
            paymentModel.setBackgroundColor("569966");
            paymentList.add(paymentModel);
        }
        return paymentList;
    }
}
