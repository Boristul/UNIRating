package com.miet.walkman295.fragments;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.miet.walkman295.database.DBRequest;
import com.miet.walkman295.database.University;
import com.miet.walkman295.unirating.MapActivity;
import com.miet.walkman295.unirating.R;
import com.miet.walkman295.unirating.Section1_1_1_Statistics;

import java.util.List;


public class Section1_1_InfoUNI extends Fragment {
    public static final String LOG_TAG = "db_tag";
    static String section = null;
    String coordinate1 = null;
    String coordinate2 = null;
    String name=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_info_university, container,
                false);

        DBRequest dbRequest = new DBRequest(getContext());
        List<University> universities = dbRequest.getUniversityList();
        for (int i=0; i<universities.size(); i++)
        {
            if (universities.get(i).getUniversity_name().equals(Section1_SelectUNI.nameUNI))
            {

                ImageView teachIV = (ImageView) rootView.findViewById(R.id.UNIPhoto);
                teachIV.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_uni));

                TextView ratingTV = (TextView) rootView.findViewById(R.id.ratingUNIstring);
                ratingTV.setText(universities.get(i).getUniversity_rating());

                TextView addressTV = (TextView) rootView.findViewById(R.id.addressUNIstring);
                addressTV.setText("Адрес:"+' '+universities.get(i).getUniversity_city()+' '+
                        universities.get(i).getUniversity_address());

                TextView phoneTV = (TextView) rootView.findViewById(R.id.phoneUNIstring);
                phoneTV.setText("Телефон:"+' '+universities.get(i).getUniversity_phone_number());

                TextView mailTV = (TextView) rootView.findViewById(R.id.mailUNIstring);
                mailTV.setText("E-mail:"+' '+universities.get(i).getUniversity_email());

                TextView webTV = (TextView) rootView.findViewById(R.id.webUNIstring);
                webTV.setText("Web-сайт:"+' '+universities.get(i).getUniversity_web());

                coordinate1 = universities.get(i).getUniversity_coordinate1();
                coordinate2 = universities.get(i).getUniversity_coordinate2();
                name=universities.get(i).getUniversity_name();
            }
        }

        ListView dataLV = (ListView) rootView.findViewById(R.id.list_info);
        String[] Array_for_List = getResources().getStringArray(R.array.info_universities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, Array_for_List);
        dataLV.setAdapter(adapter);

        dataLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                TextView textView = (TextView) view;
                section = textView.getText().toString();

                if (section.equals("Статистика"))
                {
                    Intent intent = new Intent(getActivity(), Section1_1_1_Statistics.class);
                    startActivity(intent);
                } else
                {
                    Fragment fragment = new Section1_1_1_SpecTeach();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    //обработка нажатия кнопки "Назад"
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }
        });

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
            intent.putExtra("c3",name);
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