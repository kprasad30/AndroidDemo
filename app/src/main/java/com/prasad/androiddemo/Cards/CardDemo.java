package com.prasad.androiddemo.Cards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.prasad.androiddemo.R;

/**
 * Created by Prasad on 17/04/15.
 */
public class CardDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carddemo_layout);


        // Cardslib cards
        Button btnCardsLib = (Button)findViewById(R.id.btnCardsLib);
        btnCardsLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inCardsLib = new Intent(getApplicationContext(), CardsLibDemo.class);
                startActivity(inCardsLib);
            }
        });


        // Cardslib cards
        Button btnCardslibList = (Button)findViewById(R.id.btnCardsLiblist);
        btnCardslibList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inCardsLiblist = new Intent(getApplicationContext(),CardlibsListMaterial.class);
                startActivity(inCardsLiblist);
            }
        });



        // Cardslib cards
        Button btnRecyclerCardList = (Button)findViewById(R.id.btnRecyclerCardslist);
        btnRecyclerCardList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inRecyclerCardslist = new Intent(getApplicationContext(),CardsWithRecycleView.class);
                startActivity(inRecyclerCardslist);
            }
        });

    }
}
