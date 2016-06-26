package com.kulomady.freesky.view.fragment.app;

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
import com.kulomady.freesky.view.adapter.AppHomeAdapter;
import com.kulomady.freesky.view.adapter.DealHomeAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppFragment extends Fragment implements AppFragmentView {

    private Unbinder unbinder;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    AppFragmentPresenterImpl mPresenter;

    public AppFragment() {
        // Required empty public constructor
        mPresenter = new AppFragmentPresenterImpl(getActivity(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_app, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter.loadApp();
        return view;
    }

    @Override
    public void displayAppData(final List<MusicModel> appList) {
        GridLayoutManager mGridLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        AppHomeAdapter adapter = new AppHomeAdapter(getContext(), appList, false);
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new AppHomeAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                String url = appList.get(position).getUrl();
                gotoPlayStore(url);
            }
        });
    }

    @Override
    public void gotoPlayStore(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
