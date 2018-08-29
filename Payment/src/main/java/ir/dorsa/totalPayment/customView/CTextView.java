package ir.dorsa.totalPayment.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by mehdi on 7/10/15 AD.
 */
public class CTextView extends android.support.v7.widget.AppCompatTextView {
    public static Typeface FONT_NAME;


    public CTextView(Context context) {
        super(context);
        isInEditMode();
        if(FONT_NAME == null) FONT_NAME = Typeface.createFromAsset(context.getAssets(), "iran_sans_lightt.ttf");
        this.setTypeface(FONT_NAME);
    }
    public CTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        isInEditMode();
        try {
            if (FONT_NAME == null)
                FONT_NAME = Typeface.createFromAsset(context.getAssets(), "iran_sans_lightt.ttf");
            this.setTypeface(FONT_NAME);
        }catch (Exception ex){
            
        }
    }
    public CTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        isInEditMode();
        if(FONT_NAME == null) FONT_NAME = Typeface.createFromAsset(context.getAssets(), "iran_sans_lightt.ttf");
        this.setTypeface(FONT_NAME);
    }
}
