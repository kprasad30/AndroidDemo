package com.prasad.androiddemo.Cards;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prasad.androiddemo.DB.DBdataSource;
import com.prasad.androiddemo.DB.Pdetails;
import com.prasad.androiddemo.R;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Prasad on 21/04/15.
 */
public class CardsWithRecycleView extends Activity {

    RecyclerView mRecyclerView;
    DBdataSource dBdataSource;
    AdapterRecycleView mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.cardlist_recycleview_layout);

        mRecyclerView = (RecyclerView)findViewById(R.id.cardslist_recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));  // for list layout manager
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());  // for item animaton


        mRecyclerView.setHasFixedSize(true);  // for better performance

        dBdataSource = new DBdataSource(this);
        try {
            dBdataSource.open();  // open DB connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Pdetails> values = dBdataSource.getAllDetails();


        // adding adapter
        mAdapter = new AdapterRecycleView(values,R.layout.cardview_recyclerview_item,this);
        mRecyclerView.setAdapter(mAdapter);



    }
}
