package com.kulomady.freesky.view.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kulomady.freesky.R;
import com.kulomady.freesky.model.home.BannerModel;
import com.kulomady.freesky.model.home.MovieModel;
import com.kulomady.freesky.model.home.MusicModel;
import com.kulomady.freesky.view.adapter.AppHomeAdapter;
import com.kulomady.freesky.view.adapter.DealHomeAdapter;
import com.kulomady.freesky.view.adapter.HomePagerAdapter;
import com.kulomady.freesky.view.adapter.MusicHomeAdapter;
import com.kulomady.freesky.view.adapter.VideoHomeAdapter;
import com.kulomady.freesky.view.fragment.bannerHome.BannerHomeFragment;
import com.kulomady.freesky.view.fragment.movieHomeSlider.MovieHomeSliderFragment;
import com.kulomady.freesky.view.utils.viewpagerIndicator.CirclePageIndicator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeFragmentView {

    private Unbinder unbinder;

    public static final String KEY_BANNER_DATA = "BANNER_DATA";
    public static final String KEY_MOVIE_DATA = "MOVIE_DATA";
    public static final String KEY_TAB_POSITION = "TAB_POSITION";

    @BindView(R.id.viewpager_banner)
    ViewPager mViewPagerBanner;
    @BindView(R.id.recyclerview_deal)
    RecyclerView mRecyclerViewDeal;
    @BindView(R.id.recyclerview_video)
    RecyclerView mRecyclerViewVideo;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.recyclerview_music)
    RecyclerView mRecyclerViewMusic;
    @BindView(R.id.recyclerview_app)
    RecyclerView mRecyclerViewApp;

    CirclePageIndicator mPagerIndicator;

    HomeFragmentPresenterImpl mPresenter;

    public HomeFragment() {
        // Required empty public constructor
        mPresenter = new HomeFragmentPresenterImpl(getContext(), this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        mPresenter.loadBanner();
        mPresenter.loadDeal();
        mPresenter.loadVideo();
        mPresenter.loadMovie();
        mPresenter.loadMusic();
        mPresenter.loadApp();
        return view;
    }

    @Override
    public void displayBannerData(List<BannerModel> bannerList) {
        HomePagerAdapter adapter = new HomePagerAdapter(getChildFragmentManager());
        Fragment fragment;
        Bundle bundle;

        if (bannerList.size() > 0) {
            int tabPosition = 0;
            for (BannerModel banner: bannerList) {
                String bannerDataJSON = new Gson().toJson(bannerList.get(tabPosition));
                //Setup Tab Title
                fragment = new BannerHomeFragment();
                bundle = new Bundle();
                bundle.putString(KEY_BANNER_DATA, bannerDataJSON);
                bundle.putInt(KEY_TAB_POSITION, tabPosition);
                fragment.setArguments(bundle);
                adapter.addFragment(fragment, "");
                tabPosition++;
            }

            //SetFragment to View Pager Adapter
            mViewPagerBanner.setAdapter(adapter);
        }
    }

    @Override
    public void displayDealData(List<MusicModel> dealList) {
        RecyclerView.LayoutManager mLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewDeal.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewDeal.setLayoutManager(mLayoutManager);

        DealHomeAdapter adapter = new DealHomeAdapter(getContext(), dealList);
        mRecyclerViewDeal.setAdapter(adapter);
    }

    @Override
    public void displayVideoData(List<MusicModel> videoList) {
        GridLayoutManager mGridLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewVideo.setHasFixedSize(true);

        // use a linear layout manager
        mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerViewVideo.setLayoutManager(mGridLayoutManager);

        VideoHomeAdapter adapter = new VideoHomeAdapter(getContext(), videoList);
        mRecyclerViewVideo.setAdapter(adapter);
    }

    @Override
    public void displayMovieData(List<MovieModel> movieList) {
        HomePagerAdapter adapter = new HomePagerAdapter(getChildFragmentManager());
        Fragment fragment;
        Bundle bundle;

        if (movieList.size() > 0) {
            int tabPosition = 0;
            for (MovieModel movie: movieList) {
                String movieDataJSON = new Gson().toJson(movieList.get(tabPosition));
                //Setup Tab Title
                fragment = new MovieHomeSliderFragment();
                bundle = new Bundle();
                bundle.putString(KEY_MOVIE_DATA, movieDataJSON);
                bundle.putInt(KEY_TAB_POSITION, tabPosition);
                fragment.setArguments(bundle);
                adapter.addFragment(fragment, movie.getTitle());
                tabPosition++;
            }

            //SetFragment to View Pager Adapter
            mViewPager.setAdapter(adapter);
        //    mPagerIndicator.setViewPager(mViewPager);
        }
    }

    @Override
    public void displayMusicData(List<MusicModel> musicList) {
        RecyclerView.LayoutManager mLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewMusic.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerViewMusic.setLayoutManager(mLayoutManager);

        MusicHomeAdapter adapter = new MusicHomeAdapter(getContext(), musicList);
        mRecyclerViewMusic.setAdapter(adapter);
    }

    @Override
    public void displayAppData(List<MusicModel> appList) {
        RecyclerView.LayoutManager mLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewApp.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewApp.setLayoutManager(mLayoutManager);

        AppHomeAdapter adapter = new AppHomeAdapter(getContext(), appList);
        mRecyclerViewApp.setAdapter(adapter);
    }
}
