package com.example.weatherappjava.Model.CurrentWeather;

public class City {
    private int id;
    private String name;
    private Coord coord;
    private String country;
    private int sunrise;
    private int sunset;

    public City(int id, String name, Coord coord, String country, int sunrise, int sunset) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }
}
