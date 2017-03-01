package com.vaclavhnizda.myfoodbasket.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import com.vaclavhnizda.myfoodbasket.R;
import com.vaclavhnizda.myfoodbasket.model.DBManager;
import com.vaclavhnizda.myfoodbasket.model.ShopItem;

import java.util.List;

/**
 * Created by vaclav on 2/24/17.
 */
public class ControlManager implements View.OnClickListener{

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

    public List<ShopItem> getShoppingList() {
        return myDBMan.getItemsAvailable();
    }

    public View.OnClickListener getShopListListener() {
        return this;
    }

    @Override
    public void onClick(View view) {

    }
}
