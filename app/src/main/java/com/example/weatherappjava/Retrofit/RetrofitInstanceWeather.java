package com.example.weatherappjava.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceWeather {
    private static Retrofit oInstance = null;

    public static Retrofit getInstance() {
        if (oInstance == null) {
            oInstance = new Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return oInstance;
    }
}
