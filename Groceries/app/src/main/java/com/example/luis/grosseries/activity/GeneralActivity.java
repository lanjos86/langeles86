package com.example.luis.grosseries.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.luis.grosseries.helper.MenuHelper;
import com.example.luis.grosseries.menu.SwipeController;

/**
 * Created by LUIS on 19/07/2016.
 */
public abstract class GeneralActivity extends AppCompatActivity {

    public abstract String getHashGuid();

    public abstract SwipeController getSwipeController();
    /***
     * Called when invalidateOptionsMenu() is triggered
     */

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = getSwipeController().getmDrawerLayout().isDrawerOpen(getSwipeController().getmDrawerList());
        return drawerOpen;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        MenuHelper.getDrawerToggle().syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        MenuHelper.getDrawerToggle().onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (MenuHelper.getDrawerToggle().onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            default:
                return this.onOptionsItemSelected(item);
        }
    }

}
