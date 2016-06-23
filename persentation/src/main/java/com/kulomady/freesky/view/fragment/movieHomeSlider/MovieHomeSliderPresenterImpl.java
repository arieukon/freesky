package com.kulomady.freesky.view.fragment.movieHomeSlider;

import android.content.Context;

import com.google.gson.Gson;
import com.kulomady.freesky.model.home.MovieModel;

import java.util.List;

/**
 * Created by macaris on 6/23/16.
 */
public class MovieHomeSliderPresenterImpl implements MovieHomeSliderPresenter {
    Context mContext;
    MovieHomeSliderView mView;

    public MovieHomeSliderPresenterImpl(Context mContext, MovieHomeSliderView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void receiveMovieData(String movieDataJSON, int tabPosition) {
        MovieModel movieModel = new Gson().fromJson(movieDataJSON, MovieModel.class);
        mView.displayData(movieModel);
    }
}
