package com.vaclavhnizda.myfoodbasket.model;

import com.orm.SugarRecord;

/**
 * Created by vaclav on 2/24/17.
 */

public class ShopItem extends SugarRecord{
    int id;
    String iconRef;
    String unitOfMesurement;
    double priceUSDreference;
    int stockCount; // use later

    public ShopItem(){}

    public ShopItem(int id, String iconRef, String unitOfMesurement, double priceUSDreference, int stockCount){
        this.id = id;
        this.iconRef = iconRef;
        this.unitOfMesurement = unitOfMesurement;
        this.priceUSDreference = priceUSDreference;
        this.stockCount = stockCount;
    }

}
