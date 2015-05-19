package com.prasad.androiddemo.DB;

import android.provider.BaseColumns;

/**
 * Created by Prasad on 13/04/15.
 */
public final class DbSchemaContract {

    public DbSchemaContract(){}   // to avoid making instance of it

    public static final String DB_NAME = "PersonalDetails.db";
    public static final int DB_VERSION = 1;       // should be incremented after each upgrade
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";



    // create new class for each column
    public static abstract class ClmPersonalDetails implements BaseColumns{

        public static final String TABLE_NAME = "personal_details";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SURNAME = "surname";
        public static final String COLUMN_AGE = "age";

    }

}
