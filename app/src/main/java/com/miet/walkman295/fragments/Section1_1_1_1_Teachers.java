package com.miet.walkman295.fragments;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.miet.walkman295.database.DBRequest;
import com.miet.walkman295.database.Person;
import com.miet.walkman295.unirating.R;

import java.util.List;

/**
 * Created by walkman295 on 07.06.17.
 */

public class Section1_1_1_1_Teachers extends Fragment{
    public static final String LOG_TAG = "db_tag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_teachers, container,
                false);

        DBRequest dbRequest = new DBRequest(getContext());
        List<Person> teachers = dbRequest.getPerson(Section1_SelectUNI.nameUNI);
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getPerson_name().equals(Section1_1_1_SpecTeach.SpecTeach)) {
                ImageView teachIV = (ImageView) rootView.findViewById(R.id.teachPhoto);
                teachIV.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.icon));

                TextView teachNameTV = (TextView) rootView.findViewById(R.id.teachNamestring);
                teachNameTV.setText("Имя:" + ' ' + teachers.get(i).getPerson_name());

                TextView teachWorkTV = (TextView) rootView.findViewById(R.id.teachWorkstring);
                teachWorkTV.setText("Должность:" + ' ' + teachers.get(i).getPerson_info());

                TextView mailTV = (TextView) rootView.findViewById(R.id.teachContactstring);
                mailTV.setText("Контакты:" + ' ' + "Поле будет заполнено позднее");

                TextView webTV = (TextView) rootView.findViewById(R.id.teachFuturestring);
                webTV.setText("Прочее:" + ' ' + "Раздел будет дополняться");
            }
        }

        ListView dataLV = (ListView) rootView.findViewById(R.id.list_teach);
        String[] Array_for_List = getResources().getStringArray(R.array.test_teachers);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, Array_for_List);
        dataLV.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //установка заголовка
        getActivity().setTitle(Section1_1_1_SpecTeach.SpecTeach);
    }
}