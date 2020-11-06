package com.example.weatherappjava.Model.CitySearch;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("name")
    private String name;
    private String country;

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
