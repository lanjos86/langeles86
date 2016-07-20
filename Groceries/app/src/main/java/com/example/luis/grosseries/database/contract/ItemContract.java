package com.example.luis.grosseries.database.contract;

import android.provider.BaseColumns;

/**
 * Created by LUIS on 08/07/2016.
 */
public final class ItemContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public ItemContract() {}

    /* Inner class that defines the table contents */
    public static abstract class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "Item";
        public static final String COLUMN_NAME_ID = "Id";
        public static final String COLUMN_NAME_DESCRIPTION = "Description";
        public static final String COLUMN_NAME_PRICE = "Price";

    }

}
