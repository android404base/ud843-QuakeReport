package com.example.android.quakereport;

public class Earthquake {

    private String mag;
    private String location;
    private long time;

    public Earthquake(String mag, String location, long time){
        this.mag = mag;
        this.location = location;
        this.time = time;
    }

    public String getMag() {
        return mag;
    }

    public String getLocation() {
        return location;
    }

    public long getTime() {
        return time;
    }
}
