package com.kulomady.freesky.view.fragment.deal;

import android.content.Context;

import com.kulomady.freesky.model.home.MusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshari Furqan on 6/25/2016.
 */
public class DealFragmentPresenterImpl implements DealFragmentPresenter{

    Context mContext;
    DealFragmentView mView;

    public DealFragmentPresenterImpl(Context mContext, DealFragmentView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void loadDeal() {
        mView.displayDealData(getDealDataList());
    }

    @Override
    public List<MusicModel> getDealDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] titles = new String[]{
                "Beats Audio",
                "Navy Sweater",
                "iPhone SE",
                "Samsung Galaxy S7",
                "Yonex Voltric"
        };
        String[] artists = new String[]{
                "Rp 1.500.000",
                "Rp 245.000",
                "Rp 8.999.100",
                "Rp 9.000.000",
                "Rp 2.300.00"
        };
        String[] covers = new String[]{
                "http://tinyurl.com/hwspj46",
                "http://tinyurl.com/zd4epj6",
                "http://tinyurl.com/gmoxe2l",
                "http://tinyurl.com/gl32zdq",
                "http://tinyurl.com/hx69gjw"
        };

        for (int i = 0; i < artists.length; i++) {
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage(covers[i]);
            musicList.add(musicModel);
        }
        return musicList;
    }
}
