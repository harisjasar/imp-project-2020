package com.jashar.whattoeat.model;

public class RestaurantNameLatLngModel {

    String mName;
    String mTag;
    double mLat;
    double mLng;


    public RestaurantNameLatLngModel() {
    }

    public RestaurantNameLatLngModel(String mName, String mTag, double mLat, double mLng) {
        this.mName = mName;
        this.mTag = mTag;
        this.mLat = mLat;
        this.mLng = mLng;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmTag() {
        return mTag;
    }

    public void setmTag(String mTag) {
        this.mTag = mTag;
    }

    public double getmLat() {
        return mLat;
    }

    public void setmLat(double mLat) {
        this.mLat = mLat;
    }

    public double getmLng() {
        return mLng;
    }

    public void setmLng(double mLng) {
        this.mLng = mLng;
    }
}