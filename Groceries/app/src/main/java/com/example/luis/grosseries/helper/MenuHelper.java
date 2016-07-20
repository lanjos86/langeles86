package com.example.luis.grosseries.helper;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.luis.grosseries.R;
import com.example.luis.grosseries.drawer.CustomBarDrawToggle;
import com.example.luis.grosseries.fragment.MenuFragment;
import com.example.luis.grosseries.listener.MenuSwipeListener;
import com.example.luis.grosseries.slidingMenu.adapter.NavDrawerListAdapter;
import com.example.luis.grosseries.slidingMenu.model.NavDrawerItem;

import java.util.ArrayList;

/**
 * Created by LUIS on 08/07/2016.
 */
public class MenuHelper {

    // nav drawer title
    private static CharSequence mDrawerTitle;

    // slide menu items
    private static String[] navMenuActivities;
    private static String[] navMenuTitles;
    private static TypedArray navMenuIcons;

    private static ArrayList<NavDrawerItem> navDrawerItems;
    private static NavDrawerListAdapter adapter;
    private static CustomBarDrawToggle swipeMenu;


    public static void initSwipe(Context ctx, AppCompatActivity activity,
                            String title,
                            Resources resources,
                            DrawerLayout drawerLayout,
                            ListView mDrawerList,
                            Bundle savedInstanceState) {

        // load slide menu items
        navMenuTitles = resources.getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        navMenuIcons = resources.obtainTypedArray(R.array.nav_drawer_imgs);

        navMenuActivities = resources.getStringArray(R.array.nav_drawer_activities);

        navDrawerItems = new ArrayList<NavDrawerItem>();
        // adding nav drawer items to array
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1), navMenuActivities[0]));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1), navMenuActivities[1]));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1), navMenuActivities[2]));

        // Recycle the typed array
        navMenuIcons.recycle();

        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(activity, navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeButtonEnabled(true);

        swipeMenu = new CustomBarDrawToggle(activity, drawerLayout,  R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(swipeMenu);

    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    public static void displayView(int position, AppCompatActivity activity, DrawerLayout drawerLayout, ListView mDrawerList) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MenuFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            activity.setTitle(navMenuTitles[position]);
            drawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    public static ActionBarDrawerToggle getDrawerToggle() {
        return swipeMenu;
    }

}
