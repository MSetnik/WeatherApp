package com.example.weatherappjava.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherappjava.Interface.WaitForCurrentWeatherInterface;
import com.example.weatherappjava.Model.CurrentWeather.CurrentWeather;
import com.example.weatherappjava.Model.CurrentWeather.Main;
import com.example.weatherappjava.Repository.Repository;

public class CurrentWeatherViewModel extends ViewModel {
    private Repository repository = new Repository();
//    private CurrentWeather currentWeather;
    private WaitForCurrentWeatherInterface waitForCurrentWeatherInterface;
    private MutableLiveData<CurrentWeather> weather;

    public void LoadCurrentWeather() {
        repository.GetCurrentWeather("Valpovo");
        repository.SetOnCurrentWeatherDataFinishListener(new WaitForCurrentWeatherInterface() {
            @Override
            public void GetCurrentWeatherData(CurrentWeather currentWeather) {
//                waitForCurrentWeatherInterface.GetCurrentWeatherData(currentWeather);

                float tempC = (float) (currentWeather.getMain().getTemp() - 273.15);
                float feelsLikeC = (float) (currentWeather.getMain().getFeelsLike() - 273.15);
                float tempMinC = (float) (currentWeather.getMain().getTempMin() - 273.15);
                float tempMaxC = (float) (currentWeather.getMain().getTempMax() - 273.15);

                Main mainFormat = new Main(tempC,feelsLikeC, tempMinC, tempMaxC, currentWeather.getMain().getPressure(), currentWeather.getMain().getHumidity());

                CurrentWeather weatherFormat = new CurrentWeather(currentWeather.getCity(), currentWeather.getWeather(), mainFormat);


                weather.setValue(weatherFormat);
            }
        });
    }

    public LiveData<CurrentWeather> GetCurrentWeather() {
        if(weather == null) {
            weather = new MutableLiveData<CurrentWeather>();
            LoadCurrentWeather();
        }
        return weather;
    }

    public void SetOnCurrentWeatherDataInterface(WaitForCurrentWeatherInterface waitForCurrentWeatherInterface) {
        this.waitForCurrentWeatherInterface = waitForCurrentWeatherInterface;
    }

}
