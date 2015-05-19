package com.prasad.androiddemo.ListViewDemo;

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

import java.util.ArrayList;

/**
 * Created by Prasad on 11/04/15.
 */
public class ListWithCustomArrayAdapter extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_array_adapter_layout);

        // List of addressbook objects

        ArrayList<Addressbook> addressbook = new ArrayList<Addressbook>();

        Addressbook a1 = new Addressbook();
        a1.setName("Prasad");
        a1.setAge(25);
        a1.setSurname("Kiok");

        Addressbook a2 = new Addressbook();
        a2.setName("Chinmay");
        a2.setAge(27);
        a2.setSurname("Matok");


        Addressbook a3 = new Addressbook();
        a3.setName("Atul");
        a3.setAge(27);
        a3.setSurname("Sahok");


        addressbook.add(a1);
        addressbook.add(a2);
        addressbook.add(a3);

        // list view code
        ListView lsCustomArrayAdapter = (ListView) findViewById(R.id.listview_with_array);

        //add custom adapter
        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(this,addressbook);
        lsCustomArrayAdapter.setAdapter(customArrayAdapter);


    }


    public class CustomArrayAdapter extends ArrayAdapter<Addressbook> {




        public CustomArrayAdapter(Context context,ArrayList<Addressbook> addressList) {
            super(context,0,addressList );
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // for smooth scrolling view holder is recommended
            // refer custom adapter with view holder example


            // check if view exists
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_custom_array_item, parent, false);
            }

            // define all controls

            TextView txtName = (TextView)convertView.findViewById(R.id.txtLargeArray);
            TextView txtSurname = (TextView)convertView.findViewById(R.id.txMediumArray);
            TextView txtAge = (TextView)convertView.findViewById(R.id.txtSmallArray);


            // get object for position
            Addressbook details = getItem(position);

            // set details
            txtName.setText(details.getName());
            txtSurname.setText(details.getSurname());
            txtAge.setText(String.valueOf(details.getAge()));


            return  convertView;


        }
    }



}
