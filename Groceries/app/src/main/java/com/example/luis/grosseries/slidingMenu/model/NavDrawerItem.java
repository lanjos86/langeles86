package com.example.luis.grosseries.slidingMenu.model;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by LUIS on 08/07/2016.
 */
public class NavDrawerItem {

    private String title;
    private int icon;
    private String count = "0";
    private Class activity;
    // boolean to set visiblity of the counter
    private boolean isCounterVisible = false;

    public NavDrawerItem(){}

    public NavDrawerItem(String title, int icon, String activityPath){
        this.title = title;
        this.icon = icon;
        try{
            activity = Class.forName(activityPath);
        } catch (ClassNotFoundException e) {
            //bad class configuration
        }
    }

    public NavDrawerItem(String title, int icon, String activityPath, boolean isCounterVisible, String count){
        this.title = title;
        this.icon = icon;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }

    public String getTitle(){
        return this.title;
    }

    public int getIcon(){
        return this.icon;
    }

    public String getCount(){
        return this.count;
    }

    public boolean getCounterVisibility(){
        return this.isCounterVisible;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setIcon(int icon){
        this.icon = icon;
    }

    public void setCount(String count){
        this.count = count;
    }

    public void setCounterVisibility(boolean isCounterVisible){
        this.isCounterVisible = isCounterVisible;
    }
    public Class getActivity() {
        return activity;
    }
}
