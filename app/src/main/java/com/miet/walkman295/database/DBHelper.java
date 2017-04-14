package com.miet.walkman295.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Boris on 13.04.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = "my tag";
    public static final String DATABASE_NAME = "universityDB";
    public static final int DB_VERSION = 2;

    public static final String TABLE_UNIVERSITY = "university";

    public static final String UNIVERSITY_ID = "_id";
    public static final String UNIVERSITY_NAME = "university_name";
    public static final String UNIVERSITY_INFO = "university_info";
    public static final String UNIVERSITY_RATING = "university_rating";
    public static final String UNIVERSITY_COORDINATE = "university_coordinate";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_UNIVERSITY + " ("
                + UNIVERSITY_ID + " integer primary key autoincrement,"
                + UNIVERSITY_NAME + " text,"
                + UNIVERSITY_INFO + " text,"
                + UNIVERSITY_RATING + " text,"
                + UNIVERSITY_COORDINATE + " text" + ");");

        ContentValues contentValues = new ContentValues();




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_UNIVERSITY);
        this.onCreate(sqLiteDatabase);
    }
}