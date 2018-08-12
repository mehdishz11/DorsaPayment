
package ir.dorsa.totalpayment.payment.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ParamsAuthenticationRequest implements Serializable
{

    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("app_code")
    @Expose
    private Integer appCode;
    private final static long serialVersionUID = 31908865408776341L;

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

}
