package com.lsb.lweather.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by L on 2017-09-22.
 */

public class WeatherUtil {


    private final WeatherApi mApiService;

    public WeatherUtil() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiService = retrofit.create(WeatherApi.class);
    }

    public WeatherApi getmApiService() {
        return mApiService;
    }
}
