package com.kulomady.freesky.view.fragment.deal;

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
import com.kulomady.freesky.view.adapter.DealHomeAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DealFragment extends Fragment implements DealFragmentView {

    private Unbinder unbinder;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    DealFragmentPresenterImpl mPresenter;

    public DealFragment() {
        // Required empty public constructor
        mPresenter = new DealFragmentPresenterImpl(getActivity(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deal, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter.loadDeal();
        return view;
    }

    @Override
    public void displayDealData(List<MusicModel> dealList) {
        GridLayoutManager mGridLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        DealHomeAdapter adapter = new DealHomeAdapter(getContext(), dealList, false);
        mRecyclerView.setAdapter(adapter);
    }
}
