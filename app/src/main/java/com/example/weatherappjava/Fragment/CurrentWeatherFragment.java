package com.example.weatherappjava.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.weatherappjava.Model.CurrentWeather.CurrentWeather;
import com.example.weatherappjava.Model.CurrentWeather.Forecast;
import com.example.weatherappjava.Model.CurrentWeather.WeatherData;
import com.example.weatherappjava.R;
import com.example.weatherappjava.ViewModel.CurrentWeatherViewModel;

public class CurrentWeatherFragment extends Fragment {
    private static final String TAG = "MyApp";
    private CurrentWeatherViewModel currentWeatherViewModel;
    private String search;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentWeatherViewModel = new ViewModelProvider(requireActivity()).get(CurrentWeatherViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_weather, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.currentWeatherConstraint).setVisibility(View.GONE);
        view.findViewById(R.id.animationView).setVisibility(View.VISIBLE);


        search = getArguments().getString("searchInput");
        currentWeatherViewModel.GetCurrentWeather(search).observe(getActivity(), currentWeather -> {
            BindWeatherData(currentWeather, view);
        });

        currentWeatherViewModel.GetForecast(search).observe(getActivity(), forecast -> {
            Log.d(TAG, "onViewCreated: forecast   " + forecast );
        });



        SearchClick(view);
    }

    private void BindWeatherData(CurrentWeather currentWeather, View view) {
        TextView cityName = view.findViewById(R.id.cityNameTV);
        TextView temperature = view.findViewById(R.id.weatherTempTV);
        TextView feelsLike = view.findViewById(R.id.feelsLikeTV);
        TextView tempMin = view.findViewById(R.id.tempMinTV);
        TextView tempMax = view.findViewById(R.id.tempMaxTV);
        TextView humidity = view.findViewById(R.id.humidityTV);
        TextView pressure = view.findViewById(R.id.pressureTV);

        cityName.setText(currentWeather.getCityName());

        temperature.setText(Math.round(currentWeather.getMainWeather().getTemp())+ getString(R.string.celsius_symbol));
        feelsLike.setText(Math.round(currentWeather.getMainWeather().getFeelsLike()) + getString(R.string.celsius_symbol));
        tempMin.setText(Math.round(currentWeather.getMainWeather().getTempMin()) + getString(R.string.celsius_symbol) );
        tempMax.setText(Math.round(currentWeather.getMainWeather().getTempMax())+ getString(R.string.celsius_symbol));
        humidity.setText(currentWeather.getMainWeather().getHumidity() + getString(R.string.humidity_symbol));
        pressure.setText(currentWeather.getMainWeather().getPressure() + " " +getString(R.string.pressure_symbol));
        view.findViewById(R.id.animationView).setVisibility(View.GONE);
        view.findViewById(R.id.currentWeatherConstraint).setVisibility(View.VISIBLE);
    }

    private void SearchClick(View view) {
        ImageButton btn = view.findViewById(R.id.btnToSearchFragment);
        NavController navController = Navigation.findNavController(view);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               navController.navigate(R.id.action_currentWeatherFragment_to_searchFragment);
            }
        });
    }

}