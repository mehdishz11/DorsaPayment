package ir.dorsa.totalpayment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ir.dorsa.totalpayment.R;


public class DialogSendKey extends Dialog {

    private TextView textKeyChangeNumber;
    private TextView textKeyTitle;
    private TextView textKeyHint;
    private EditText textKeyKey;
    private TextView textDescSendKey;
    private Button btnKeySend;
    private Button btnKeyCancel;

    private interactionSendKey mListener;


    public void setListener(interactionSendKey mListener) {
        this.mListener = mListener;
    }

    public DialogSendKey(@NonNull Context context) {
        super(context, android.R.style.Theme_Holo_Dialog_NoActionBar);
        init();
    }

    public DialogSendKey(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    protected DialogSendKey(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }


    @Override
    public void show() {
        super.show();

    }

    private void init(){
        setContentView(R.layout.dialog_register_aouth_key);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        textKeyChangeNumber = findViewById(R.id.dialog_register_changeNumber);
        textKeyTitle = findViewById(R.id.dialog_register_desc);
        textKeyHint = findViewById(R.id.dialog_register_hint);
        textKeyKey = findViewById(R.id.dialog_register_code);
        btnKeySend = findViewById(R.id.dialog_register_btn_send);
        btnKeyCancel = findViewById(R.id.dialog_register_btn_cancel);
        textDescSendKey = findViewById(R.id.title_register);

        textKeyChangeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.changePhoneNumber();
                }
            }
        });

        btnKeySend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textKeyKey.getText().toString().length() == 0) {
                    showError("کد فعالسازی را وارد نمایید");
                } else {
                    if (mListener != null) {
                        mListener.doSendKey(textKeyKey.getText().toString());
                    }
                }

            }
        });

        btnKeyCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
                if (mListener != null) {
                    mListener.cancelSendKey();
                }
            }
        });

        


    }


    public void setMessage(String message){
        textDescSendKey.setText(message);
    }

    public void showError(String message){
        textKeyHint.setText(message);
        textKeyHint.setVisibility(View.VISIBLE);
    }

    public void hideError(){
        textKeyHint.setVisibility(View.GONE);
    }

    public void setPhoneNumber(String phoneNumber){
        textKeyTitle.setText(phoneNumber);
    }

    public void setKey(String key){
        textKeyKey.setText(key);
    }




    public interface interactionSendKey{
        void changePhoneNumber();
        void doSendKey(String key);
        void cancelSendKey();
    }
}
