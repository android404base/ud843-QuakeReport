package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private Integer backgroundColor;
    String originalLocation;
    String primaryLocation;
    String locationOffset;

    private static final String LOCATION_SEPARATOR = " of ";


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
        String formattedMagnitude = formatMagnitude(currentItem.getMag());
        twMag.setText(formattedMagnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) twMag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentItem.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        originalLocation = currentItem.getLocation();

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView tvLocationOffset = (TextView) listItemView.findViewById(R.id.tv_locationOffset);
        tvLocationOffset.setText(locationOffset);

        TextView tvPrimaryLocation = (TextView) listItemView.findViewById(R.id.tv_primaryLocation);
        tvPrimaryLocation.setText(primaryLocation);

        Date dateObject = new Date(currentItem.getTime());


        TextView tvDate = (TextView) listItemView.findViewById(R.id.tv_date);
        String formatedDate = formatDate(dateObject);
        tvDate.setText(formatedDate);

        TextView tvTime = (TextView) listItemView.findViewById(R.id.tv_time);
        String formatedTime = formatTime(dateObject);
        tvTime.setText(formatedTime);


        View textContainer = listItemView.findViewById(R.id.text_background);
        int color = ContextCompat.getColor(getContext(),backgroundColor);
        textContainer.setBackgroundColor(color);

        return listItemView;


    }


    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }


    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
