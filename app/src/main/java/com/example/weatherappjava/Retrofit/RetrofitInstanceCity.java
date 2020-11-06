package com.example.weatherappjava.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceCity {
    private static Retrofit oInstance = null;

    public static Retrofit getInstance() {
        if (oInstance == null) {
            oInstance = new Retrofit.Builder()
                    .baseUrl("https://public.opendatasoft.com/api/records/1.0/search/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return oInstance;
    }
}
