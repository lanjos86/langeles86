package com.example.luis.grosseries.listener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.luis.grosseries.activity.NewGroceriesListActivity;

/**
 * Created by LUIS on 18/07/2016.
 */
public class GotoGroceriesListClickListener implements View.OnClickListener {

    AppCompatActivity fromActivity = new AppCompatActivity();
    Class toActivity;

    public GotoGroceriesListClickListener(AppCompatActivity fromActivity, Class toActivity) {
        this.fromActivity = fromActivity;
        this.toActivity = toActivity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this.fromActivity, toActivity);
        fromActivity.startActivity(intent);
    }
}
