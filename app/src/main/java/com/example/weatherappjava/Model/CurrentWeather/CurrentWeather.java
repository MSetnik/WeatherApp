package com.example.weatherappjava.Model.CurrentWeather;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CurrentWeather {
    @SerializedName("name")
    private String city;
    private ArrayList<Weather> weather;
    private Main main;

    public CurrentWeather(String city,ArrayList<Weather> weathers, Main main) {
        this.weather = weathers;
        this.main = main;
        this.city = city;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public String getCity() {
        return city;
    }
}
