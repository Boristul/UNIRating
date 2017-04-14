package com.miet.walkman295.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.miet.walkman295.fragments.Section1_SelectUNI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boris on 13.04.2017.
 */

public class DBRequest {
    private static final String LOG_TAG = "my tag";
    DBHelper dbHelper;
    Context context;
    Cursor cursor;
    SQLiteDatabase sqLiteDatabase;
    List<University> mUniversityList;

    public DBRequest(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }



    public int getItemCount() {

        cursor = sqLiteDatabase.query(DBHelper.TABLE_UNIVERSITY, null, null, null, null, null, null);
        int cnt = cursor.getCount();
        return cnt;
    }

    public List<University> getUniversity() {

        cursor = sqLiteDatabase.query(DBHelper.TABLE_UNIVERSITY, null, null, null, null, null, null);
        mUniversityList = new ArrayList<University>();

        if (cursor.moveToFirst()) {
            int idUniversityIndex = cursor.getColumnIndex(dbHelper.UNIVERSITY_ID);
            int nameUniversityIndex = cursor.getColumnIndex(dbHelper.UNIVERSITY_NAME);
            int infoUniversityIndex = cursor.getColumnIndex(dbHelper.UNIVERSITY_INFO);
            int ratingUniversityIndex = cursor.getColumnIndex(dbHelper.UNIVERSITY_RATING);
            int coordinateUniversityIndex = cursor.getColumnIndex(dbHelper.UNIVERSITY_COORDINATE);

            do {
                University university = new University(cursor.getInt(idUniversityIndex), cursor.getString(nameUniversityIndex),
                        cursor.getString(infoUniversityIndex), cursor.getString(ratingUniversityIndex), cursor.getString(coordinateUniversityIndex));
                mUniversityList.add(university);
            } while (cursor.moveToNext());
        } else {
            Log.d(LOG_TAG, "Base haven't data");
        }
        cursor.close();
        return mUniversityList;
    }

    public void close() {
        dbHelper.close();
        sqLiteDatabase.close();
    }
}
