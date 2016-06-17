package com.kulomady.freesky.view.activity.home;

import com.kulomady.freesky.model.home.MusicModel;
import com.kulomady.freesky.model.home.PaymentModel;

import java.util.List;

/**
 * Created by macaris on 6/16/16.
 */
public interface MainPresenter {
    void loadMusic();
    void loadMovie();
    void loadApp();
    void loadGame();
    void loadVideo();
    void loadPayment();

    List<MusicModel> getMusicData();
    List<MusicModel> getMovieData();
    List<MusicModel> getAppData();
    List<MusicModel> getGameData();
    List<MusicModel> getVideoData();
    List<PaymentModel> getPaymentData();
}
