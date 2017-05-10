package com.miet.walkman295.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Boris on 10.05.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = "db_tag";
    public static final String DATABASE_NAME = "university_data_base";
    public static final int DB_VERSION = 3;

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

/*        sqLiteDatabase.execSQL("create table " + TABLE_USER + " ("
                + USER_ID + " integer primary key autoincrement,"
                + USER_LOGIN + " text,"
                + USER_EMAIL + " text,"
                + USER_PASSWORD + " text" + ");");*/

        ContentValues contentValues=new ContentValues();
        contentValues.put(UNIVERSITY_NAME, "МГУ | Московский Государственный Университет");
        contentValues.put(UNIVERSITY_CITY, "Москва");
        contentValues.put(UNIVERSITY_PHONE_NUMBER, "+7 (495) 939-1000");
        contentValues.put(UNIVERSITY_ADDRESS, "м. Университет");
        contentValues.put(UNIVERSITY_EMAIL, "msu@msu.ru");
        contentValues.put(UNIVERSITY_WEB, "https://msu.ru");
        contentValues.put(UNIVERSITY_RATING, "1");
        contentValues.put(UNIVERSITY_COORDINATE1, "55.703935");
        contentValues.put(UNIVERSITY_COORDINATE2, "37.528669");
        sqLiteDatabase.insert(TABLE_UNIVERSITY, null, contentValues);

       contentValues=new ContentValues();
        contentValues.put(PERSON_NAME,"Виктор Антонович Садовничий");
        contentValues.put(PERSON_INFO,"Академик. Ректор МГУ.");
        contentValues.put(PERSON_UNIVERSITY,"МГУ | Московский Государственный Университет");
        sqLiteDatabase.insert(TABLE_PERSON, null, contentValues);

        contentValues=new ContentValues();
        contentValues.put(PERSON_NAME,"Гребенева Марина Евгеньевна");
        contentValues.put(PERSON_INFO,"Проректор — начальник Управления капитального строительства");
        contentValues.put(PERSON_UNIVERSITY,"МГУ | Московский Государственный Университет");
        sqLiteDatabase.insert(TABLE_PERSON, null, contentValues);

        contentValues=new ContentValues();
        contentValues.put(DEPARTMENT_NAME,"Механико–математический факультет");
        contentValues.put(DEPARTMENT_INFO,"И. о. декана — профессор Чубариков Владимир Николаевич");
        contentValues.put(DEPARTMENT_UNIVERSITY,"МГУ | Московский Государственный Университет");
        sqLiteDatabase.insert(TABLE_DEPARTMENT, null, contentValues);

        contentValues=new ContentValues();
        contentValues.put(DEPARTMENT_NAME,"Физический факультет");
        contentValues.put(DEPARTMENT_INFO,"Декан — профессор Сысоев Николай Николаевич");
        contentValues.put(DEPARTMENT_UNIVERSITY,"МГУ | Московский Государственный Университет");
        sqLiteDatabase.insert(TABLE_DEPARTMENT, null, contentValues);

//--------------------------------------------------------------------------
        contentValues=new ContentValues();
        contentValues.put(UNIVERSITY_NAME, "НИЯУ МИФИ | Московский Инженерно-Физический Институт ");
        contentValues.put(UNIVERSITY_CITY, "Москва");
        contentValues.put(UNIVERSITY_PHONE_NUMBER, "+7 (499) 324-21-11");
        contentValues.put(UNIVERSITY_ADDRESS, "115409, г. Москва, Каширское ш., 31.");
        contentValues.put(UNIVERSITY_EMAIL, "info@mephi.ru");
        contentValues.put(UNIVERSITY_WEB, "https://mephi.ru");
        contentValues.put(UNIVERSITY_RATING, "3");
        contentValues.put(UNIVERSITY_COORDINATE1, "55.6498682");
        contentValues.put(UNIVERSITY_COORDINATE2, "37.6644199");
        sqLiteDatabase.insert(TABLE_UNIVERSITY, null, contentValues);

        contentValues=new ContentValues();
        contentValues.put(PERSON_NAME,"Стриханов Михаил Николаевич");
        contentValues.put(PERSON_INFO,"Ректор МИФИ. тел. +7 (495) 788-56-99 ");
        contentValues.put(PERSON_UNIVERSITY,"МГУ | Московский Государственный Университет");
        sqLiteDatabase.insert(TABLE_PERSON, null, contentValues);

        contentValues=new ContentValues();
        contentValues.put(PERSON_NAME,"Яковлева Юлия Петровна");
        contentValues.put(PERSON_INFO,"Референт (приемная ректора).");
        contentValues.put(PERSON_UNIVERSITY,"МГУ | Московский Государственный Университет");
        sqLiteDatabase.insert(TABLE_PERSON, null, contentValues);

        contentValues=new ContentValues();
        contentValues.put(DEPARTMENT_NAME,"Институт ядерной физики и технологий (ИЯФиТ)");
        contentValues.put(DEPARTMENT_INFO,"Барбашина Наталья Сергеевна – и.о. директора");
        contentValues.put(DEPARTMENT_UNIVERSITY,"МГУ | Московский Государственный Университет");
        sqLiteDatabase.insert(TABLE_DEPARTMENT, null, contentValues);

        contentValues=new ContentValues();
        contentValues.put(DEPARTMENT_NAME,"Институт лазерных и плазменных технологий (ЛаПлаз)");
        contentValues.put(DEPARTMENT_INFO,"Кузнецов Андрей Петрович – и.о. директора");
        contentValues.put(DEPARTMENT_UNIVERSITY,"МГУ | Московский Государственный Университет");
        sqLiteDatabase.insert(TABLE_DEPARTMENT, null, contentValues);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_UNIVERSITY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DEPARTMENT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        this.onCreate(sqLiteDatabase);
    }
}
