package com.example.weatherappjava.Model.CurrentWeather;

import com.google.gson.annotations.SerializedName;

public class Coord {
    private float lat;
    @SerializedName("lon")
    private float lng;

    public Coord(float lat, float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }
}
