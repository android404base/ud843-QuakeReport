package com.example.android.quakereport;

public class Earthquake {

    private int mag;
    private String location;
    private long time;

    public Earthquake(int mag, String location, long time){
        this.mag = mag;
        this.location = location;
        this.time = time;
    }

    public int getMag() {
        return mag;
    }

    public String getLocation() {
        return location;
    }

    public long getTime() {
        return time;
    }
}
