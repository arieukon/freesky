package com.kulomady.freesky.view.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kulomady.freesky.R;
import com.kulomady.freesky.model.home.MusicModel;
import com.kulomady.freesky.view.adapter.AppHomeAdapter;
import com.kulomady.freesky.view.adapter.DealHomeAdapter;
import com.kulomady.freesky.view.adapter.MusicHomeAdapter;
import com.kulomady.freesky.view.adapter.VideoHomeAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeFragmentView {

    private Unbinder unbinder;

    @BindView(R.id.recyclerview_deal)
    RecyclerView mRecyclerViewDeal;
    @BindView(R.id.recyclerview_video)
    RecyclerView mRecyclerViewVideo;
    @BindView(R.id.recyclerview_music)
    RecyclerView mRecyclerViewMusic;
    @BindView(R.id.recyclerview_app)
    RecyclerView mRecyclerViewApp;

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
        mPresenter.loadDeal();
        mPresenter.loadVideo();
        mPresenter.loadMusic();
        mPresenter.loadApp();
        return view;
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
