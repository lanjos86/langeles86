package com.example.luis.grosseries.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by LUIS on 20/07/2016.
 */
public class CategoriesListHelper {

    private static TreeSet<Integer> categoriesSelected;

    public static void init() {
        if(categoriesSelected == null) {
            categoriesSelected = new TreeSet<Integer>();
        }
    }

    public static void addCategory(int id) {
        categoriesSelected.add(id);
    }
    public static boolean hasCategory(int id) {
        return categoriesSelected.contains(id);
    }
    public static TreeSet<Integer> getCategories() {
        return categoriesSelected;
    }

    public static void reset() {
        categoriesSelected = null;
        init();
    }
}
