
package com.lsb.lweather.models.OneWeeWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    @Expose
    private double all;

    public double getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

}
