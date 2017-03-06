package com.vaclavhnizda.myfoodbasket.viewtools;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vaclavhnizda.myfoodbasket.model.ShopItem;
import com.vaclavhnizda.myfoodbasket.utilities.SearchTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by vaclav on 3/1/17.
 */

public class LayoutBuilder {

    /**
     * This method will create all the buttons for each itme given in the list<ShopItem>
     * @param context
     * @param shoppingList
     * @param shopListListener
     * @return
     */
    public static List<Button> createButtonsAndLink(Context context, List<ShopItem> shoppingList, View.OnClickListener shopListListener) {

        List<Button> allButtons = new ArrayList<Button>();

        for(int index = 0; index < shoppingList.size(); index++){
            Button newButton = new Button(context);
            ShopItem shopItem = shoppingList.get(index);

            newButton.setText(shopItem.getItemName());
            newButton.setId(shopItem.getId().intValue());
            newButton.setOnClickListener(shopListListener);

            allButtons.add(newButton);
        }

        return allButtons;
    }

    /**
     * This method will load all buttons into a given LinearLayout and clear any previous buttons
     * @param screenWidth
     * @param screenHeight
     * @param shopingItemContainer
     * @param allProduceButtons
     */
    public static void loadShopItems(int screenWidth, int screenHeight, LinearLayout shopingItemContainer, List<Button> allProduceButtons) {

        //Clear given layout
        shopingItemContainer.removeAllViews();

        //Column count, basic idea for now. later calculate number of items that would fit across
        int colCount = 2;
        int itemDimensions = screenWidth/3;

        if (screenWidth > screenHeight) {
            itemDimensions = screenHeight/3;
        }


        //Figure out how many rows will be created
        int rowCount = allProduceButtons.size() / colCount;

        if(allProduceButtons.size() % colCount > 0){
            rowCount += 1; // acount for final row if not complete column set
        }

        //build structure: create row layout, add all items, add row to vertical layout
        for(int x = 0; x < rowCount; x++){
            LinearLayout newRowLayout = new LinearLayout(shopingItemContainer.getContext());
            newRowLayout.setGravity(0x01); //center horizontally

            for(int y = 0; y < colCount; y++){
                int loc = (x*colCount) + y;
                if(loc < allProduceButtons.size()) {
                    Button button = allProduceButtons.get(loc);
                    button.setHeight(itemDimensions);
                    button.setWidth(itemDimensions);
                    newRowLayout.addView(button);
                }
            }
            shopingItemContainer.addView(newRowLayout);
        }
    }

    /**
     * This method will create a list of all items being purchased and present a total in costs.
     * @param myBasketLayout
     * @param basket
     * @param itemsAvailable
     */
    public static void loadBasket(LinearLayout myBasketLayout, Map<String,Integer> basket, List<ShopItem> itemsAvailable) {
        //1.add row with horizontal layout
        //2.add item name, quantity x price to each row
        //3.add total to bottom

        Context context = myBasketLayout.getContext();
        myBasketLayout.removeAllViews();
        double totalCost = 0.0;

        for(String key : basket.keySet()){
            LinearLayout newRowLayout = new LinearLayout(context);
            newRowLayout.setGravity(0x05); //right

            TextView newText = new TextView(context);

            //Locate item
            int id = Integer.parseInt(key);
            ShopItem shopItem = SearchTool.findItem(id,itemsAvailable);

            //Extract information
            String itemName = shopItem.getItemName();
            String itemGrouping = shopItem.getUnitOfMeasurement();
            Double priceUSD = shopItem.getPriceUSDReference();
            String priceUSDString = String.format( "%.2f", priceUSD );
            int quantityOfOrder = basket.get(key);

            //Post to text view
            newText.setText(itemName + "  (" + itemGrouping + ")   Quantity:  " + quantityOfOrder + "   x   $" + priceUSDString);

            newRowLayout.addView(newText);
            myBasketLayout.addView(newRowLayout);

            //update total
            totalCost += (priceUSD * quantityOfOrder);
        }

        LinearLayout newRowLayout = new LinearLayout(context);
        newRowLayout.setGravity(0x05); //right

        TextView newText = new TextView((context));
        newText.setText("Total price in USD:       $" + String.format( "%.2f", totalCost ));

        newRowLayout.addView(newText);
        myBasketLayout.addView(newRowLayout);
    }

}
