package ir.dorsa.totalpayment.toolbarHandler;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import ir.dorsa.totalpayment.R;


public class ToolbarHandler {

    public void makePurpuleToolbar(Context context, Window w, View view){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.setStatusBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
    public void makeTansluteToolbar(Context context, Window w, View view){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.setStatusBarColor(ContextCompat.getColor(context, android.R.color.transparent));
        }
    }

}
