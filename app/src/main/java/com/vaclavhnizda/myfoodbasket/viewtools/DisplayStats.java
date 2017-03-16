package com.vaclavhnizda.myfoodbasket.viewtools;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by vaclav on 2/24/17.
 */

public class DisplayStats {

    public static int getWidth(Context context){

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        //int px = (int) TypedValue.applyDimension(TypeValue.COMPLEX_UNIT_DIP,200,r.getDisplayMetrics());
        return displayMetrics.widthPixels;
    }

    public static int getHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

    public static int widthDPtoPixels(Context context,int dpUnits){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float value = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpUnits, displayMetrics);
        return (int)value;
    }
}
