package com.kulomady.freesky.view.activity.home;

import com.kulomady.freesky.model.home.MusicModel;
import com.kulomady.freesky.model.home.PaymentModel;

import java.util.List;

/**
 * Created by macaris on 6/16/16.
 */
public interface MainView {
    void displayMusicData(List<MusicModel> musicList);
    void displayMovieData(List<MusicModel> movieList);
    void displayAppData(List<MusicModel> appList);
    void displayGameData(List<MusicModel> gameList);
    void displayVideoData(List<MusicModel> videoList);
    void displayPaymentData(List<PaymentModel> paymentList);
}
