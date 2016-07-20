package com.example.luis.grosseries.menu;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.luis.grosseries.R;
import com.example.luis.grosseries.drawer.CustomBarDrawToggle;
import com.example.luis.grosseries.helper.MenuHelper;
import com.example.luis.grosseries.listener.MenuSwipeListener;

/**
 * Created by LUIS on 19/07/2016.
 */
public class SwipeController {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private View menu;
    private AppCompatActivity activityToAddSwipe;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    public SwipeController(AppCompatActivity activity) {
        this.activityToAddSwipe = activity;
    }

    public void AddSwipe(Bundle savedInstanceState) {
        mDrawerList = (ListView) activityToAddSwipe.findViewById(R.id.list_slidermenu);
        mDrawerLayout = (DrawerLayout) activityToAddSwipe.findViewById(R.id.navMenu);
        menu = activityToAddSwipe.findViewById(R.id.navMenu);

        MenuHelper.initSwipe(activityToAddSwipe.getApplicationContext(),
                activityToAddSwipe,
                activityToAddSwipe.getTitle().toString(),
                activityToAddSwipe.getResources(),
                mDrawerLayout,
                mDrawerList,
                savedInstanceState);

        menu.setOnTouchListener(new MenuSwipeListener(this.activityToAddSwipe,
                (CustomBarDrawToggle) MenuHelper.getDrawerToggle(), mDrawerLayout, mDrawerList));
    }

    public ListView getmDrawerList() {
        return mDrawerList;
    }

    public DrawerLayout getmDrawerLayout() {
        return mDrawerLayout;
    }

    public View getMenu() { return menu; }
}
