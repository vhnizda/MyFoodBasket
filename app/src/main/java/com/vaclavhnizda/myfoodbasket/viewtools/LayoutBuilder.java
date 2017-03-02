package com.vaclavhnizda.myfoodbasket.viewtools;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.vaclavhnizda.myfoodbasket.model.ShopItem;

import java.util.ArrayList;
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

    public static List<Button> createButtonsAndLink(Context context, List<ShopItem> shoppingList, View.OnClickListener shopListListener) {

        List<Button> allButtons = new ArrayList<Button>();

        for(int index = 0; index < shoppingList.size(); index++){
            Button newButton = new Button(context);
            ShopItem shopItem = shoppingList.get(index);

            newButton.setText(shopItem.getIconRef());

            newButton.setOnClickListener(shopListListener);
        }

        return allButtons;
    }

    public static void loadShopItems(int screenWidth, int screenHeight, LinearLayout shopingItemContainer, List<Button> allProduceButtons) {

    }
}
