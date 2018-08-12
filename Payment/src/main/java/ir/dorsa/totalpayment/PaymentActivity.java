package ir.dorsa.totalpayment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import net.jhoobin.jhub.CharkhoneSdkApp;

import ir.dorsa.totalpayment.intro.FragmentIntro;
import ir.dorsa.totalpayment.payment.FragmentPayment;
import ir.dorsa.totalpayment.toolbarHandler.ToolbarHandler;

import static ir.dorsa.totalpayment.payment.Payment.KEY_APP_CODE;
import static ir.dorsa.totalpayment.payment.Payment.KEY_MESSAGE;
import static ir.dorsa.totalpayment.payment.Payment.KEY_PRODUCT_CODE;
import static ir.dorsa.totalpayment.payment.Payment.KEY_SKU;
import static ir.dorsa.totalpayment.payment.Payment.KEY_SPLASH;
import static ir.dorsa.totalpayment.payment.Payment.KEY_TEXT_SEND_PHONE_NUMBER;

public class PaymentActivity extends AppCompatActivity implements
        FragmentIntro.interaction,
        FragmentPayment.interactionPayment {

    private static final String KEY_FRG_INTRO = "KEY_FRG_INTRO";
    private static final String KEY_FRG_PAYMENT = "KEY_FRG_PAYMENT";

    private String textSendPhoneNumber;
    private String appCode;
    private String productCode;
    private String irancellSku;
    private int[] splashLayoutResource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        new ToolbarHandler().makeTansluteToolbar(this, getWindow(), getWindow().getDecorView());


        try {
            CharkhoneSdkApp.initSdk(getApplicationContext(), getSecrets(),getIntent().getIntExtra("icon",R.drawable.dorsa_icon));

            textSendPhoneNumber = getIntent().getExtras().getString(KEY_TEXT_SEND_PHONE_NUMBER);
            appCode = getIntent().getExtras().getString(KEY_APP_CODE);
            productCode = getIntent().getExtras().getString(KEY_PRODUCT_CODE);
            irancellSku = getIntent().getExtras().getString(KEY_SKU);

            splashLayoutResource = getIntent().getExtras().getIntArray(KEY_SPLASH);

            if(textSendPhoneNumber==null  || appCode==null || productCode==null){
                Intent intent =new Intent();
                intent.putExtra(KEY_MESSAGE,"مقادر ورودی ناقص می باشد");
                setResult(Activity.RESULT_CANCELED,intent);
                finish();
                return;
            }


            if(splashLayoutResource!=null && splashLayoutResource.length>0) {
                getSupportFragmentManager().beginTransaction().add(R.id.frame_fragment, new FragmentIntro().newInstance(splashLayoutResource), KEY_FRG_INTRO).commit();
            }else{
                new ToolbarHandler().makeTansluteToolbar(this, getWindow(), getWindow().getDecorView());
                getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).replace(R.id.frame_fragment,
                        new FragmentPayment().newInstance(
                                textSendPhoneNumber,
                                productCode,
                                appCode,
                                irancellSku
                        ), KEY_FRG_PAYMENT).commit();
            }

        }catch (Exception ex){
            ex.printStackTrace();
            Intent returnIntent = new Intent();
            returnIntent.putExtra("message","ایراد ورود اطلاعات");
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        }
    }

    public String[] getSecrets(){
        return getResources().getStringArray(R.array.secrets);
    }

    @Override
    public void onSuccessSubscribe() {
        setResult(Activity.RESULT_OK);
        finish();
    }

    @Override
    public void onFailedSubscribe() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("message", "مشکل فعال سازی");
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("message", "مشکل فعال سازی");
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }

    @Override
    public void onEnterSelected() {
        new ToolbarHandler().makeTansluteToolbar(this, getWindow(), getWindow().getDecorView());
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).replace(R.id.frame_fragment,
                new FragmentPayment().newInstance(
                        textSendPhoneNumber,
                        productCode,
                        appCode,
                        irancellSku
                ), KEY_FRG_PAYMENT).commit();
    }
}
