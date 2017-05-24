package com.miet.walkman295.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.miet.walkman295.unirating.R;

public class Section5_Help extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_help, container,
                false);

        Button sendButton = (Button) rootView.findViewById(R.id.help_button);
        sendButton.setOnClickListener(this);

        EditText ET = (EditText) rootView.findViewById(R.id.help_area);
        ET.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey (View v, int keyCode, KeyEvent event) {
                boolean consumed = false;
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    onClick(rootView);
                    consumed = true;
                }
                return consumed;
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //установка заголовка
        getActivity().setTitle(getString(R.string.NavigationSectionThird));
    }

    @Override
    public void onClick(View view)
    {
        Toast.makeText(getActivity(), "Сообщение отправлено",
                Toast.LENGTH_SHORT).show();
    }
}