package com.lsb.lweather.viewPage.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lsb.lweather.NewActivity;
import com.lsb.lweather.R;
import com.lsb.lweather.models.nowWeather.Lweather;
import com.lsb.lweather.retrofit.WeatherUtil;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NowFragment extends Fragment {

    private ImageView mIcon;
    private TextView mCityName;
    private TextView mTemp;
    private TextView mMaxTemp;
    private TextView mMinTemp;
    private TextView mContryCode;
    private TextView mHumidity;
    private TextView mWeather;

    private WeatherUtil mWeatherUtil;

    public String mNowCityName;


    public static NowFragment newInstance(String city) {
        Bundle args = new Bundle();
        args.putString("city", city);
        NowFragment fragment = new NowFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public NowFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNowCityName = getArguments().getString("city");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_now, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mIcon = (ImageView) getActivity().findViewById(R.id.now_icon_frag);

        mCityName = (TextView) getView().findViewById(R.id.now_city_name_frag);

        mTemp = (TextView) getView().findViewById(R.id.now_temp_frag);
        mMaxTemp = (TextView) getView().findViewById(R.id.now_max_temp);
        mMinTemp = (TextView) getView().findViewById(R.id.now_min_temp);

        mContryCode = (TextView) getView().findViewById(R.id.now_country_code);
        mHumidity = (TextView) getView().findViewById(R.id.now_humidity);
        mWeather = (TextView) getView().findViewById(R.id.now_weather_main);

        mWeatherUtil = new WeatherUtil();


        mWeatherUtil.getmApiService().getLweather(mNowCityName).enqueue(new Callback<Lweather>() {
            @Override
            public void onResponse(Call<Lweather> call, Response<Lweather> response) {

                Lweather lweather = response.body();

                mCityName.setText(""+lweather.getName());
                mTemp.setText(""+lweather.getMain().getTemp());
                mMaxTemp.setText(""+lweather.getMain().getTemp_Max());
                mMinTemp.setText(""+lweather.getMain().getTemp_Min());


                mContryCode.setText(""+lweather.getSys().getCountry());
                mHumidity.setText(""+lweather.getMain().getHumidity());
                mWeather.setText(""+lweather.getWeather().get(0).getMain());

            }

            @Override
            public void onFailure(Call<Lweather> call, Throwable t) {

            }
        });


    }


}
