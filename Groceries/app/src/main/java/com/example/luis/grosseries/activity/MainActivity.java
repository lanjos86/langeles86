package com.example.luis.grosseries.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.luis.grosseries.R;
import com.example.luis.grosseries.drawer.CustomBarDrawToggle;
import com.example.luis.grosseries.helper.MenuHelper;
import com.example.luis.grosseries.listener.MenuSwipeListener;
import com.example.luis.grosseries.menu.SwipeController;
import com.example.luis.grosseries.menu.SwipeControllerFactory;

import java.util.UUID;

public class MainActivity extends GeneralActivity {

    private static final String HASH_GUID = UUID.randomUUID().toString();
    private SwipeController swipeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeController = SwipeControllerFactory.getInstance(this);
        swipeController.AddSwipe(savedInstanceState);
    }

    public SwipeController getSwipeController() {
        return swipeController;
    }

    public String getHashGuid() {
        return HASH_GUID;
    }

}
