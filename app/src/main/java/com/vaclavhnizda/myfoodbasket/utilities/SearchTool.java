package com.vaclavhnizda.myfoodbasket.utilities;

import com.vaclavhnizda.myfoodbasket.model.ShopItem;

import java.util.List;

/**
 * Created by vaclav on 3/6/17.
 */

public class SearchTool {

    //Search for item, returns null if not found
    public static ShopItem findItem(int id, List<ShopItem> itemsAvailable) {
        ShopItem shopItem = null;
        int index = 0;
        boolean itemFound = false;

        while(!itemFound && index < itemsAvailable.size()){
            ShopItem testItem = itemsAvailable.get(index);
            if(id == testItem.getId()){
                shopItem = testItem;
                itemFound = true;
            }

            index += 1;
        }

        return shopItem;
    }

}
