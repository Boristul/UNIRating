package com.miet.walkman295.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.miet.walkman295.database.DBRequest;
import com.miet.walkman295.database.University;
import com.miet.walkman295.unirating.MapActivity;
import com.miet.walkman295.unirating.R;

import java.util.List;

public class Section1_1_InfoUNI extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_info_univercity, container,
                false);
//-----------DB test-------------------------------------

       DBRequest dbRequest = new DBRequest(getContext());
        /*int mCount = dbRequest.getItemCount();
        Log.d(LOG_TAG, "Text: " + mCount);*/

        List<University> universities = dbRequest.getUniversity();
        int i=0;
        String[]arrayNameOfUni= new String[universities.size()];
        for(University university: universities){
            arrayNameOfUni[i]=(university.getUniversity_city());
            i++;
        }
        //--------------------------------------------------------

        ListView lvdata = (ListView) rootView.findViewById(R.id.list_info);
        String[] Array_for_List = getResources().getStringArray(R.array.info_universities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, Array_for_List);
        lvdata.setAdapter(adapter);

        Button chatButton = (Button) rootView.findViewById(R.id.ToChatButton);
        chatButton.setOnClickListener(ToChatListener);

        Button favouriteButton = (Button) rootView.findViewById(R.id.ToFavouriteButton);
        favouriteButton.setOnClickListener(ToFavouriteListener);

        Button mapButton = (Button) rootView.findViewById(R.id.ToMapButton);
        mapButton.setOnClickListener(ToMapListener);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //установка заголовка
        getActivity().setTitle(Section1_SelectUNI.nameUNI);
    }

    private OnClickListener ToMapListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), MapActivity.class);
            startActivity(intent);
        }
    };

    private OnClickListener ToChatListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment = new Section2_Chat();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            //обработка нажатия кнопки "Назад"
            ft.addToBackStack(null);
            ft.commit();
        }
    };

    private OnClickListener ToFavouriteListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment = new Section3_Favourite();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            //обработка нажатия кнопки "Назад"
            ft.addToBackStack(null);
            ft.commit();
        }
    };
}