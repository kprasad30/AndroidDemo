package com.prasad.androiddemo.ListViewDemo;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.prasad.androiddemo.DB.DBdataSource;
import com.prasad.androiddemo.DB.Pdetails;
import com.prasad.androiddemo.R;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prasad on 15/04/15.
 */
public class ListWithCustomCursorAdapter extends Activity {

    DBdataSource dBdataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_array_adapter_layout);


        dBdataSource = new DBdataSource(this);
        try {
            dBdataSource.open();  // open DB connection
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // list view code
        ListView lsCustomArrayAdapter = (ListView) findViewById(R.id.listview_with_array);



        //List<Pdetails> values = dBdataSource.getAllDetails();
            Cursor listCursor = dBdataSource.getAllDetailsCursor();


        //add custom adapter

        CustomCursorAdapter customCursorAdapter = new CustomCursorAdapter(this,listCursor);
        lsCustomArrayAdapter.setAdapter(customCursorAdapter);


    }


    private static class ViewHolder{

        TextView  name;
        TextView surName;
        TextView age;


    }



    private class CustomCursorAdapter extends CursorAdapter{


        public CustomCursorAdapter(Context context, Cursor cursor) {
            super(context, cursor, 0);
        }



        // inflate layout & return that view
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {

            View convertView = LayoutInflater.from(context).inflate(R.layout.list_custom_array_item, parent, false);

            // to populate view holder
            ViewHolder holder = new ViewHolder();
            holder.name = (TextView)convertView.findViewById(R.id.txtLargeArray);
            holder.surName = (TextView)convertView.findViewById(R.id.txMediumArray);
            holder.age = (TextView)convertView.findViewById(R.id.txtSmallArray);
            convertView.setTag(holder);
            return convertView;


        }



        // bind data from cursor to textview
        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            // fill data using view holder
            ViewHolder holder = (ViewHolder)view.getTag();


            // extract values from cursor
            holder.name.setText(cursor.getString(cursor.getColumnIndexOrThrow("name")));
            holder.surName.setText(cursor.getString(cursor.getColumnIndexOrThrow("surname")));
            holder.age.setText(cursor.getString(cursor.getColumnIndexOrThrow("age")));


        }


    }



}
