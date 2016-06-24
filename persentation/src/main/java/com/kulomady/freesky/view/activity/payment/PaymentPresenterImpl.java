package com.kulomady.freesky.view.activity.payment;

import android.content.Context;

import com.kulomady.freesky.model.home.PaymentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macaris on 6/24/16.
 */
public class PaymentPresenterImpl implements PaymentPresenter{
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

        String[] names = new String[] {"DOKU", "Sakuku", "PayPal", "BCAKlik", "VISA", "MasterCard", "GoPay", "GrabPay" , "Apple Pay"};

        for(int i=0; i<names.length; i++){
            PaymentModel paymentModel = new PaymentModel();
            paymentModel.setPaymentName(names[i]);
            paymentModel.setLogo("http://tinyurl.com/jameywy");
            paymentModel.setBackgroundColor("569966");
            paymentList.add(paymentModel);
        }
        return paymentList;
    }
}
