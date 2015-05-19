package com.prasad.androiddemo.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prasad on 13/04/15.
 */
public class DBdataSource {

    private SQLiteDatabase db;
    private DBcreationHelper dbHelper;




    public DBdataSource(Context context){
        dbHelper = new DBcreationHelper(context);   // new DB gets created

    }

    // to get write access to DB
    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }



    // put values in DB
    public void createPdetails(String name,String surname, String age){

        Log.d("DBcreate",name+surname+age);

        // content value of column name & actual value
        ContentValues values = new ContentValues();
        values.put(DbSchemaContract.ClmPersonalDetails.COLUMN_NAME,name);
        values.put(DbSchemaContract.ClmPersonalDetails.COLUMN_SURNAME,surname);
        values.put(DbSchemaContract.ClmPersonalDetails.COLUMN_AGE,age);


        //insert values into table
        long newRowId;
        newRowId = db.insert(
                DbSchemaContract.ClmPersonalDetails.TABLE_NAME,
                null,
                values);
        Log.d("DBdataSourceAdd", String.valueOf(newRowId));

    }







    // get (view) values from DB  for arrayAdapter .. check next for cursorAdapter
    public List<Pdetails> getAllDetails(){

        // array list of objects
        ArrayList<Pdetails> details = new ArrayList<Pdetails>();

        // Define a projection that specifies which columns from the database
         String[] projection = {
                DbSchemaContract.ClmPersonalDetails._ID,
                DbSchemaContract.ClmPersonalDetails.COLUMN_NAME,
                 DbSchemaContract.ClmPersonalDetails.COLUMN_SURNAME,
                 DbSchemaContract.ClmPersonalDetails.COLUMN_AGE,
        };


        //get cursor : which is result of query
        Cursor cursor = db.query(
                DbSchemaContract.ClmPersonalDetails.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                     // The columns for the WHERE clause
                null,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // The sort order
        );


        cursor.moveToFirst();  // move cursor to first position

        //store values from cursor to list of java objects (details)
        while (!cursor.isAfterLast()){

            Pdetails pdetails = new Pdetails();   // create object instance & set all values

            String name = cursor.getString(cursor.getColumnIndexOrThrow(DbSchemaContract.ClmPersonalDetails.COLUMN_NAME));
            pdetails.setName(name);

            String surname = cursor.getString(cursor.getColumnIndexOrThrow(DbSchemaContract.ClmPersonalDetails.COLUMN_SURNAME));
            pdetails.setSurname(surname);

            String age = cursor.getString(cursor.getColumnIndexOrThrow(DbSchemaContract.ClmPersonalDetails.COLUMN_AGE));
            pdetails.setAge(age);

            details.add(pdetails);

            cursor.moveToNext();

        }

        return details;

    }



    public Cursor getAllDetailsCursor(){

        // array list of objects
        ArrayList<Pdetails> details = new ArrayList<Pdetails>();

        // Define a projection that specifies which columns from the database
        String[] projection = {
                DbSchemaContract.ClmPersonalDetails._ID,
                DbSchemaContract.ClmPersonalDetails.COLUMN_NAME,
                DbSchemaContract.ClmPersonalDetails.COLUMN_SURNAME,
                DbSchemaContract.ClmPersonalDetails.COLUMN_AGE,
        };


        //get cursor : which is result of query
        Cursor cursor = db.query(
                DbSchemaContract.ClmPersonalDetails.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                     // The columns for the WHERE clause
                null,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // The sort order
        );

        return cursor;

    }



    // update values in DB

    public void updatePdetails(String name,String surname, String age, int rowId){

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(DbSchemaContract.ClmPersonalDetails.COLUMN_NAME,name);
        values.put(DbSchemaContract.ClmPersonalDetails.COLUMN_SURNAME,surname);
        values.put(DbSchemaContract.ClmPersonalDetails.COLUMN_AGE,age);


        // Which row to update, based on the ID
        String selection = DbSchemaContract.ClmPersonalDetails._ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(rowId) };


        // update values
        int count = db.update(
                DbSchemaContract.ClmPersonalDetails.TABLE_NAME,
                values,                                     // values to update
                selection,                                  //The columns for the WHERE clause
                selectionArgs);                             //The values for the WHERE clause
;
        Log.d("DBdataSourceUpdate", String.valueOf(count));

    }




    // Delete values from DB
    public void deletePdetails(int rowId){


        // Which row to delete, based on the ID
        String selection = DbSchemaContract.ClmPersonalDetails._ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(rowId) };


        // update values
        db.delete(
                DbSchemaContract.ClmPersonalDetails.TABLE_NAME,
                selection,                                  //The columns for the WHERE clause
                selectionArgs);                             //The values for the WHERE clause

        Log.d("DBdataSourceDelete", "row deleted");

    }






}
