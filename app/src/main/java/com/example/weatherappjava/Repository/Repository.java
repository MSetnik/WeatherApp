package com.example.weatherappjava.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherappjava.Interface.WaitForCurrentWeatherInterface;
import com.example.weatherappjava.Interface.WaitForForecastInterface;
import com.example.weatherappjava.Model.CurrentWeather.CurrentWeather;
import com.example.weatherappjava.Model.CurrentWeather.Forecast;
import com.example.weatherappjava.Retrofit.CurrentWeatherApi;
import com.example.weatherappjava.Retrofit.ForecastApi;
import com.example.weatherappjava.Retrofit.RetrofitInstanceWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {
    private static final String TAG = "MyApp";
    private CurrentWeather currentWeather;
    private WaitForCurrentWeatherInterface waitForCurrentWeatherInterface;
    private WaitForForecastInterface waitForForecastInterface;
    private MutableLiveData<Forecast> newsData = new MutableLiveData<>();


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

    // Weather Api Call
    public void GetForecast(String city) {
        Retrofit retrofit = RetrofitInstanceWeather.getInstance();

        ForecastApi forecastApi = retrofit.create(ForecastApi.class);

        Call<Forecast> call = forecastApi.getForecast(city);

        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                waitForForecastInterface.GetForecast(response.body());
                Log.d(TAG, "onResponse: success");
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public void SetOnForecastFinishListener(WaitForForecastInterface waitForForecastInterface) {
        this.waitForForecastInterface = waitForForecastInterface;
    }
}
