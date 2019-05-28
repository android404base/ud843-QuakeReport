package com.example.android.quakereport;

public class Earthquake {

    private double mag;
    private String location;
    private long time;

    public Earthquake(double mag, String location, long time){
        this.mag = mag;
        this.location = location;
        this.time = time;
    }

    public double getMag() {
        return mag;
    }

    public String getLocation() {
        return location;
    }

    public long getTime() {
        return time;
    }
}
