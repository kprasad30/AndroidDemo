package com.prasad.androiddemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.prasad.androiddemo.ActionBar.ActionBardemo;
import com.prasad.androiddemo.ActivityAndIntents.ActivityForResultDemo;
import com.prasad.androiddemo.Cards.CardDemo;
import com.prasad.androiddemo.DB.DBdemoActivity;
import com.prasad.androiddemo.ListViewDemo.ListWithArrayAdapter;
import com.prasad.androiddemo.ListViewDemo.ListWithCustomArrayAdapterViewHolder;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        // Simple array adapter

        Button btnArrayAdapter = (Button)findViewById(R.id.btnArrayAdapter);
        btnArrayAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inArrayAdapter = new Intent();
                inArrayAdapter.setClass(getApplicationContext(), ListWithArrayAdapter.class);
                startActivity(inArrayAdapter);

            }
        });

        // Custom Array adapter

        Button btnCustomArrayAdapter = (Button)findViewById(R.id.btnCustomArrayAdapter);
        btnCustomArrayAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inCustomArrayAdapter = new Intent(getApplicationContext(),ListWithCustomArrayAdapterViewHolder.class);
                startActivity(inCustomArrayAdapter);
            }
        });


        // Cursor adapter demo

        Button btnCursorAdapter = (Button)findViewById(R.id.btnCursorAdapter);
        btnCursorAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inCursorAdapter = new Intent(getApplicationContext(),DBdemoActivity.class);
                startActivity(inCursorAdapter);
            }
        });

        // cards demo

        Button btnCardsDemo = (Button)findViewById(R.id.btnCardDemo);
        btnCardsDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inCardDemo = new Intent(getApplicationContext(),CardDemo.class);
                startActivity(inCardDemo);
            }
        });

        // Action bar demo

        Button btnActionBar = (Button)findViewById(R.id.btnActionBarDemo);
        btnActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inActionBar = new Intent(getApplicationContext(),ActionBardemo.class);
                startActivity(inActionBar);
            }
        });


        // Activity for result

        Button btnActivityResult = (Button)findViewById(R.id.btnActivityResultDemo);
        btnActivityResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inActResult = new Intent(getApplicationContext(),ActivityForResultDemo.class);
                startActivity(inActResult);
            }
        });



    }




}
