package com.vaclavhnizda.myfoodbasket.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vaclavhnizda.myfoodbasket.R;
import com.vaclavhnizda.myfoodbasket.controller.ControlManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityFoodList extends AppCompatActivity {
    //Manager for logic controls
    private ControlManager myControlMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_food_list);
        ButterKnife.bind(this);

        myControlMan = new ControlManager();

        //TODO Load data 1. currency type 2. produce we can sell
        //TODO Generate buttons and link Controller to clicks & add to view
    }


    @OnClick(R.id.basket_button_main)
    public void launchBasket(){
        //This is where the basket is launched
        Intent intent = new Intent(this, ActivityBasket.class);
        startActivity(intent);
    }


    @OnClick(R.id.currency_button_main)
    public void currencyChange(){
        //TODO allow selection of other currencies
    }
}
