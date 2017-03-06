package com.vaclavhnizda.myfoodbasket.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.vaclavhnizda.myfoodbasket.R;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by vaclav on 2/24/17.
 */
public class DBManager {

    //Local storage keys
    public static final String COUNTKEY = "countkey";
    public static final String ITEMPREKEY = "shopitemkey";

    private List<ShopItem> allShopItems;
    private Map<String,Integer> itemOrder;

    public DBManager(){

        loadTempData();


        for(ShopItem item : allShopItems) {

            //TODO remove this test into external testing if possible
            System.out.println(item.getId() + " : " +item.itemName + " are in a " + item.unitOfMeasurement);

            ShopItem temp = ShopItem.findById(ShopItem.class,item.getId());

            System.out.println(temp.getId() + " : " +temp.itemName + " uses the measurement unit: " + temp.unitOfMeasurement);
        }
    }

    /**
     * Potentially used locally store all items in a shop database.
     * Currently loads a preselected No. of items (4 specified in instructions)
     */

    private void loadTempData() {

//        ShopItem.deleteAll(ShopItem.class);
        allShopItems = ShopItem.listAll(ShopItem.class);

        if(allShopItems.size() < 4) {
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

    //Method to add to "itemOrder"
    public void addToOrder(int id){
        changeOrder(id,1);
    }
    public void addToORder(int id, int amount){
        if(amount > 0){
            changeOrder(id,amount);
        }
    }

    //TODO create method to remove from "itemOrder"
    public void reduceOrder(int id){
        changeOrder(id,-1);

    }

    public void deleteItem(int id){
        itemOrder.remove(Integer.toString(id));
    }

    //TODO create method to clear "itemOrder"
    public void clearOrder(){
        itemOrder.clear();
    }

    //Method to return all available shop items
    public List<ShopItem> getItemsAvailable(){
        return allShopItems;
    }

    /**
     * This method will count the order and add up the total
     * @return
     */
    public int basketCount() {
        int total = 0;
        if(itemOrder.size() > 0) {
            Collection<Integer> values = itemOrder.values();
            for (int individualTotals : values) {
                total += individualTotals;
            }
        }
        return total;
    }


    public void loadUserData(Context context) {
        itemOrder = new HashMap<String,Integer>();
        //see if previous order exists
        String key = context.getResources().getString(R.string.preference_file_key);
        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences(key, Context.MODE_PRIVATE);

        int totalItemsOrdered = sharedPref.getInt(COUNTKEY, 0);

        //If there was an order, load the data
        if(totalItemsOrdered > 0){
            //TODO 1. get all keys 2. loop through 3. store values matching items in "itemOrder"
        }
    }

    /**
     * This method will save all local data. This store user order history.
     * @param context
     */
    public void saveUserData(Context context) {
        //setup local storage
        String key = context.getResources().getString(R.string.preference_file_key);
        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        //1. clear local store
        editor.clear();
        //2. add total order count
        editor.putInt(COUNTKEY,basketCount());
        //3. add all items currently in basket
        Set<String> orderKeyList = itemOrder.keySet();
        for(String currentOrderKey : orderKeyList){
            String newKey = ITEMPREKEY + currentOrderKey;
            editor.putInt(newKey,itemOrder.get(currentOrderKey));
        }
        //4. commit save
        editor.commit();
    }

    /**
     * Locate the shop item corresponding to a given id
     * @param idSearching this will be what ID we are trying to match
     * @return If a match is made the matching ShopItem is returned else null is returned.
     */
    private ShopItem findShopItem(Integer idSearching) {
        ShopItem itemPlaceholder = null;
        //Loop through all possible items until match found
        for(int index = 0; index < allShopItems.size(); index ++){
            if(allShopItems.get(index).getId().intValue() == idSearching){
                itemPlaceholder = allShopItems.get(index);
                index = allShopItems.size();
            }
        }
        return itemPlaceholder;
    }

    /**
     * Method to increase or decrease an order
     * @param id this is the item id to match
     * @param amount this is the amount to change it by
     */
    public void changeOrder(int id, int amount) {
        if(amount == 0 || id < 0)
            return;

        String idKey = Integer.toString(id);

        Integer total = amount;

        if(itemOrder.containsKey(idKey)){
            total += itemOrder.get(idKey);
        }

        if(total <= 0){
            itemOrder.remove(Integer.toString(id));
        }
        else
            itemOrder.put(Integer.toString(id),total); //update map
    }
}
