package com.kulomady.freesky.view.activity.payment;

import android.content.Context;

import com.kulomady.freesky.model.home.PaymentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macaris on 6/24/16.
 */
public class PaymentPresenterImpl implements PaymentPresenter {
    Context mContext;
    PaymentView mView;

    public PaymentPresenterImpl(Context mContext, PaymentView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void loadPayment() {
        mView.displayPaymentData(getPaymentData());
    }

    @Override
    public List<PaymentModel> getPaymentData() {
        List<PaymentModel> paymentList = new ArrayList();

        String[] names = new String[]{
                "Pulsa",
                "PLN",
                "PAM",
                "TV Kabel",
                "Telepon",
                "Internet",
                "Cicilan",
                "Asuransi",
                "Transfer"
        };

        String[] colors = new String[]{
                "00b386",
                "ff9900",
                "2eb8b8",
                "00ffcc",
                "006666",
                "80ff00",
                "26734d",
                "009900",
                "ff6600"
        };

        for (int i = 0; i < names.length; i++) {
            PaymentModel paymentModel = new PaymentModel();
            paymentModel.setPaymentName(names[i]);
            paymentModel.setLogo("http://tinyurl.com/jameywy");
            paymentModel.setBackgroundColor(colors[i]);
            paymentList.add(paymentModel);
        }
        return paymentList;
    }
}
