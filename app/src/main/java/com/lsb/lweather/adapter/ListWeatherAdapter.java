package com.lsb.lweather.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lsb.lweather.R;
import com.lsb.lweather.models.nowWeather.Lweather;
import com.lsb.lweather.models.nowWeather.Main;

import java.util.List;


/**
 * Created by L on 2017-09-26.
 */

public class ListWeatherAdapter extends BaseAdapter {

    private List<Lweather> mWeatherList;


    public ListWeatherAdapter(List<Lweather> weatherList) {
        mWeatherList = weatherList;

    }

    @Override
    public int getCount() {
        return mWeatherList.size();
    }

    @Override
    public Object getItem(int i) {
        return mWeatherList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wether, viewGroup, false);
            holder.temp = view.findViewById(R.id.temp_text_view);
            holder.max = view.findViewById(R.id.max_temp_text_view);
            holder.min = view.findViewById(R.id.mim_temp_text_view);
            holder.weather = view.findViewById(R.id.weather_text_view);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Lweather weatherList = (Lweather) getItem(i);
        holder.temp.setText("기온 : " + weatherList.getMain().getTemp());
        holder.min.setText("최저 기온 : " + weatherList.getMain().getTempMin());
        holder.max.setText("최고 기온 : " + weatherList.getMain().getTempMax());
        holder.weather.setText("습도 : " + weatherList.getMain().getHumidity());

        return view;


    }

    private static class ViewHolder {
        TextView temp;
        TextView min;
        TextView max;
        TextView weather;
    }
}
