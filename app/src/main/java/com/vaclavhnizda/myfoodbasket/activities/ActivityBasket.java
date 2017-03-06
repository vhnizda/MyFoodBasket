package com.vaclavhnizda.myfoodbasket.activities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.vaclavhnizda.myfoodbasket.R;
import com.vaclavhnizda.myfoodbasket.controller.ControlManager;
import com.vaclavhnizda.myfoodbasket.model.ShopItem;
import com.vaclavhnizda.myfoodbasket.viewtools.LayoutBuilder;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityBasket extends AppCompatActivity implements DialogInterface.OnClickListener{

    @BindView(R.id.basket_list) LinearLayout myBasketLayout;
    private ControlManager myControlMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        ButterKnife.bind(this);

        myControlMan = new ControlManager();

        myControlMan.loadLocalData(this);
        loadBasket();
    }

    @Override
    protected void onPause(){
        super.onPause();
        myControlMan.saveData(this);
    }

    private void loadBasket() {
        Map<String,Integer> basket = myControlMan.getBasketList();
        List<ShopItem> itemsAvailable = myControlMan.getItemsAvailable();

        LayoutBuilder.loadBasket(myBasketLayout,basket,itemsAvailable);
    }

    @OnClick(R.id.main_return_button_in_basket)
    public void returnToShopping(){
        this.finish();
    }

    @OnClick(R.id.delete_basket)
    public void deleteBasket(){
        //confirm they want to delete
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Empty Cart");
        builder.setMessage("Are you sure you want to clear your cart?");
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        //clear saved contents
        builder.setPositiveButton(R.string.yes, this);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        myControlMan.clearBasket();
        loadBasket();
    }
}
