package com.vaclavhnizda.myfoodbasket.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.vaclavhnizda.myfoodbasket.R;
import com.vaclavhnizda.myfoodbasket.controller.ControlManager;

public class MainActivityFoodList extends AppCompatActivity {

    private ControlManager myMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_food_list);

        myMan = new ControlManager();
    }
}
