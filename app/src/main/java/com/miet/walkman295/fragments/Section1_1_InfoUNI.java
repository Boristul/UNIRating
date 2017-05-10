package com.miet.walkman295.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.miet.walkman295.database.DBHelper;
import com.miet.walkman295.database.DBRequest;
import com.miet.walkman295.database.University;
import com.miet.walkman295.unirating.MainActivity_Navigation;
import com.miet.walkman295.unirating.MapActivity;
import com.miet.walkman295.unirating.R;

import java.util.List;


public class Section1_1_InfoUNI extends Fragment {
    public static final String LOG_TAG = "db_tag";
    String coordinate1 = null;
    String coordinate2 = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_info_univercity, container,
                false);

        DBRequest dbRequest = new DBRequest(getContext());
        List<University> universities = dbRequest.getUniversityList();
        for (int i=0; i<universities.size(); i++)
        {
            if (universities.get(i).getUniversity_name().equals(Section1_SelectUNI.nameUNI))
            {
                /*TextView TVname = (TextView) rootView.findViewById(R.id.nameUNIstring);
                TV.setText(universities.get(i).getUniversity_name()+"\n\n"
                        +universities.get(i).getUniversity_city());*/

                TextView TVrating = (TextView) rootView.findViewById(R.id.ratingUNIstring);
                TVrating.setText(universities.get(i).getUniversity_rating());

                TextView TVaddress = (TextView) rootView.findViewById(R.id.addressUNIstring);
                TVaddress.setText("Адрес: "+universities.get(i).getUniversity_city()+' '+
                        universities.get(i).getUniversity_address());

                TextView TVphone = (TextView) rootView.findViewById(R.id.phoneUNIstring);
                TVphone.setText("Телефон: "+universities.get(i).getUniversity_phone_number());

                TextView TVmail = (TextView) rootView.findViewById(R.id.mailUNIstring);
                TVmail.setText("E-mail: "+universities.get(i).getUniversity_email());

                TextView TVweb = (TextView) rootView.findViewById(R.id.webUNIstring);
                TVweb.setText("Web-сайт: "+universities.get(i).getUniversity_web());

                coordinate1 = universities.get(i).getUniversity_coordinate1();
                coordinate2 = universities.get(i).getUniversity_coordinate2();
            }
        }

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
            intent.putExtra("c1", coordinate1);
            intent.putExtra("c2", coordinate2);
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