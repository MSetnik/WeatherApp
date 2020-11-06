package com.example.weatherappjava.Retrofit;

import com.example.weatherappjava.Model.CitySearch.City;
import com.example.weatherappjava.Model.CitySearch.Records;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CityApi {

    @GET("?dataset=geonames-all-cities-with-a-population-1000&q=Valpovo")
    Call<Records> getCity(@Query("q") String cityName);
}
