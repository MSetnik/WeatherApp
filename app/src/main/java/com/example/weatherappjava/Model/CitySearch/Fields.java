package com.example.weatherappjava.Model.CitySearch;

import com.google.gson.annotations.SerializedName;

public class Fields {

    @SerializedName("fields")
    private City city;

    public Fields(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}
