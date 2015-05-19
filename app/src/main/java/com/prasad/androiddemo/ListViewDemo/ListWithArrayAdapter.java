package com.prasad.androiddemo.ListViewDemo;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.prasad.androiddemo.R;

import java.util.ArrayList;

/**
 * Created by Prasad on 11/04/15.
 */
public class ListWithArrayAdapter extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.list_array_adapter_layout);
        ListView lsViewArray = (ListView)findViewById(R.id.listview_with_array);




        ArrayList<String> arList = new ArrayList<String>();
        arList.add("Hello");
        arList.add("new");
        arList.add("Listview");
        arList.add("with");
        arList.add("Simple");
        arList.add("ArrayAdapter");


        ArrayAdapter<String> arAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arList);

        lsViewArray.setAdapter(arAdapter);



    }


}
