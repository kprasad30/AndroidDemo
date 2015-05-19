package com.prasad.androiddemo.DB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.prasad.androiddemo.ListViewDemo.ListWithCustomCursorAdapter;
import com.prasad.androiddemo.R;

import java.sql.SQLException;

/**
 * Created by Prasad on 14/04/15.
 */
public class DBdemoActivity extends Activity {

    DBdataSource dBdataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dbdemo_layout);
        dBdataSource = new DBdataSource(this);
        try {
            dBdataSource.open();  // open DB connection
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // add values to DB
        Button btnAdd =(Button) findViewById(R.id.btnAdd);
        final EditText txtName = (EditText)findViewById(R.id.txtName);
        final EditText txtSurname = (EditText)findViewById(R.id.txtSurname);
        final EditText txtAge = (EditText)findViewById(R.id.txtAge);
        final EditText txtUpdateID = (EditText)findViewById(R.id.txtUpdateID);
        final EditText txtDeleteID = (EditText)findViewById(R.id.txtDeleteID);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String surname = txtSurname.getText().toString();
                String age = txtAge.getText().toString();

                dBdataSource.createPdetails(name,surname,age);
                String msg = "values added";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();


            }
        });



        // updates values in DB
        Button btnUpdate =(Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtName.getText().toString();
                String surname = txtSurname.getText().toString();
                String age = txtAge.getText().toString();
                String updateID =txtUpdateID.getText().toString();

                dBdataSource.updatePdetails(name,surname,age,Integer.parseInt(updateID));
                String msg = "values updated";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

            }
        });




        // delete values in DB
        Button btnDelete =(Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deleteID =Integer.parseInt(txtDeleteID.getText().toString());

                dBdataSource.deletePdetails(deleteID);
                String msg = "values deleted";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });



        // view list
        Button btnView =(Button) findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             // for customArrayAdaptor
             // Intent inCustomArrayAdapter = new Intent(getApplicationContext(),DBlistviewArrayAdapter.class);


                Intent inCustomCursorAdapter = new Intent(getApplicationContext(),ListWithCustomCursorAdapter.class);
                startActivity(inCustomCursorAdapter);

            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        dBdataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            dBdataSource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
