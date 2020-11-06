package com.example.weatherappjava.Model.CitySearch;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Records {

    @SerializedName("records")
    private ArrayList<Fields> fields;

    public Records(ArrayList<Fields> fields) {
        this.fields = fields;
    }

    public ArrayList<Fields> getFields() {
        return fields;
    }
}
