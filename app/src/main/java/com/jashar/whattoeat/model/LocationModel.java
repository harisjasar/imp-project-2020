package com.jashar.whattoeat.model;

public class LocationModel {
    Long lat;
    Long lng;

    public LocationModel(Long lat, Long lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public Long getLng() {
        return lng;
    }

    public void setLng(Long lng) {
        this.lng = lng;
    }
}
