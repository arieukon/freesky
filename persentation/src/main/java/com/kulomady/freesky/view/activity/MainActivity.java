package com.kulomady.freesky.view.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.kulomady.freesky.R;
import com.kulomady.freesky.view.utils.ViewUtils;

import butterknife.BindView;

public class MainActivity extends BaseDrawerActivity {

    private static final int ANIM_DURATION_TOOLBAR = 300;

    @BindView(R.id.content)
    CoordinatorLayout clContent;
    @BindView(R.id.recyclerview_main)
    RecyclerView recyclerViewMain;

    private boolean pendingIntroAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            pendingIntroAnimation = true;
        }
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
