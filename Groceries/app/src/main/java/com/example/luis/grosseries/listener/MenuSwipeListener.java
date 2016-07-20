package com.example.luis.grosseries.listener;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.example.luis.grosseries.drawer.CustomBarDrawToggle;
import com.example.luis.grosseries.helper.MenuHelper;

/**
 * Created by LUIS on 08/07/2016.
 */
public class MenuSwipeListener implements View.OnTouchListener {

    private CustomBarDrawToggle actionBar;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private GestureDetector gestureDetector;
    private AppCompatActivity activity;

    public MenuSwipeListener (AppCompatActivity activity, CustomBarDrawToggle actionBar,DrawerLayout mDrawerLayout, ListView mDrawerList){
        this.gestureDetector = new GestureDetector(activity.getApplicationContext(), new GestureListener());
        this.actionBar = actionBar;
        this.mDrawerLayout = mDrawerLayout;
        this.mDrawerList = mDrawerList;
        this.activity = activity;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                    }
                    result = true;
                }
                else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
                }
                result = true;

            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public void onSwipeRight() {
        MenuHelper.displayView(0, activity, mDrawerLayout, mDrawerList);
    }

    public void onSwipeLeft() {
        MenuHelper.displayView(0, activity, mDrawerLayout, mDrawerList);
    }

    public void onSwipeTop() {
    }

    public void onSwipeBottom() {
    }
}
