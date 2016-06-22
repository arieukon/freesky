package com.kulomady.freesky.view.activity.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.kulomady.freesky.R;
import com.kulomady.freesky.view.activity.home.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoActivity extends AppCompatActivity implements com.kulomady.freesky.view.activity.video.VideoView {

    @BindView(R.id.img_video)
    ImageView mImgVideo;
    @BindView(R.id.btn_skip)
    Button mBtnSkip;

    @OnClick(R.id.img_video)
    void imgVideoClicked(){
        gotoHome();
    }
    @OnClick(R.id.btn_skip)
    void btnSkipClicked(){
        gotoHome();
    }

    @Override
    protected void onCreate(Bundle  savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(VideoActivity.this);
    }

    @Override
    public void gotoHome() {
        Intent intent = new Intent(VideoActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
