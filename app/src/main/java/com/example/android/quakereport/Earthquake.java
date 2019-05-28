package com.example.android.quakereport;

public class Earthquake {

    private double mag;
    private String location;
    private long time;
    private String url;

    public Earthquake(double mag, String location, long time,String url){
        this.mag = mag;
        this.location = location;
        this.time = time;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

}
