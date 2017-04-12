package com.miet.walkman295.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.FragmentManager;

import com.miet.walkman295.unirating.R;

public class Section1_SelectUNI extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
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
        String itemText = textView.getText().toString();

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