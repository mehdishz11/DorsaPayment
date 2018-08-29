package ir.dorsa.totalPayment.payment;

import android.content.Context;


/**
 * Created by mehdi on 12/28/16.
 */

public interface IPPayment {
    void setContext(Context context);
    Context getContext();
    
    void onSuccessSendPhoneNumber();
    void onFailedSendPhoneNumber(String errorMessage);
    
    void onFailedSendKey(String errorMessage);
    
    void onSuccessSubscribe(String expiredDate);
    void onFailedSubscribe(String errorCode);
    
    void onFailedCheckStatus(int errorCode, String errorMessage);
    void onSuccessCheckStatus();

}
