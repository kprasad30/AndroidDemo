package com.prasad.androiddemo.ActivityAndIntents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.prasad.androiddemo.DB.DBdataSource;
import com.prasad.androiddemo.R;

import java.sql.SQLException;

/**
 * Created by Prasad on 03/05/15.
 */
public class ActivityForResultDemo extends Activity {

    // to extend listview & add something & refresh listview while coming back

    DBdataSource dBdataSource;
    static final int REQUEST_CODE_DEMO = 1;  // The request code
    CustomCursorAdapter customCursorAdapter;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_layout);

        Button btnAdd = (Button)findViewById(R.id.btnAddData);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inAddActivity = new Intent(getApplicationContext(),SupportActivityResult.class);
                //startActivity(inAddActivity);
                startActivityForResult(inAddActivity, REQUEST_CODE_DEMO);


            }
        });



        dBdataSource = new DBdataSource(this);
        try {
            dBdataSource.open();  // open DB connection
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // list view code
        ListView lsCustomArrayAdapter = (ListView) findViewById(R.id.listData);



        //List<Pdetails> values = dBdataSource.getAllDetails();
        Cursor listCursor = dBdataSource.getAllDetailsCursor();


        //add custom adapter

        CustomCursorAdapter customCursorAdapter = new CustomCursorAdapter(this,listCursor);
        lsCustomArrayAdapter.setAdapter(customCursorAdapter);



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==REQUEST_CODE_DEMO)
        {
            if(resultCode == Activity.RESULT_OK ){
                String test = data.getStringExtra("name");
                Toast.makeText(getApplicationContext(),test,Toast.LENGTH_LONG).show();
                customCursorAdapter.notifyDataSetChanged();
                //    mRecyclerView.notify();

            }

        }



    }








    private static class ViewHolder{

        TextView name;
        TextView surName;
        TextView age;


    }








    private class CustomCursorAdapter extends CursorAdapter {


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
