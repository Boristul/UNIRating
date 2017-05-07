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

import com.miet.walkman295.database.DBRequest;
import com.miet.walkman295.database.University;
import com.miet.walkman295.unirating.R;

import java.util.List;

public class Section1_SelectUNI extends ListFragment {
    static String nameUNI = null;
DBRequest dbRequest;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //-----------DB test-------------------------------------

         dbRequest = new DBRequest(getContext());
        /*int mCount = dbRequest.getItemCount();
        Log.d(LOG_TAG, "Text: " + mCount);*/

        List<University> universities = dbRequest.getUniversity();
        int i=0;
        String[]arrayNameOfUni= new String[universities.size()];
        for(University university: universities){
arrayNameOfUni[i]=(university.getUniversity_name());
            i++;
        }
        //--------------------------------------------------------


        String[] Array_for_List = arrayNameOfUni;

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