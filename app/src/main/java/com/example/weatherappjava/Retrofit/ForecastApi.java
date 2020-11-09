package com.example.weatherappjava.Retrofit;

import com.example.weatherappjava.Model.CurrentWeather.Forecast;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastApi {

    @GET("data/2.5/forecast?appid=48b3b26703a3c2c2928c9e15aedab762&lang=hr")
    Call<Forecast> getForecast(@Query("q") String cityName);
}
