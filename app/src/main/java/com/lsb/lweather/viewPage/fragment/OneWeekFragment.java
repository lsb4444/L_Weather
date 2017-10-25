package com.lsb.lweather.viewPage.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.lsb.lweather.R;
import com.lsb.lweather.adapter.ListWeatherAdapter;
import com.lsb.lweather.adapter.OneWeekListWeatherAdapter;
import com.lsb.lweather.models.OneWeeWeather.OneWeeWeather;
import com.lsb.lweather.models.nowWeather.Lweather;
import com.lsb.lweather.retrofit.WeatherUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneWeekFragment extends Fragment {



    private WeatherUtil mWeatherUtil;

    private String mOneWeekCityName;

    private ListView mListView;

    private List<OneWeeWeather> mWeatherList = new ArrayList<>();

    private OneWeekListWeatherAdapter mAdapter;


    public static OneWeekFragment newInstance(String city) {
        Bundle args = new Bundle();
        args.putString("city", city);
        OneWeekFragment fragment = new OneWeekFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public OneWeekFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_one_week, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListView = (ListView) getView().findViewById(R.id.one_week_list_view);
        mOneWeekCityName = getArguments().getString("city");


        mWeatherUtil = new WeatherUtil();
        mWeatherUtil.getmApiService().getOneWeekLweatherID(mOneWeekCityName).enqueue(new Callback<OneWeeWeather>() {

            @Override
            public void onResponse(Call<OneWeeWeather> call, Response<OneWeeWeather> response) {

                OneWeeWeather lweather = response.body();

                mAdapter = new OneWeekListWeatherAdapter(mWeatherList, response.body().getList() );
                mListView.setAdapter(mAdapter);


                mWeatherList.add(lweather);

                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<OneWeeWeather> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
