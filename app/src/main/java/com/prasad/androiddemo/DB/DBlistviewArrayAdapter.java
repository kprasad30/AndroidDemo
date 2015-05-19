package com.prasad.androiddemo.DB;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.prasad.androiddemo.R;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prasad on 14/04/15.
 */
public class DBlistviewArrayAdapter extends Activity {
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

        List<Pdetails> values = dBdataSource.getAllDetails();



        //add custom adapter
        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(this, (ArrayList<Pdetails>) values);
        lsCustomArrayAdapter.setAdapter(customArrayAdapter);


    }


    private static class ViewHolder{

        TextView  name;
        TextView surName;
        TextView age;


    }


    public class CustomArrayAdapter extends ArrayAdapter<Pdetails> {




        public CustomArrayAdapter(Context context,ArrayList<Pdetails> addressList) {
            super(context,0,addressList );
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // for smooth scrolling view holder is recommended
            // refer custom adapter with view holder example


            // check if view exists
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_custom_array_item, parent, false);

                // to populate view holder
                ViewHolder holder = new ViewHolder();
                holder.name = (TextView)convertView.findViewById(R.id.txtLargeArray);
                holder.surName = (TextView)convertView.findViewById(R.id.txMediumArray);
                holder.age = (TextView)convertView.findViewById(R.id.txtSmallArray);
                convertView.setTag(holder);
            }


            // get object for position
            Pdetails details = getItem(position);

            // fill data using view holder
            ViewHolder holder = (ViewHolder)convertView.getTag();

            holder.name.setText(details.getName());
            holder.surName.setText(details.getSurname());
            holder.age.setText(String.valueOf(details.getAge()));


            return  convertView;


        }
    }
}
