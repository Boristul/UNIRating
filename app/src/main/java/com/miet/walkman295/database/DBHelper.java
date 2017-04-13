package com.miet.walkman295.database;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.miet.walkman295.unirating.R;

import java.io.IOException;

import static android.R.attr.version;

public class DBHelper extends SQLiteOpenHelper {
    private final Context fContext;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DbUNIRating";
    public static final String TABLE_UNIVERSITY = "university";
    public static final String TABLE_PERSON = "person";
    public static final String TABLE_DEPARTMENT = "department";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        fContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_UNIVERSITY + " ("
                + "_id INTEGER PRIMARY KEY, "
                + "university_name TEXT, "
                + "university_info TEXT, "
                + "university_rating INTEGER, "
                + "university_coordinate TEXT" + ");");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PERSON + " ("
                + "_id INTEGER PRIMARY KEY, "
                + "person_name TEXT, "
                + "person_info TEXT, "
                + "uni_name TEXT" + ");");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DEPARTMENT + " ("
                + "_id INTEGER PRIMARY KEY, "
                + "department_name TEXT, "
                + "department_info TEXT, "
                + "uni_name TEXT" + ");");

        ContentValues contentValues = new ContentValues();
        //алгоритм считывания xml файла
        Resources res = fContext.getResources();
        XmlResourceParser _xml = res.getXml(R.xml.miet);
        try {
            int eventType = _xml.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (_xml.getName()) {
                    case "university":
                        if (eventType == XmlPullParser.START_TAG) {
                            contentValues.clear();
                            contentValues.put("university_name",_xml.getAttributeValue(0));
                            contentValues.put("university_info",_xml.getAttributeValue(1));
                            contentValues.put("university_rating",_xml.getAttributeValue(2));
                            contentValues.put("university_coordinate",_xml.getAttributeValue(3));
                            sqLiteDatabase.insert(TABLE_UNIVERSITY,null,contentValues);
                        }
                        eventType=_xml.next();
                        break;
                    case "person":
                        if (eventType == XmlPullParser.START_TAG) {
                            contentValues.clear();
                            contentValues.put("person_name",_xml.getAttributeValue(0));
                            contentValues.put("person_info",_xml.getAttributeValue(1));
                            contentValues.put("uni_name",_xml.getAttributeValue(2));
                            sqLiteDatabase.insert(TABLE_PERSON,null,contentValues);
                        }
                        eventType=_xml.next();
                        break;
                    case "department":
                        if (eventType == XmlPullParser.START_TAG) {
                            contentValues.clear();
                            contentValues.put("department_name",_xml.getAttributeValue(0));
                            contentValues.put("department_info",_xml.getAttributeValue(1));
                            contentValues.put("uni_name",_xml.getAttributeValue(2));
                            sqLiteDatabase.insert(TABLE_PERSON,null,contentValues);
                        }
                        eventType=_xml.next();
                        break;
                }
            }

        } catch (XmlPullParserException e) {
            Log.e("Test", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("Test", e.getMessage(), e);

        } finally {
            // Close the xml file
            _xml.close();
        }
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
