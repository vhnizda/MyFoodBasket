package com.vaclavhnizda.myfoodbasket.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.vaclavhnizda.myfoodbasket.R;
import com.vaclavhnizda.myfoodbasket.controller.ControlManager;
import com.vaclavhnizda.myfoodbasket.model.ShopItem;
import com.vaclavhnizda.myfoodbasket.viewtools.DisplayStats;
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

        populateView();

    }

    private void populateView() {

        //Load data into view and link buttons
        int screenWidth = DisplayStats.getWidth(this);
        int screenHeight = DisplayStats.getHeight(this);


        List<Button> allProduceButtons  = LayoutBuilder.createButtonsAndLink(this, myControlMan.getShoppingList(), myControlMan.getShopListListener());
        LayoutBuilder.loadShopItems(screenWidth, screenHeight, shopingItemContainer, allProduceButtons);
    }

    @Override
    public void onPause(){
        super.onPause();

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        myControlMan.saveData(this);
    }

    @Override
    public void onStop(){
        super.onStop();
    }

    @OnClick(R.id.basket_button_main)
    public void launchBasket(){
        //This is where the basket is launched
        Intent intent = new Intent(this, ActivityBasket.class);
        startActivity(intent);
    }

}
