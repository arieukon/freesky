package com.kulomady.freesky.view.activity.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.kulomady.freesky.R;
import com.kulomady.freesky.view.activity.home.HomeActivity;

import butterknife.BindView;

public class VideoActivity extends AppCompatActivity implements com.kulomady.freesky.view.activity.video.VideoView,
        View.OnClickListener {

/*
    @BindView(R.id.img_video)
    ImageView mImgVideo;
*/
    ImageView mImgVideo;

    @BindView(R.id.btn_skip)
    Button mBtnSkip;

    @Override
    protected void onCreate(Bundle  savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

    }

    @Override
    public void initView() {
        mImgVideo = (ImageView) findViewById(R.id.img_video);

        mImgVideo.setOnClickListener(this);
        mBtnSkip.setOnClickListener(this);
        mBtnSkip.setOnClickListener(this);

        gotoHome();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==mImgVideo.getId()){
            gotoHome();
        } else if(id==mBtnSkip.getId()){
            gotoHome();
        }
    }

    @Override
    public void gotoHome() {
        Toast.makeText(this, "dsfdsfdf", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(VideoActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
