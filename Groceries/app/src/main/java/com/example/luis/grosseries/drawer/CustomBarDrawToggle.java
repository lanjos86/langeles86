package com.example.luis.grosseries.drawer;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;

/**
 * Created by LUIS on 08/07/2016.
 */
public class CustomBarDrawToggle extends ActionBarDrawerToggle {

    private Activity activity;

    public CustomBarDrawToggle(Activity activity,
                               DrawerLayout drawerLayout,
                               @StringRes int openDrawerContentDescRes,
                               @StringRes int closeDrawerContentDescRes) {
        super(activity, drawerLayout, openDrawerContentDescRes, closeDrawerContentDescRes);
        this.activity = activity;
    }

    public void onDrawerClosed(View view) {
        // calling onPrepareOptionsMenu() to show action bar icons
        this.activity.invalidateOptionsMenu();
    }

    public void onDrawerOpened(View drawerView) {
        // calling onPrepareOptionsMenu() to hide action bar icons
        this.activity.invalidateOptionsMenu();
    }
}
