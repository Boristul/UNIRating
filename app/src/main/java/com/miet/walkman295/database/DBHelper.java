package com.miet.walkman295.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.R.attr.version;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DbUNIRating";
    public static final String TABLE_UNIVERSITY="university";
    public static final String TABLE_PERSON="person";
    public static final String TABLE_DEPARTMENT="department";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_UNIVERSITY+" ("
                                        +"_id INTEGER PRIMARY KEY, "
                                        +"university_name TEXT, "
                                        +"university_info TEXT, "
                                        +"university_reting INTEGER, "
                                        +"university_coordinate TEXT"+");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.w("TestBase", "Upgrading database from version " + oldVersion
                + " to " + newVersion + ", which will destroy all old data");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_UNIVERSITY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DEPARTMENT);
        onCreate(sqLiteDatabase);
    }
}
