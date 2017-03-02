package com.vaclavhnizda.myfoodbasket.viewtools;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutCompat;
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
//    /**
//     * This method will take the given layout and populate it with shop items. Then it links back
//     * all the click to a given listener.
//     * @param buttonListener
//     * @param shoppingList
//     * @param shopingItemContainer
//     */
//    public static void loadShopItems(View.OnClickListener buttonListener, List<ShopItem> shoppingList, LinearLayout shopingItemContainer) {
//        //1. clear view
//        if(shopingItemContainer.getChildCount() > 0) {
//            shopingItemContainer.removeAllViews();
//        }
//        //2. Loop through produce
//        for(int index = 0; index < shoppingList.size(); index++) {
//            //3. create produce button
//            //4. link listener
//        }
//    }

    public static List<Button> createButtonsAndLink(Context context, List<ShopItem> shoppingList, View.OnClickListener shopListListener) {

        List<Button> allButtons = new ArrayList<Button>();

        for(int index = 0; index < shoppingList.size(); index++){
            Button newButton = new Button(context);
            ShopItem shopItem = shoppingList.get(index);

//            newButton.setText(shopItem.getItemName());
            newButton.setText("Hello my button");
            newButton.setOnClickListener(shopListListener);

            allButtons.add(newButton);
        }

        return allButtons;
    }

    public static void loadShopItems(int screenWidth, int screenHeight, LinearLayout shopingItemContainer, List<Button> allProduceButtons) {

        //Clear given layout
        shopingItemContainer.removeAllViews();

        //Column count, basic idea for now. later calculate number of items that would fit across
        int colCount = 2;
        if (screenWidth > screenHeight) {
            colCount = 3;
        }

        //Figure out how many rows will be created
        int rowCount = allProduceButtons.size() / colCount;

        if(allProduceButtons.size() % colCount > 0){
            rowCount += 1; // acount for final row if not complete column set
        }

        //build structure: create row layout, add all items, add row to vertical layout
        for(int x = 0; x < rowCount; x++){
            LinearLayout newRowLayout = new LinearLayout(shopingItemContainer.getContext());
            for(int y = 0; y < colCount; y++){
                int loc = (x*colCount) + y;
                if(loc < allProduceButtons.size())
                    newRowLayout.addView(allProduceButtons.get(loc));
            }
            shopingItemContainer.addView(newRowLayout);
        }
    }
}
