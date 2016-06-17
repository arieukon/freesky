package com.kulomady.freesky.view.activity.home;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.kulomady.freesky.R;
import com.kulomady.freesky.model.home.MusicModel;
import com.kulomady.freesky.model.home.PaymentModel;
import com.kulomady.freesky.view.activity.BaseDrawerActivity;
import com.kulomady.freesky.view.adapter.MusicHomeAdapter;
import com.kulomady.freesky.view.adapter.PaymentHomeAdapter;
import com.kulomady.freesky.view.utils.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseDrawerActivity implements MainView {

    private static final int ANIM_DURATION_TOOLBAR = 300;

    @BindView(R.id.content)
    CoordinatorLayout clContent;
    @BindView(R.id.recyclerview_music)
    RecyclerView mRecyclerViewMusic;
    @BindView(R.id.recyclerview_movie)
    RecyclerView mRecyclerViewMovie;
    @BindView(R.id.recyclerview_app)
    RecyclerView mRecyclerViewApp;
    @BindView(R.id.recyclerview_game)
    RecyclerView mRecyclerViewGame;
    @BindView(R.id.recyclerview_video)
    RecyclerView mRecyclerViewVideo;
    @BindView(R.id.recyclerview_payment)
    RecyclerView mRecyclerViewPayment;

    private boolean pendingIntroAnimation;

    MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl(this, this);

        if (savedInstanceState == null) {
            pendingIntroAnimation = true;
        }
    }

    @Override
    public void displayMusicData(List<MusicModel> musicList) {
        RecyclerView.LayoutManager mLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewMusic.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewMusic.setLayoutManager(mLayoutManager);

        MusicHomeAdapter adapter = new MusicHomeAdapter(MainActivity.this, musicList);
        mRecyclerViewMusic.setAdapter(adapter);
    }

    @Override
    public void displayMovieData(List<MusicModel> movieList) {
        RecyclerView.LayoutManager mLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewMovie.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewMovie.setLayoutManager(mLayoutManager);

        MusicHomeAdapter adapter = new MusicHomeAdapter(MainActivity.this, movieList);
        mRecyclerViewMovie.setAdapter(adapter);
    }

    @Override
    public void displayAppData(List<MusicModel> appList) {
        RecyclerView.LayoutManager mLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewApp.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewApp.setLayoutManager(mLayoutManager);

        MusicHomeAdapter adapter = new MusicHomeAdapter(MainActivity.this, appList);
        mRecyclerViewApp.setAdapter(adapter);
    }

    @Override
    public void displayGameData(List<MusicModel> gameList) {
        RecyclerView.LayoutManager mLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewGame.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewGame.setLayoutManager(mLayoutManager);

        MusicHomeAdapter adapter = new MusicHomeAdapter(MainActivity.this, gameList);
        mRecyclerViewGame.setAdapter(adapter);
    }

    @Override
    public void displayVideoData(List<MusicModel> videoList) {
        RecyclerView.LayoutManager mLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewVideo.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewVideo.setLayoutManager(mLayoutManager);

        MusicHomeAdapter adapter = new MusicHomeAdapter(MainActivity.this, videoList);
        mRecyclerViewVideo.setAdapter(adapter);
    }

    @Override
    public void displayPaymentData(List<PaymentModel> paymentList) {
        GridLayoutManager mGridLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewPayment.setHasFixedSize(true);

        // use a linear layout manager
        mGridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
        mRecyclerViewPayment.setLayoutManager(mGridLayoutManager);

        PaymentHomeAdapter adapter = new PaymentHomeAdapter(MainActivity.this, paymentList);
        mRecyclerViewPayment.setAdapter(adapter);
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
