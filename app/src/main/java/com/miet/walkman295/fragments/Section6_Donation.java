package com.miet.walkman295.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.miet.walkman295.unirating.R;

public class Section6_Donation extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_donation, container,
                false);

        Button PayPalButton = (Button) rootView.findViewById(R.id.paypal_button);
        Button YandexMoneyButton = (Button) rootView.findViewById(R.id.yandexmoney_button);
        Button WebMoneyButton = (Button) rootView.findViewById(R.id.webmoney_button);

        PayPalButton.setOnClickListener(this);
        YandexMoneyButton.setOnClickListener(this);
        WebMoneyButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //установка заголовка
        getActivity().setTitle(getString(R.string.NavigationDrawerDonation));
    }

    @Override
    public void onClick(View view) {
        Intent webIntent = null;
        switch (view.getId()) {
            case R.id.paypal_button:
                webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/ru/home"));
                startActivity(webIntent);
                break;
            case R.id.yandexmoney_button:
                webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://money.yandex.ru/start"));
                startActivity(webIntent);
                break;
            case R.id.webmoney_button:
                webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.webmoney.ru/"));
                startActivity(webIntent);
                break;
        }
    }
}