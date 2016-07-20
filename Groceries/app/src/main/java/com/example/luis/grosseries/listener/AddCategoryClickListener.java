package com.example.luis.grosseries.listener;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.view.ScrollingView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.example.luis.grosseries.R;
import com.example.luis.grosseries.adapter.SpinnerImagesAdapter;

/**
 * Created by LUIS on 19/07/2016.
 */
public class AddCategoryClickListener implements View.OnClickListener {

    private AppCompatActivity activity;

    public AddCategoryClickListener(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Spinner spinner = new Spinner(this.activity);
        TypedArray areasImgs = this.activity.getResources().obtainTypedArray(R.array.areas_spinner_img);
        String[] areasLabels = this.activity.getResources().getStringArray(R.array.areas_spinner_content);
        SpinnerImagesAdapter areasLabelsAdapter = new SpinnerImagesAdapter(activity, spinner.getId(), areasLabels, areasImgs);
        spinner.setAdapter(areasLabelsAdapter);

        RelativeLayout layout = (RelativeLayout) this.activity.findViewById(R.id.categories_list);

        int nextIndex = layout.getChildCount();

        RelativeLayout.LayoutParams style = new RelativeLayout.LayoutParams(400, 100);
        if(nextIndex > 0) {

            style.setMargins(0,nextIndex * 100,0,0);
        }
        spinner.setLayoutParams(style);

        layout.addView(spinner, nextIndex);

    }
}
