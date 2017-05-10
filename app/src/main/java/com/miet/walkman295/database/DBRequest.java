package com.miet.walkman295.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.miet.walkman295.unirating.R;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boris on 10.05.2017.
 */

public class DBRequest {
    private static final String LOG_TAG = "db tag";
    DBHelper dbHelper;
    Context context;
    Cursor cursor;
    SQLiteDatabase sqLiteDatabase;
    List<University> universityList;
    List<Department> departmentList;
    List<Person> personList;

    public DBRequest(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public int getItemCount(String item) {
        cursor = sqLiteDatabase.query(item, null, null, null, null, null, null);
        int cnt = cursor.getCount();
        return cnt;
    }

    public List<University> getUniversityList() {

        cursor = sqLiteDatabase.query(DBHelper.TABLE_UNIVERSITY, null, null, null, null, null, null);
        universityList = new ArrayList<University>();

        if (cursor.moveToFirst()) {
            int idUniversityIndex = cursor.getColumnIndex(DBHelper.UNIVERSITY_ID);
            int nameUniversityIndex = cursor.getColumnIndex(DBHelper.UNIVERSITY_NAME);
            int cityUniversityIndex = cursor.getColumnIndex(DBHelper.UNIVERSITY_CITY);
            int phoneUniversityIndex = cursor.getColumnIndex(DBHelper.UNIVERSITY_PHONE_NUMBER);
            int addressUniversityIndex = cursor.getColumnIndex(DBHelper.UNIVERSITY_ADDRESS);
            int emailUniversityIndex = cursor.getColumnIndex(DBHelper.UNIVERSITY_EMAIL);
            int webUniversityIndex = cursor.getColumnIndex(DBHelper.UNIVERSITY_WEB);
            int ratingUniversityIndex = cursor.getColumnIndex(DBHelper.UNIVERSITY_RATING);
            int coordinate1UniversityIndex = cursor.getColumnIndex(DBHelper.UNIVERSITY_COORDINATE1);
            int coordinate2UniversityIndex = cursor.getColumnIndex(DBHelper.UNIVERSITY_COORDINATE2);

            do {
                University university = new University(cursor.getInt(idUniversityIndex), cursor.getString(nameUniversityIndex), cursor.getString(cityUniversityIndex),
                        cursor.getString(phoneUniversityIndex), cursor.getString(addressUniversityIndex), cursor.getString(emailUniversityIndex),
                        cursor.getString(webUniversityIndex), cursor.getString(ratingUniversityIndex), cursor.getString(coordinate1UniversityIndex),
                        cursor.getString(coordinate2UniversityIndex));

                universityList.add(university);
            } while (cursor.moveToNext());

        } else {
            Log.d(LOG_TAG, "Base haven't data");
        }
        return universityList;
    }

    public List<Department> getDepartment(String universityName) {
        cursor = sqLiteDatabase.query(DBHelper.TABLE_DEPARTMENT, null, "department_university = ?", new String[]{universityName}, null, null, null);
        departmentList = new ArrayList<Department>();

        if (cursor.moveToFirst()) {
            int idDepartmentIndex = cursor.getColumnIndex(DBHelper.DEPARTMENT_ID);
            int nameDepartmentIndex = cursor.getColumnIndex(DBHelper.DEPARTMENT_NAME);
            int infoDepartmentIndex = cursor.getColumnIndex(DBHelper.DEPARTMENT_INFO);
            int uniDepartmentIndex = cursor.getColumnIndex(DBHelper.DEPARTMENT_UNIVERSITY);

            do {
                Department department = new Department(cursor.getInt(idDepartmentIndex), cursor.getString(nameDepartmentIndex),
                        cursor.getString(infoDepartmentIndex), cursor.getString(uniDepartmentIndex));
                departmentList.add(department);
            } while (cursor.moveToNext());


        } else {
            Log.d(LOG_TAG, "Base haven't data");
        }

        return departmentList;
    }

    public List<Person> getPerson(String universityName) {
        cursor = sqLiteDatabase.query(DBHelper.TABLE_PERSON, null, "person_university = ?", new String[]{universityName}, null, null, null);
        personList = new ArrayList<Person>();
        if (cursor.moveToFirst()) {
            int idPersonIndex = cursor.getColumnIndex(DBHelper.PERSON_ID);
            int namePersonIndex = cursor.getColumnIndex(DBHelper.PERSON_NAME);
            int infoPersonIndex = cursor.getColumnIndex(DBHelper.PERSON_INFO);
            int uniPersonIndex = cursor.getColumnIndex(DBHelper.PERSON_UNIVERSITY);

            do {
                Person person = new Person(cursor.getInt(idPersonIndex), cursor.getString(namePersonIndex),
                        cursor.getString(infoPersonIndex), cursor.getString(uniPersonIndex));
                personList.add(person);

            } while (cursor.moveToNext());

        } else {
            Log.d(LOG_TAG, "Base haven't data");
        }
        return personList;
    }

}
