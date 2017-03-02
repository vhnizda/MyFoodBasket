package com.vaclavhnizda.myfoodbasket.model;

import com.orm.SugarRecord;

/**
 * Created by vaclav on 2/24/17.
 */

public class ShopItem extends SugarRecord{
    String itemName;
    String unitOfMeasurement;
    double priceUSDReference;
    int stockCount; // use later

    public ShopItem(){}

    public ShopItem(String itemName, String unitOfMeasurement, double priceUSDreference, int stockCount){
        this.itemName = itemName;
        this.unitOfMeasurement = unitOfMeasurement;
        this.priceUSDReference = priceUSDreference;
        this.stockCount = stockCount;
    }

    public String getItemName(){
        return itemName;
    }

}
