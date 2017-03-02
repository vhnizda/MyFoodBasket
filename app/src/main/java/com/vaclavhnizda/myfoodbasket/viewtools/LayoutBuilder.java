package com.vaclavhnizda.myfoodbasket.viewtools;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.vaclavhnizda.myfoodbasket.model.ShopItem;

import java.util.List;

/**
 * Created by vaclav on 3/1/17.
 */

public class LayoutBuilder {
    /**
     * This method will take the given layout and populate it with shop items. Then it links back
     * all the click to a given listener.
     * @param buttonListener
     * @param shoppingList
     * @param shopingItemContainer
     */
    public static void loadShopItems(View.OnClickListener buttonListener, List<ShopItem> shoppingList, LinearLayout shopingItemContainer) {
        //1. clear view
        if(shopingItemContainer.getChildCount() > 0) {
            shopingItemContainer.removeAllViews();
        }
        //2. Loop through produce
        for(int index = 0; index < shoppingList.size(); index++) {
            //3. create produce button
            //4. link listener
        }
    }
}
