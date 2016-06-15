package com.kulomady.freesky.view.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.kulomady.freesky.R;
import com.kulomady.freesky.model.home.MusicModel;
import com.kulomady.freesky.view.adapter.MusicHomeAdapter;
import com.kulomady.freesky.view.utils.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseDrawerActivity {

    private static final int ANIM_DURATION_TOOLBAR = 300;

    @BindView(R.id.content)
    CoordinatorLayout clContent;
    @BindView(R.id.recyclerview_music)
    RecyclerView mRecyclerViewMusic;

    private boolean pendingIntroAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            pendingIntroAnimation = true;
        }

        //Load music data
        loadMusic();
    }

    private void loadMusic() {
        RecyclerView.LayoutManager mLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewMusic.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewMusic.setLayoutManager(mLayoutManager);

        List<MusicModel> musicList = getMusicData();
        MusicHomeAdapter adapter = new MusicHomeAdapter(MainActivity.this, musicList);
        mRecyclerViewMusic.setAdapter(adapter);
    }

    private List<MusicModel> getMusicData(){
        List<MusicModel> musicList = new ArrayList();

        String[] artists = new String[] {"Raisa", "Tulus", "Yura", "Lee Yung Dae"};
        String[] titles = new String[] {"Mantan Terindah", "1001", "2048", "Mix Double"};

        for(int i=0; i<artists.length; i++){
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage("http://tinyurl.com/gwy8x55");
            musicList.add(musicModel);
        }

        return musicList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        if (pendingIntroAnimation) {
            pendingIntroAnimation = false;
            startIntroAnimation();
        }
        return true;
    }

    private void startIntroAnimation() {
        int actionbarSize = ViewUtils.dpToPx(56);
        if(getToolbar()!=null) {
            getToolbar().setTranslationY(-actionbarSize);

            if(getTokopediaLogoTextView()!=null) {
                getTokopediaLogoTextView().setTranslationY(-actionbarSize);
            }

            getToolbar().animate()
                    .translationY(0)
                    .setDuration(ANIM_DURATION_TOOLBAR)
                    .setStartDelay(300);
            getTokopediaLogoTextView().animate()
                    .translationY(0)
                    .setDuration(ANIM_DURATION_TOOLBAR)
                    .setStartDelay(400);
        }
    }

}
