package com.example.weatherappjava.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherappjava.Model.CurrentWeather.CurrentWeather;
import com.example.weatherappjava.Model.CurrentWeather.Forecast;
import com.example.weatherappjava.Model.CurrentWeather.Main;
import com.example.weatherappjava.Model.CurrentWeather.Weather;
import com.example.weatherappjava.Model.CurrentWeather.WeatherData;
import com.example.weatherappjava.Repository.Repository;

import java.util.ArrayList;
import java.util.Date;

public class CurrentWeatherViewModel extends ViewModel {
    private Repository repository = new Repository();
    private MutableLiveData<CurrentWeather> weather;
    private MutableLiveData<Forecast> forecastMutableLiveData;

    public void LoadCurrentWeather(String search) {
        repository.GetCurrentWeather("Valpovo");
            repository.SetOnCurrentWeatherDataFinishListener(currentWeather -> {
            float tempC = (float) (currentWeather.getMainWeather().getTemp() - 273.15);
            float feelsLikeC = (float) (currentWeather.getMainWeather().getFeelsLike() - 273.15);
            float tempMinC = (float) (currentWeather.getMainWeather().getTempMin() - 273.15);
            float tempMaxC = (float) (currentWeather.getMainWeather().getTempMax() - 273.15);

            Main mainFormat = new Main(tempC,feelsLikeC, tempMinC, tempMaxC, currentWeather.getMainWeather().getPressure(), currentWeather.getMainWeather().getHumidity());

            CurrentWeather weatherFormat = new CurrentWeather(currentWeather.getCoord(), currentWeather.getWeather(), mainFormat, currentWeather.getDate(), currentWeather.getCityName());


            weather.setValue(weatherFormat);
        });
    }

    public LiveData<CurrentWeather> GetCurrentWeather(String search) {
        weather = new MutableLiveData<>();
        LoadCurrentWeather(search);

        return weather;
    }


    public void LoadForecast(String search) {
        repository.GetCurrentWeather(search);
        repository.SetOnForecastFinishListener(forecast -> {
            float tempC, feelsLikeC, tempMinC, tempMaxC;
            ArrayList<WeatherData> lWeatherData = new ArrayList<>();

            for (WeatherData weather : forecast.getWeatherData()){
                tempC = (float) (weather.getMain().getTemp() - 273.15);
                feelsLikeC = (float) (weather.getMain().getFeelsLike() - 273.15);
                tempMinC = (float) (weather.getMain().getTempMin() - 273.15);
                tempMaxC = (float) (weather.getMain().getTempMax() - 273.15);

                Main main = new Main(tempC, feelsLikeC, tempMinC, tempMaxC, weather.getMain().getPressure(), weather.getMain().getHumidity());
                WeatherData weatherDataFormat = new WeatherData(weather.getDate(), weather.getMain(), weather.getWeather(), weather.getDt_text());
                lWeatherData.add(weatherDataFormat);
            }



            Forecast weatherFormat = new Forecast(lWeatherData, forecast.getCity());


            forecastMutableLiveData.setValue(weatherFormat);
        });
    }

    public LiveData<Forecast> GetForecast(String search) {
        forecastMutableLiveData = new MutableLiveData<>();
        LoadForecast(search);

        return forecastMutableLiveData;
    }

    private Date UnixTimeConvert(int unixDate) {
        Date date = new Date(unixDate);
        return date;
    }
}
