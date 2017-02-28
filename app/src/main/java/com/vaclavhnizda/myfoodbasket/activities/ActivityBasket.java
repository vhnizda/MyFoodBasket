package com.vaclavhnizda.myfoodbasket.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.vaclavhnizda.myfoodbasket.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityBasket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_return_button_in_basket)
    public void returnToShoping(){
        this.finish();
    }

    @OnClick(R.id.currency_button_in_basket)
    public void currencyChange(){
        //TODO allow selection of other currencies
    }
}
