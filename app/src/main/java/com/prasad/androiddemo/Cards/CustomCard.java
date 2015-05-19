package com.prasad.androiddemo.Cards;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.prasad.androiddemo.DB.Pdetails;
import com.prasad.androiddemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.TextSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;

/**
 * Created by Prasad on 17/04/15.
 */
public class CustomCard extends MaterialLargeImageCard implements Card.OnCardClickListener {

    private static final String LOG_TAG = CustomCard.class.getSimpleName();
    private Pdetails pdetails;
    private Context cardContext;

    public CustomCard(Context context, Pdetails data) {
        super(context, R.layout.carddemo_native_material_supplemental_actions_large_icon );
        cardContext = context;
        this.pdetails = data;
        this.setOnClickListener(this);
    }




    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        //super.setupInnerViewElements(parent, view);

        TextView title = (TextView) view.findViewById(R.id.text1);
        TextView text = (TextView) view.findViewById(R.id.text2);



        /*

        Picasso.with(cardContext).setIndicatorsEnabled(true);  //only for debug tests
        Picasso.with(cardContext)
                .load("http://fortimages.s3-us-west-2.amazonaws.com/Ahiwantgad.jpeg")
                        //"http://fortimages.s3-us-west-2.amazonaws.com/Ahiwantgad.jpeg"
                .error(R.drawable.error)
                .fit()
                .into((ImageView) view);

        */

            setTitle("title");
            setSubTitle("sub-title");


            title.setText(pdetails.getName());
            text.setText(pdetails.getSurname());



    }


    @Override
    public void onClick(Card card, View view) {
        // in case your cards need to click on something. You don't need to
        // override onCLick if you don't wish to have click functionality on the cards

    }






}
