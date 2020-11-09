package com.example.weatherappjava.Model.CurrentWeather;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CurrentWeather {
    private Coord coord;
    private ArrayList<Weather> weather;
    private Main main;
    @SerializedName("dt")
    private String date;
    @SerializedName("name")
    private String cityName;

    public CurrentWeather(Coord coord, ArrayList<Weather> weather, Main main, String date, String cityName) {
        this.coord = coord;
        this.weather = weather;
        this.main = main;
        this.date = date;
        this.cityName = cityName;
    }

    public Coord getCoord() {
        return coord;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public Main getMainWeather() {
        return main;
    }

    public String getDate() {
        return date;
    }

    public String getCityName() {
        return cityName;
    }
}
