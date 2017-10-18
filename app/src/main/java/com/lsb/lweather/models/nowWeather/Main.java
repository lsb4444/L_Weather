
package com.lsb.lweather.models.nowWeather;


import com.google.gson.annotations.SerializedName;

public class Main {

    private double temp;
    private double pressure;
    private double humidity;
    @SerializedName("temp_min")
    private double temp_Min;
    @SerializedName("temp_max")
    private double temp_Max;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemp_Min() {
        return temp_Min;
    }

    public void setTemp_Min(double temp_Min) {
        this.temp_Min = temp_Min;
    }

    public double getTemp_Max() {
        return temp_Max;
    }

    public void setTemp_Max(double temp_Max) {
        this.temp_Max = temp_Max;
    }
}
