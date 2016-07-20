package com.example.luis.grosseries.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luis.grosseries.R;

/**
 * Created by LUIS on 19/07/2016.
 */
public class GroceriesAreaFragment extends Fragment {

    public GroceriesAreaFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_groceries_area, container, false);
    }



}
