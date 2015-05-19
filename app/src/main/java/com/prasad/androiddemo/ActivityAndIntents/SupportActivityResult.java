package com.prasad.androiddemo.ActivityAndIntents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.prasad.androiddemo.DB.DBdataSource;
import com.prasad.androiddemo.R;

import java.sql.SQLException;

/**
 * Created by Prasad on 03/05/15.
 */
public class SupportActivityResult extends Activity {

    DBdataSource dBdataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.adddata_layout);


        dBdataSource = new DBdataSource(this);
        try {
            dBdataSource.open();  // open DB connection
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // add values to DB
        Button btnAdd =(Button) findViewById(R.id.btnAddData);
        final EditText txtName = (EditText)findViewById(R.id.txtNameData);
        final EditText txtSurname = (EditText)findViewById(R.id.txtSurnameData);
        final EditText txtAge = (EditText)findViewById(R.id.txtAgeData);
        final EditText txtDeleteID = (EditText)findViewById(R.id.txtDeleteIDdata);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String surname = txtSurname.getText().toString();
                String age = txtAge.getText().toString();

                dBdataSource.createPdetails(name, surname, age);
                String msg = "values added";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

             //   SupportActivityResult.this.finish();

                Intent returnIntent = new Intent();
               // returnIntent.putExtra("1",result); // use it to send data
                setResult(RESULT_OK, returnIntent);
                finish();




            }
        });




        // delete values in DB
        Button btnDelete =(Button) findViewById(R.id.btnDeleteData);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deleteID =Integer.parseInt(txtDeleteID.getText().toString());

                dBdataSource.deletePdetails(deleteID);
                String msg = "values deleted";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

            //    SupportActivityResult.this.finish();


                Intent in = new Intent();
                in.putExtra("name","forts");
                setResult(RESULT_OK,in);
                finish();


            }
        });





    }
}
