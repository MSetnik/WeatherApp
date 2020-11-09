package com.example.weatherappjava.Model.CurrentWeather;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Forecast {
    @SerializedName("list")
    private ArrayList<WeatherData> weatherData;
    @SerializedName("city")
    private City city;
    public Forecast(ArrayList<WeatherData>  weathers, City city) {
        this.weatherData = weathers;
        this.city = city;
    }


    public ArrayList<WeatherData>  getWeatherData() {
        return weatherData;
    }

    public City getCity() {
        return city;
    }
}
