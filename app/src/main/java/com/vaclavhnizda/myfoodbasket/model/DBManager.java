package com.vaclavhnizda.myfoodbasket.model;

import java.util.List;

/**
 * Created by vaclav on 2/24/17.
 */
public class DBManager {

    public DBManager(){

        //TEST
        ShopItem.deleteAll(ShopItem.class);

        ShopItem myItem;
        myItem = new ShopItem("tomato","bunch",.95,200);
        myItem.save();
        myItem = new ShopItem("beans","can",.73,100);
        myItem.save();
        myItem = new ShopItem("eggs", "dozen",2.10,100);
        myItem.save();
        myItem = new ShopItem("milk", "bottle",1.30,50);
        myItem.save();


        List<ShopItem> allItems = ShopItem.listAll(ShopItem.class);


        for(ShopItem item : allItems) {

            System.out.println(item.getId() + " : " +item.iconRef + " are in a " + item.unitOfMesurement);

            ShopItem temp = ShopItem.findById(ShopItem.class,item.getId());

            System.out.println(temp.getId() + " : " +temp.iconRef + " uses the measurement unit: " + temp.unitOfMesurement);
        }
    }
}
