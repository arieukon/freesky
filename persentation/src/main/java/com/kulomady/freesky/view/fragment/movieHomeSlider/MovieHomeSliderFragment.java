package com.kulomady.freesky.view.fragment.movieHomeSlider;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kulomady.freesky.R;
import com.kulomady.freesky.model.home.MovieModel;
import com.kulomady.freesky.view.fragment.home.HomeFragment;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieHomeSliderFragment extends Fragment implements MovieHomeSliderView{

    private Unbinder unbinder;

    @BindView(R.id.img_cover)
    ImageView mImgCover;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_price)
    TextView mTvPrice;
    @BindView(R.id.tv_synopsis)
    TextView mTvSynopsis;

    MovieHomeSliderPresenterImpl mPresenter;

    public MovieHomeSliderFragment() {
        // Required empty public constructor
        mPresenter = new MovieHomeSliderPresenterImpl(getActivity(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_movie_home_slider, container, false);
        unbinder = ButterKnife.bind(this, view);

        String movieDataJSON = getArguments().getString(HomeFragment.KEY_MOVIE_DATA);
        int tabPosition = getArguments().getInt(HomeFragment.KEY_TAB_POSITION);
        if ((movieDataJSON != null) && (!movieDataJSON.equals(""))) {
            mPresenter.receiveMovieData(movieDataJSON, tabPosition);
        }

        return view;
    }

    @Override
    public void displayData(MovieModel movieModel) {

        Picasso.with(getActivity())
                .load(movieModel.getCover())
                .placeholder(R.drawable.bg_white)
                .error(R.mipmap.ic_launcher)
                .into(mImgCover);

        mTvTitle.setText(movieModel.getTitle());
        mTvPrice.setText(movieModel.getPrice());
        mTvSynopsis.setText(movieModel.getSynopsis());


    }
}
