package com.kulomady.freesky.view.activity.payment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kulomady.freesky.R;
import com.kulomady.freesky.model.home.PaymentModel;
import com.kulomady.freesky.view.adapter.PaymentHomeAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentActivity extends AppCompatActivity implements PaymentView {

    @BindView(R.id.recyclerview_payment)
    RecyclerView mRecyclerViewPayment;

    PaymentPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);
        mPresenter = new PaymentPresenterImpl(this, this);

        setupToolbar();
        mPresenter.loadPayment();
    }

    @Override
    public void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            assert getSupportActionBar() != null;
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        //    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    @Override
    public void displayPaymentData(List<PaymentModel> paymentList) {
        GridLayoutManager mGridLayoutManager;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewPayment.setHasFixedSize(true);

        // use a linear layout manager
        mGridLayoutManager = new GridLayoutManager(PaymentActivity.this, 3);
        mRecyclerViewPayment.setLayoutManager(mGridLayoutManager);

        PaymentHomeAdapter adapter = new PaymentHomeAdapter(PaymentActivity.this, paymentList);
        mRecyclerViewPayment.setAdapter(adapter);
    }
}
