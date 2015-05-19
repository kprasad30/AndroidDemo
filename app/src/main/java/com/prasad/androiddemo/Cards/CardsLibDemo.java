package com.prasad.androiddemo.Cards;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.prasad.androiddemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.IconSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.TextSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardViewNative;

/**
 * Created by Prasad on 17/04/15.
 */
public class CardsLibDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardslib_simplecard_layout);



        // simple Demo card
        //Create a Card
        Card card = new Card(this);

        //Create a CardHeader
        CardHeader header = new CardHeader(this);

        //Add Header to card
        card.addCardHeader(header);

        //Set card in the cardView
        CardViewNative cardView = (CardViewNative) findViewById(R.id.carddemo);
        cardView.setCard(card);


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
                        .useDrawableExternal(new MaterialLargeImageCard.DrawableExternal() {
                            @Override
                            public void setupInnerViewElements(ViewGroup parent, View viewImage) {

                                Picasso.with(getApplicationContext()).setIndicatorsEnabled(true);  //only for debug tests
                                Picasso.with(getApplicationContext())
                                        .load("http://fortimages.s3-us-west-2.amazonaws.com/Ahiwantgad.jpeg")
                                                //"http://fortimages.s3-us-west-2.amazonaws.com/Ahiwantgad.jpeg"
                                        .error(R.drawable.error)
                                        .fit()
                                        .into((ImageView) viewImage);

                            }
                        })
                        .setupSupplementalActions(R.layout.carddemo_native_material_supplemental_actions_large_icon, actions)
                        .build();





        // on click event for cards
        mcard.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getApplicationContext()," Click on ActionArea ",Toast.LENGTH_SHORT).show();
            }
        });

        //Set card in the cardView
        CardViewNative mcardView = (CardViewNative) findViewById(R.id.carddemo_largeimage);
        mcardView.setCard(mcard);


    }
}
