
package com.psb.dorsa.payment.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ParamsSubscribe implements Serializable
{

    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("app_code")
    @Expose
    private Integer appCode;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("product_code")
    @Expose
    private String productCode;
    private final static long serialVersionUID = 7664338220089010115L;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getAppCode() {
        return appCode;
    }

    public void setAppCode(Integer appCode) {
        this.appCode = appCode;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

}
