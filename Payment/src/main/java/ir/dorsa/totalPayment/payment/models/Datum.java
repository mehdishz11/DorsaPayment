
package ir.dorsa.totalPayment.payment.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Datum implements Serializable
{

    @SerializedName("product_code")
    @Expose
    private String productCode;
    @SerializedName("purchase_time")
    @Expose
    private long purchaseTime;
    @SerializedName("expire_time")
    @Expose
    private long expireTime;
    @SerializedName("product_status")
    @Expose
    private String productStatus;
    @SerializedName("auto_charge")
    @Expose
    private String autoCharge;
    private final static long serialVersionUID = -2003043099896939535L;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public long getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(long purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getAutoCharge() {
        return autoCharge;
    }

    public void setAutoCharge(String autoCharge) {
        this.autoCharge = autoCharge;
    }

}
