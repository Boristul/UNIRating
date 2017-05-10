package com.miet.walkman295.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.FragmentManager;

import com.miet.walkman295.database.DBHelper;
import com.miet.walkman295.database.DBRequest;
import com.miet.walkman295.database.University;
import com.miet.walkman295.unirating.R;

import java.util.List;

public class Section1_SelectUNI extends ListFragment {
    static String nameUNI = null;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
       DBRequest dbRequest = new DBRequest(getContext());
//        dbRequest.inputDB();
        String LOG_TAG = "my tag";
        int mCount = dbRequest.getItemCount(DBHelper.TABLE_DEPARTMENT);
        Log.d(LOG_TAG, "Text: " + mCount);

        //-----------------------------------------
       /* DBRequest dbRequest = new DBRequest(getContext());

        List<University> universities = dbRequest.getUniversityList();
        int i=0;
        String[]arrayNameOfUni= new String[universities.size()];
        for(University university: universities){
            arrayNameOfUni[i]=(university.getUniversity_name());
            i++;
        }*/

        //-----------------------------------------


        super.onActivityCreated(savedInstanceState);

        String[] Array_for_List = getResources().getStringArray(R.array.test_universities);

        ListAdapter adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, Array_for_List);
        setListAdapter(adapter);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // получаем текст нажатого элемента
        TextView textView = (TextView) v;
        nameUNI = textView.getText().toString();

        //переход между фрагментами
        Fragment fragment = new Section1_1_InfoUNI();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        //обработка нажатия кнопки "Назад"
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //установка заголовка
        getActivity().setTitle(getString(R.string.NavigationSectionFirst_List));
    }
}