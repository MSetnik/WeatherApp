package com.example.weatherappjava.Retrofit;

import com.example.weatherappjava.Model.CurrentWeather.CurrentWeather;
import com.example.weatherappjava.Model.CurrentWeather.Forecast;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrentWeatherApi {

    @GET("data/2.5/weather?appid=48b3b26703a3c2c2928c9e15aedab762&lang=hr")
    Call<CurrentWeather> getCurrentWeather(@Query("q") String cityName);
}
