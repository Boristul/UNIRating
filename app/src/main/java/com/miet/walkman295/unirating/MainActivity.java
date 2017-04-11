package com.miet.walkman295.unirating;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.TextView;

import com.miet.walkman295.fragments.About_Section;
import com.miet.walkman295.fragments.App_Settings;
import com.miet.walkman295.fragments.Chat_Section;
import com.miet.walkman295.fragments.Donation_Section;
import com.miet.walkman295.fragments.Favourite_UNI;
import com.miet.walkman295.fragments.Help_Section;
import com.miet.walkman295.fragments.Select_UNI;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawer.openDrawer(GravityCompat.START);
        Fragment fragment = new Select_UNI();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_list) {
            fragment = new Select_UNI();
        } else if (id == R.id.nav_chat) {
            fragment = new Chat_Section();
        } else if (id == R.id.nav_favourite) {
            fragment = new Favourite_UNI();
        } else if (id == R.id.nav_settings) {
            fragment = new App_Settings();
        } else if (id == R.id.nav_help) {
            fragment = new Help_Section();
        } else if (id == R.id.nav_donation) {
            fragment = new Donation_Section();
        } else if (id == R.id.nav_about) {
            fragment = new About_Section();
        }

        //replacing the fragment
        if (fragment != null) {
            //TextView TV = (TextView) findViewById(R.id.start_text);
            //TV.setVisibility(View.GONE);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            //обработка нажатия кнопки "Назад"
            ft.addToBackStack(null);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
