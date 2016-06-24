package com.kulomady.freesky.view.activity.payment;

import com.kulomady.freesky.model.home.PaymentModel;

import java.util.List;

/**
 * Created by macaris on 6/24/16.
 */
public interface PaymentView {
    void setupToolbar();
    void displayPaymentData(List<PaymentModel> paymentList);
}
