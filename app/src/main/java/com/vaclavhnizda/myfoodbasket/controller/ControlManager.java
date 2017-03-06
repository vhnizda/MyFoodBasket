package com.vaclavhnizda.myfoodbasket.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vaclavhnizda.myfoodbasket.R;
import com.vaclavhnizda.myfoodbasket.model.DBManager;
import com.vaclavhnizda.myfoodbasket.model.ShopItem;

import java.util.List;
import java.util.Map;

/**
 * Created by vaclav on 2/24/17.
 */
public class ControlManager implements View.OnClickListener{

    //variables

    private DBManager myDBMan;
    private TextView totalOrderTextLink;

    public ControlManager(){
        myDBMan = new DBManager();
    }

    public int getBasketCount() {
        return myDBMan.basketCount();
    }

    public void saveData(Context context) {
        myDBMan.saveUserData(context);
    }

    public List<ShopItem> getItemsAvailable() {
        return myDBMan.getItemsAvailable();
    }

    public View.OnClickListener getShopListListener() {
        return this;
    }

    @Override
    public void onClick(View view) {
            //TODO add to user shopping list what they wanted to order from pressing a button.
            //TODO later add options to delete, and other button triggers (seperate listener class)
        if(view.getClass() == Button.class){
            int id = view.getId();
            myDBMan.addToOrder(id);
        }

        updateMainTotalText();
    }

    private void updateMainTotalText() {
        if(totalOrderTextLink != null){
            String part1 = "items in basket: ";
            String part2 = String.valueOf(myDBMan.basketCount());
            totalOrderTextLink.setText(part1 + part2);
        }
    }

    public void loadLocalData(Context context) {
        myDBMan.loadUserData(context);
    }

    public Map<String,Integer> getBasketList() {
        return myDBMan.getBasketList();
    }

    //updates when total is changed.
    public void addTotalToUpdate(TextView totalOrderTextView) {
        totalOrderTextLink = totalOrderTextView;
        updateMainTotalText();
    }
}
