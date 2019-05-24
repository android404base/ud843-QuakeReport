package com.example.android.quakereport;

public class Earthquake {

    private String mag;
    private String location;
    private String time;

    public Earthquake(String mag, String location, String time){
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

    public String getTime() {
        return time;
    }
}
