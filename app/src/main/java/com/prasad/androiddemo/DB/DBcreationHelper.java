package com.prasad.androiddemo.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Prasad on 13/04/15.
 */
public class DBcreationHelper extends SQLiteOpenHelper {

    // Database creation sql statement
    private static final String DATABASE_CREATE =     "CREATE TABLE " + DbSchemaContract.ClmPersonalDetails.TABLE_NAME + " ("
           + DbSchemaContract.ClmPersonalDetails._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
           + DbSchemaContract.ClmPersonalDetails.COLUMN_NAME + DbSchemaContract.TEXT_TYPE + DbSchemaContract.COMMA_SEP
           + DbSchemaContract.ClmPersonalDetails.COLUMN_SURNAME + DbSchemaContract.TEXT_TYPE + DbSchemaContract.COMMA_SEP
           + DbSchemaContract.ClmPersonalDetails.COLUMN_AGE + DbSchemaContract.TEXT_TYPE
           +  " )";


    private static final String DATABASE_DELETE ="DROP TABLE IF EXISTS "
           + DbSchemaContract.ClmPersonalDetails.TABLE_NAME ;




    public DBcreationHelper(Context context) {
        super(context, DbSchemaContract.DB_NAME, null, DbSchemaContract.DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DATABASE_DELETE);
        onCreate(db);

    }
}
