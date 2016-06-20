package com.kulomady.freesky.view.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kulomady.freesky.R;
import com.kulomady.freesky.view.activity.home.HomeActivity;
import com.kulomady.freesky.view.activity.login.LoginActivity;

public class SplashActivity extends AppCompatActivity implements SplashView {

    SplashPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPresenter = new SplashPresenterImpl(this,this);
        mPresenter.loadingSplash();
    }

    @Override
    public void gotoLogin() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
