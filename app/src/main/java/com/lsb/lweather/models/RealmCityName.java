package com.lsb.lweather.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by L on 2017-10-27.
 */

public class RealmCityName extends RealmObject{

    @PrimaryKey
    private int Id;

    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
