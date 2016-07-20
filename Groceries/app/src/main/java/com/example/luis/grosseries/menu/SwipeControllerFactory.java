package com.example.luis.grosseries.menu;

import android.support.v7.app.AppCompatActivity;

import com.example.luis.grosseries.activity.GeneralActivity;

import java.util.HashMap;

/**
 * Created by LUIS on 19/07/2016.
 */
public class SwipeControllerFactory {

    private static HashMap<String, SwipeController> swipeController;

    public static SwipeController getInstance(GeneralActivity activity)
    {
        if(swipeController == null) {
            swipeController = new HashMap<String, SwipeController>();
        }

        if(!swipeController.containsKey(activity.getHashGuid())) {
            swipeController.put(activity.getHashGuid(), new SwipeController((AppCompatActivity) activity));
        }

        return swipeController.get(activity.getHashGuid());
    }

}
