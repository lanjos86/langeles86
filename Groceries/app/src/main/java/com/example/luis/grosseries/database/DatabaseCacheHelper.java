package com.example.luis.grosseries.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import com.example.luis.grosseries.database.helper.GroceriesReaderDbHelper;
import com.example.luis.grosseries.utils.Constants;

/**
 * Created by LUIS on 08/07/2016.
 */
public class DatabaseCacheHelper
{
    public static GroceriesReaderDbHelper database = null;

    private static void init(Context context) {
        database = new GroceriesReaderDbHelper(context);
    }

    @Nullable
    public static SQLiteDatabase getDatabaseInstance(Context context, char mode) {
        if(database == null) {
            init(context);
        }
        switch (mode)
        {
            case Constants.READABLE: return database.getReadableDatabase();
            case Constants.WRITABLE: return database.getWritableDatabase();
        }

        return null;
    }

}
