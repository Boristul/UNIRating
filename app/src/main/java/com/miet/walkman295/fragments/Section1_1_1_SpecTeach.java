package com.miet.walkman295.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.miet.walkman295.database.DBRequest;
import com.miet.walkman295.database.Department;
import com.miet.walkman295.database.Person;
import com.miet.walkman295.unirating.R;

import java.util.List;

/**
 * Created by walkman295 on 11.05.17.
 */

public class Section1_1_1_SpecTeach extends ListFragment
{
    static String SpecTeach = null;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DBRequest dbRequest = new DBRequest(getContext());

        if (Section1_1_InfoUNI.section.equals("Преподаватели"))
        {
            List<Person> persons= dbRequest.getPerson(Section1_SelectUNI.nameUNI);
            String[] arrayPerson = new String[persons.size()];
            int i=0;
            for(Person person: persons){
                arrayPerson[i]=(person.getPerson_name());
                i++;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, arrayPerson);
            setListAdapter(adapter);
        } else if (Section1_1_InfoUNI.section.equals("Факультеты"))
        {
            List<Department> departments= dbRequest.getDepartment(Section1_SelectUNI.nameUNI);
            String[] arrayDepartment = new String[departments.size()];
            int i=0;
            for(Department department: departments){
                arrayDepartment[i]=(department.getDepartment_name());
                i++;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, arrayDepartment);
            setListAdapter(adapter);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_dep_per, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //установка заголовка
        getActivity().setTitle(Section1_1_InfoUNI.section);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // получаем текст нажатого элемента
        TextView textView = (TextView) v;
        SpecTeach = textView.getText().toString();

        Fragment fragment = null;
        //переход между фрагментами
        if (Section1_1_InfoUNI.section.equals("Преподаватели"))
        {
           fragment = new Section1_1_1_1_Teachers();
        } else if (Section1_1_InfoUNI.section.equals("Факультеты"))
        {
           fragment = new Section1_1_1_1_Specialty();
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        //обработка нажатия кнопки "Назад"
        ft.addToBackStack(null);
        ft.commit();
    }
}