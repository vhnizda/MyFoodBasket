package com.vaclavhnizda.myfoodbasket.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.vaclavhnizda.myfoodbasket.R;

import java.util.List;

/**
 * Created by vaclav on 2/24/17.
 */
public class DBManager {

    //Local storage keys
    public static final String COUNTKEY = "countkey";
    public static final String ITEMPREKEY = "shopitemkey";

    private List<ShopItem> allItems;
    private int itemCount = 0; //total items

    public DBManager(){

        loadData();


        for(ShopItem item : allItems) {

            System.out.println(item.getId() + " : " +item.iconRef + " are in a " + item.unitOfMeasurement);

            ShopItem temp = ShopItem.findById(ShopItem.class,item.getId());

            System.out.println(temp.getId() + " : " +temp.iconRef + " uses the measurement unit: " + temp.unitOfMeasurement);
        }
    }

    private void loadData() {

        allItems = ShopItem.listAll(ShopItem.class);

        if(allItems.size() < 4) {
            ShopItem.deleteAll(ShopItem.class);

            ShopItem myItem;
            myItem = new ShopItem("tomato", "bunch", .95, 100);
            myItem.save();
            myItem = new ShopItem("beans", "can", .73, 100);
            myItem.save();
            myItem = new ShopItem("eggs", "dozen", 2.10, 100);
            myItem.save();
            myItem = new ShopItem("milk", "bottle", 1.30, 100);
            myItem.save();
        }
    }

    public int basketCount() {
        return itemCount;
    }

    public void saveUserData(Context context) {
        //setup local storage
        String key = context.getResources().getString(R.string.preference_file_key);
        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        //save user data locally
        editor.clear();
        editor.putInt(COUNTKEY,basketCount());
        //TODO add all items user added to basket (id + quantity per item)
    }
}
