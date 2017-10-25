package com.lsb.lweather.retrofit;
import com.lsb.lweather.models.OneWeeWeather.OneWeeWeather;
import com.lsb.lweather.models.nowWeather.Lweather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    String APP_ID = "65159c855f57757fc6fc01e05c94557b";

    @GET("weather?lang=kr&units=metric&appid=" + APP_ID)
    Call<Lweather> getLweather(@Query("q") String cityName);

    @GET("forecast?lang=kr&units=metric&appid=" + APP_ID)
    Call<OneWeeWeather> getOneWeekLweather(@Query("q") String cityName);

    @GET("weather?lang=kr&units=metric&appid=" + APP_ID)
    Call<Lweather> getLweatherID(@Query("id") String cityName);

    @GET("forecast?lang=kr&units=metric&appid=" + APP_ID)
    Call<OneWeeWeather> getOneWeekLweatherID(@Query("id") String cityName);
}
