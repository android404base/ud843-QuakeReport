package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private Integer backgroundColor;

    public EarthquakeAdapter(Context context, int resource, List<Earthquake> objects,int backgroundColor) {
        super(context, resource, objects);
        this.backgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
