package com.vaclavhnizda.myfoodbasket.tools;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by vaclav on 2/24/17.
 */

public class DisplayStats {

    public static int getWidth(Activity activity){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        return displayMetrics.widthPixels;
    }

    public static int getHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }
}
