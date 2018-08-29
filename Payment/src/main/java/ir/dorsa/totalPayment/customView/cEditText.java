package ir.dorsa.totalPayment.customView;

/**
 * Created by mehdi on 1/19/16 AD.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class cEditText extends android.support.v7.widget.AppCompatEditText {

    public cEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public cEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public cEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "iran_sans_lightt.ttf");
            setTypeface(tf);
        }
    }

}