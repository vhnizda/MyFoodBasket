package com.vaclavhnizda.myfoodbasket.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.vaclavhnizda.myfoodbasket.R;
import com.vaclavhnizda.myfoodbasket.model.DBManager;

/**
 * Created by vaclav on 2/24/17.
 */
public class ControlManager {

    //variables

    private DBManager myDBMan;

    public ControlManager(){
        myDBMan = new DBManager();
    }

    public int getBasketCount() {
        return myDBMan.basketCount();
    }

    public void saveData(Context context) {
        myDBMan.saveUserData(context);
    }
}
