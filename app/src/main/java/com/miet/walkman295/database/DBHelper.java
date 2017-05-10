package com.miet.walkman295.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Boris on 10.05.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = "db tag";
    public static final String DATABASE_NAME = "university_data_base";
    public static final int DB_VERSION = 1;

    //University
    public static final String TABLE_UNIVERSITY = "university";
    public static final String UNIVERSITY_ID = "_id";
    public static final String UNIVERSITY_NAME = "university_name";
    public static final String UNIVERSITY_CITY = "university_city";
    public static final String UNIVERSITY_PHONE_NUMBER = "university_phone_number";
    public static final String UNIVERSITY_ADDRESS = "university_address";
    public static final String UNIVERSITY_EMAIL = "university_email";
    public static final String UNIVERSITY_WEB = "university_web";
    public static final String UNIVERSITY_RATING = "university_rating";
    public static final String UNIVERSITY_COORDINATE1 = "university_coordinate1";
    public static final String UNIVERSITY_COORDINATE2 = "university_coordinate2";

    //Department
    public static final String TABLE_DEPARTMENT="department";
    public static final String DEPARTMENT_ID="_id";
    public static final String DEPARTMENT_NAME="department_name";
    public static final String DEPARTMENT_INFO="department_info";
    public static final String DEPARTMENT_UNIVERSITY="department_university";

    //Person
    public static final String TABLE_PERSON="person";
    public static final String PERSON_ID="_id";
    public static final String PERSON_NAME="person_name";
    public static final String PERSON_INFO="person_info";
    public static final String PERSON_UNIVERSITY="person_university";

    //User
    public static final String TABLE_USER= "user";
    public static final String USER_ID="_id";
    public static final String USER_LOGIN="user_login";
    public static final String USER_EMAIL="user_email";
    public static final String USER_PASSWORD="user_password";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_UNIVERSITY + " ("
                + UNIVERSITY_ID + " integer primary key autoincrement,"
                + UNIVERSITY_NAME + " text,"
                + UNIVERSITY_CITY + " text,"
                + UNIVERSITY_PHONE_NUMBER + " text,"
                + UNIVERSITY_ADDRESS + " text,"
                + UNIVERSITY_EMAIL + " text,"
                + UNIVERSITY_WEB + " text,"
                + UNIVERSITY_RATING + " text,"
                + UNIVERSITY_COORDINATE1 + " text,"
                + UNIVERSITY_COORDINATE2 + " text" + ");");

        sqLiteDatabase.execSQL("create table " + TABLE_DEPARTMENT + " ("
                + DEPARTMENT_ID + " integer primary key autoincrement,"
                + DEPARTMENT_NAME + " text,"
                + DEPARTMENT_INFO + " text,"
                + DEPARTMENT_UNIVERSITY + " text" + ");");


        sqLiteDatabase.execSQL("create table " + TABLE_PERSON + " ("
                + PERSON_ID + " integer primary key autoincrement,"
                + PERSON_NAME + " text,"
                + PERSON_INFO + " text,"
                + PERSON_UNIVERSITY + " text" + ");");

        sqLiteDatabase.execSQL("create table " + TABLE_USER + " ("
                + USER_ID + " integer primary key autoincrement,"
                + USER_LOGIN + " text,"
                + USER_EMAIL + " text,"
                + USER_PASSWORD + " text" + ");");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_UNIVERSITY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DEPARTMENT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        this.onCreate(sqLiteDatabase);
    }
}
