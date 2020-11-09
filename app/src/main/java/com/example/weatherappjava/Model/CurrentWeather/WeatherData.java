package com.example.weatherappjava.Model.CurrentWeather;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherData {
    @SerializedName("dt")
    private int date;
    private Main main;
    private ArrayList<Weather> weather;
    @SerializedName("dt_txt")
    private String dt_text;

    public WeatherData(int date, Main main, ArrayList<Weather> weather, String dt_text) {
        this.date = date;
        this.main = main;
        this.weather = weather;
        this.dt_text = dt_text;
    }

    public int getDate() {
        return date;
    }

    public Main getMain() {
        return main;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public String getDt_text() {
        return dt_text;
    }
}
