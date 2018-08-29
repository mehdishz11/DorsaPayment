package com.psb.dorsa.payment;

public interface ICheckStatus {
    void onStartCheckStatus();
    void onFailedCheckStatus(int errorCode, String errorMessage);
    void onSuccessCheckStatus();
}
