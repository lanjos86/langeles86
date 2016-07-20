package com.example.luis.grosseries.slidingMenu.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luis.grosseries.R;
import com.example.luis.grosseries.listener.GotoGroceriesListClickListener;
import com.example.luis.grosseries.slidingMenu.model.NavDrawerItem;

/**
 * Created by LUIS on 08/07/2016.
 */


public class NavDrawerListAdapter extends BaseAdapter {

    private AppCompatActivity currentActivity;
    private ArrayList<NavDrawerItem> navDrawerItems;

    public NavDrawerListAdapter(AppCompatActivity currentActivity, ArrayList<NavDrawerItem> navDrawerItems){
        this.currentActivity = currentActivity;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    currentActivity.getApplicationContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

        imgIcon.setImageResource(navDrawerItems.get(position).getIcon());
        txtTitle.setText(navDrawerItems.get(position).getTitle());
        GotoGroceriesListClickListener gotoGroceriesListener = new GotoGroceriesListClickListener(this.currentActivity, navDrawerItems.get(position).getActivity());

        txtTitle.setOnClickListener(gotoGroceriesListener);
        imgIcon.setOnClickListener(gotoGroceriesListener);

        // displaying count
        // check whether it set visible or not
        if(navDrawerItems.get(position).getCounterVisibility()){
            txtCount.setText(navDrawerItems.get(position).getCount());
        }else{
            // hide the counter view
            txtCount.setVisibility(View.GONE);
        }

        return convertView;
    }

}