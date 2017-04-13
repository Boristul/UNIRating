package com.miet.walkman295.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.ViewGroup;

import com.miet.walkman295.unirating.R;

public class Section1_1_InfoUNI extends Fragment {
    //View v;
    //ListView lvdata;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_info_univercity, container,
                false);

        ListView lvdata = (ListView) rootView.findViewById(R.id.list_info);
        String[] Array_for_List = getResources().getStringArray(R.array.info_universities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, Array_for_List);

        lvdata.setAdapter(adapter);

        //return rootView;
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //установка заголовка
        getActivity().setTitle(Section1_SelectUNI.nameUNI);
    }
}