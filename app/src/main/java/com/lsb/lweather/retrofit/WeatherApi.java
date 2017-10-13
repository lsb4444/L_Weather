package com.lsb.lweather.retrofit;

import android.location.Location;

import com.lsb.lweather.models.nowWeather.Lweather;
import com.lsb.lweather.models.nowWeather.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    String APP_ID = "65159c855f57757fc6fc01e05c94557b";

    @GET("weather?lang=kr&units=metric&appid=" + APP_ID)
   Call<Lweather> getLweather(@Query("q") String cityName);
}
