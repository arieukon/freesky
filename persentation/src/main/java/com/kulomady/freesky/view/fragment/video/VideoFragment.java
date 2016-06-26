package com.kulomady.freesky.view.fragment.video;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kulomady.freesky.R;
import com.kulomady.freesky.model.home.MusicModel;
import com.kulomady.freesky.view.adapter.VideoHomeAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements VideoFragmentView {

    private Unbinder unbinder;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    VideoFragmentPresenterImpl mPresenter;

    public VideoFragment() {
        // Required empty public constructor
        mPresenter = new VideoFragmentPresenterImpl(getActivity(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_video, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter.loadVideo();
        return view;
    }

    @Override
    public void displayVideoData(List<MusicModel> videoList) {
        GridLayoutManager mGridLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        VideoHomeAdapter adapter = new VideoHomeAdapter(getContext(), videoList);
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new VideoHomeAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                gotoWebView();
            }
        });
    }

    @Override
    public void gotoWebView() {
        String url = "https://www.youtube.com/watch?v=uo35R9zQsAI";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        getActivity().startActivity(browserIntent);
    }
}
