package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false);
        }

        Earthquake currentItem = getItem(position);

        TextView twMag = (TextView) listItemView.findViewById(R.id.tv_mag);
        twMag.setText(currentItem.getMag());


        TextView tvLocation = (TextView) listItemView.findViewById(R.id.tv_location);
        tvLocation.setText(currentItem.getLocation());

        TextView tvTime = (TextView) listItemView.findViewById(R.id.tv_time);
        tvTime.setText(currentItem.getTime());


        View textContainer = listItemView.findViewById(R.id.text_background);
        int color = ContextCompat.getColor(getContext(),backgroundColor);
        textContainer.setBackgroundColor(color);

        return listItemView;


    }
}
