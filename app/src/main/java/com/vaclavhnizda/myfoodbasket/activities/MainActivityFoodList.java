package com.vaclavhnizda.myfoodbasket.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.vaclavhnizda.myfoodbasket.R;
import com.vaclavhnizda.myfoodbasket.controller.ControlManager;
import com.vaclavhnizda.myfoodbasket.viewtools.LayoutBuilder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityFoodList extends AppCompatActivity{
    //Manager for logic controls
    private ControlManager myControlMan;

    @BindView(R.id.shop_items_layout) LinearLayout shopingItemContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_food_list);
        ButterKnife.bind(this);

        //Restore local data (old basket) and setup DB data connection
        myControlMan = new ControlManager();

    }

    @Override
    public void onResume(){
        super.onResume();

        //Load local user data
        myControlMan.loadLocalData(this);

        //Load data into view and link buttons 1. produce we can sell
        LayoutBuilder.loadShopItems(myControlMan.getShopListListener(), myControlMan.getShoppingList(), shopingItemContainer);

    }

    @Override
    public void onPause(){
        super.onPause();
        //myControlMan.saveData(this);

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop(){
        super.onStop();
        //TODO close down all big objects
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        //TODO close down all big objects
    }

    @OnClick(R.id.basket_button_main)
    public void launchBasket(){
        //This is where the basket is launched
        Intent intent = new Intent(this, ActivityBasket.class);
        //TODO pass a reference to the control manager
        startActivity(intent);
    }

}
