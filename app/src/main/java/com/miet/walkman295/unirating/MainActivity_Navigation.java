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
import android.view.MenuItem;
import android.content.pm.ActivityInfo;

import com.miet.walkman295.fragments.Section7_AboutUs;
import com.miet.walkman295.fragments.Section4_Settings;
import com.miet.walkman295.fragments.Section2_Chat;
import com.miet.walkman295.fragments.Section6_Donation;
import com.miet.walkman295.fragments.Section3_Favourite;
import com.miet.walkman295.fragments.Section5_Help;
import com.miet.walkman295.fragments.Section1_SelectUNI;

public class MainActivity_Navigation extends AppCompatActivity
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
        Fragment fragment = new Section1_SelectUNI();
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
            fragment = new Section1_SelectUNI();
        } else if (id == R.id.nav_chat) {
            fragment = new Section2_Chat();
        } else if (id == R.id.nav_favourite) {
            fragment = new Section3_Favourite();
        } else if (id == R.id.nav_settings) {
            fragment = new Section4_Settings();
        } else if (id == R.id.nav_help) {
            fragment = new Section5_Help();
        } else if (id == R.id.nav_donation) {
            fragment = new Section6_Donation();
        } else if (id == R.id.nav_about) {
            fragment = new Section7_AboutUs();
        }

        //replacing the fragment
        if (fragment != null) {
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
