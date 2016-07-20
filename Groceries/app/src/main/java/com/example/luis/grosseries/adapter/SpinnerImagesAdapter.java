package com.example.luis.grosseries.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.luis.grosseries.R;

/**
 * Created by LUIS on 19/07/2016.
 */
public class SpinnerImagesAdapter extends ArrayAdapter<String> {
    private Context ctx;
    private String labels[];
    private TypedArray images;

    public SpinnerImagesAdapter(Context context, int resource, String[] objects,
                                TypedArray imageArray) {
        super(context,  resource, R.id.spinnerTextView, objects);
        this.ctx = context;
        this.labels = objects;
        this.images = imageArray;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.areaspinner, parent, false);

        ImageView imageView = (ImageView)row.findViewById(R.id.spinnerImages);
        imageView.setImageResource(images.getResourceId(position, -1));
        imageView.setLayoutParams(new TableRow.LayoutParams(60,60));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        TextView textView = (TextView) row.findViewById(R.id.spinnerTextView);
        textView.setText(labels[position]);


        return row;
    }
}
