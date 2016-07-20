package com.example.luis.grosseries.activity;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.luis.grosseries.R;
import com.example.luis.grosseries.adapter.SpinnerImagesAdapter;
import com.example.luis.grosseries.drawer.CustomBarDrawToggle;
import com.example.luis.grosseries.helper.MenuHelper;
import com.example.luis.grosseries.listener.AddCategoryClickListener;
import com.example.luis.grosseries.listener.MenuSwipeListener;
import com.example.luis.grosseries.menu.SwipeController;
import com.example.luis.grosseries.menu.SwipeControllerFactory;

import java.util.UUID;

public class NewGroceriesListActivity extends GeneralActivity {

    public static final String HASH_GUID = UUID.randomUUID().toString();
    private SwipeController swipeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_groceries_list);
        swipeController = SwipeControllerFactory.getInstance(this);
        swipeController.AddSwipe(savedInstanceState);

        ImageView addButton = (ImageView) findViewById(R.id.addGroceriesArea);
        addButton.setOnClickListener(new AddCategoryClickListener(this));
    }

    public SwipeController getSwipeController() {
        return swipeController;
    }

    public String getHashGuid() {
        return HASH_GUID;
    }
}
