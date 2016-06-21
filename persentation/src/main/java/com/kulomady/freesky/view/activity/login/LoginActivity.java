package com.kulomady.freesky.view.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.kulomady.freesky.R;
import com.kulomady.freesky.view.activity.video.VideoActivity;

import butterknife.BindView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    LoginPresenterImpl mPresenter;

//    @BindView(R.id.et_mobile_number)
    EditText mEtMobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPresenter = new LoginPresenterImpl(this, this);

        initView();
    }

    @Override
    public void initView() {
        mEtMobileNumber = (EditText) findViewById(R.id.et_mobile_number);
        
        mEtMobileNumber.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    mPresenter.processLogin(mEtMobileNumber.getText().toString());
                }
                return false;
            }
        });
    }

    @Override
    public void gotoVideoPage() {
        Intent intent = new Intent(LoginActivity.this, VideoActivity.class);
        startActivity(intent);
        finish();
    }
}