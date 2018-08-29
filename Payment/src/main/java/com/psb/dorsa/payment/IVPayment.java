package com.psb.dorsa.payment;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by mehdi on 12/28/16.
 */

public interface IVPayment extends ICheckStatus {
    Context getContext();

    Fragment getFragment();
    
    void onStartSendPhoneNumber();
    void onSuccessSendPhoneNumber();
    void onFailedSendPhoneNumber(String errorMessage);
    
     
    void onStartSendKey();
    void onFailedSendKey(String errorMessage);
    
    void onSuccessSubscribe(String expiredDate);
    void onFailedSubscribe(String errorMessage);



    void onStartPurchaseIrancell();
    void onSuccessPurchaseIrancell(String message);
    void onFailedpurchaseIrancell(String message);

}
