package com.vaclavhnizda.myfoodbasket.model;

import com.orm.SugarRecord;

/**
 * Created by vaclav on 2/24/17.
 */

public class ShopItem extends SugarRecord{
    String iconRef;
    String unitOfMeasurement;
    double priceUSDReference;
    int stockCount; // use later

    public ShopItem(){}

    public ShopItem(String iconRef, String unitOfMeasurement, double priceUSDreference, int stockCount){
        this.iconRef = iconRef;
        this.unitOfMeasurement = unitOfMeasurement;
        this.priceUSDReference = priceUSDreference;
        this.stockCount = stockCount;
    }

    public String getIconRef(){
        return iconRef;
    }

}
