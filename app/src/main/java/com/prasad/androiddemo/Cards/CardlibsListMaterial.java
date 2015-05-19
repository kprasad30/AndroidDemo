package com.prasad.androiddemo.Cards;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.prasad.androiddemo.DB.DBdataSource;
import com.prasad.androiddemo.DB.Pdetails;
import com.prasad.androiddemo.R;
import com.squareup.picasso.Picasso;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.TextSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * Created by Prasad on 17/04/15.
 */
public class CardlibsListMaterial extends Activity{

    DBdataSource dBdataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardlistview_layout);


        dBdataSource = new DBdataSource(this);
        try {
            dBdataSource.open();  // open DB connection
        } catch (SQLException e) {
            e.printStackTrace();
        }



        ArrayList<Card> cards = new ArrayList<Card>();


        List<Pdetails> details = dBdataSource.getAllDetails();

        for(Pdetails info : details) {


// material cards
            // Set supplemental actions as text
            ArrayList<BaseSupplementalAction> actions = new ArrayList<BaseSupplementalAction>();

            // Set supplemental actions
            TextSupplementalAction t1 = new TextSupplementalAction(this, R.id.text1);
            t1.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Toast.makeText(getApplicationContext(), " Click on Text SHARE ", Toast.LENGTH_SHORT).show();
                }
            });
            actions.add(t1);

            TextSupplementalAction t2 = new TextSupplementalAction(this, R.id.text2);
            t2.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Toast.makeText(getApplicationContext()," Click on Text LEARN ",Toast.LENGTH_SHORT).show();
                }
            });
            actions.add(t2);


            // Material card
            MaterialLargeImageCard mcard =
                     MaterialLargeImageCard.with(this)
                            .setTextOverImage("Italian Beaches")
                            .setTitle("This is my favorite local beach")
                            .setSubTitle("A wonderful place")
                            .setupSupplementalActions(R.layout.carddemo_native_material_supplemental_actions_large_icon, actions)
                            .build();



            cards.add(mcard);



        }

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getApplicationContext(),cards);

        CardListView listView = (CardListView)findViewById(R.id.myList);
        if (listView!=null){
            listView.setAdapter(mCardArrayAdapter);
        }



    }





}
