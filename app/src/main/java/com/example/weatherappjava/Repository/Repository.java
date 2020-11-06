package com.example.weatherappjava.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherappjava.Interface.WaitForCurrentWeatherInterface;
import com.example.weatherappjava.Model.CitySearch.City;
import com.example.weatherappjava.Model.CitySearch.Records;
import com.example.weatherappjava.Model.CurrentWeather.CurrentWeather;
import com.example.weatherappjava.Retrofit.CityApi;
import com.example.weatherappjava.Retrofit.CurrentWeatherApi;
import com.example.weatherappjava.Retrofit.RetrofitInstanceCity;
import com.example.weatherappjava.Retrofit.RetrofitInstanceWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {
    private static final String TAG = "MyApp";
    private CurrentWeather currentWeather;
    private WaitForCurrentWeatherInterface waitForCurrentWeatherInterface;
    private MutableLiveData<CurrentWeather> newsData = new MutableLiveData<>();


    // Weather Api Call
    public void GetCurrentWeather(String city) {
        Retrofit retrofit = RetrofitInstanceWeather.getInstance();

        CurrentWeatherApi currentWeatherApi = retrofit.create(CurrentWeatherApi.class);

        Call<CurrentWeather> call = currentWeatherApi.getCurrentWeather(city);

        call.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                currentWeather = response.body();
                waitForCurrentWeatherInterface.GetCurrentWeatherData(currentWeather);
                Log.d(TAG, "onResponse: success");
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public void SetOnCurrentWeatherDataFinishListener(WaitForCurrentWeatherInterface waitForCurrentWeatherInterface) {
        this.waitForCurrentWeatherInterface = waitForCurrentWeatherInterface;
    }


    // City api call
    public void GetCity(String city) {
        Retrofit retrofit = RetrofitInstanceCity.getInstance();

        CityApi cityApi = retrofit.create(CityApi.class);

        Call<Records> call = cityApi.getCity(city);

        call.enqueue(new Callback<Records>() {
            @Override
            public void onResponse(Call<Records> call, Response<Records> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<Records> call, Throwable t) {
                Log.d(TAG, "onFailure: " +t.getMessage());
            }
        });
    }
}
