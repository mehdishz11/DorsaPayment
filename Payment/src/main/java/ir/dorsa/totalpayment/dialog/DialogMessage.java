package ir.dorsa.totalpayment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ir.dorsa.totalpayment.R;

public class DialogMessage extends Dialog {

    private ClickListner clickListner;
    private TextView textMessage;
    private Button btnOk;

    public DialogMessage(@NonNull Context context) {
        super(context, android.R.style.Theme_Holo_Dialog_NoActionBar);
        init();
    }

    public DialogMessage(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    protected DialogMessage(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }


    public void setClickListner(ClickListner clickListner) {
        this.clickListner = clickListner;
    }

    private void init(){
        setContentView(R.layout.dialog_msg);
        setCancelable(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().setDimAmount(0.0f);

        textMessage=findViewById(R.id.textView24);
        btnOk=findViewById(R.id.button3);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListner != null) {
                    clickListner.onClick();
                }
            }
        });

    }

    public void setTextButton(String text){
        btnOk.setText(text);
    }

    public void setMessage(String message){
        textMessage.setText(message);
    }


    public interface ClickListner{
        void onClick();
    }

}
