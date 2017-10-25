package com.lsb.lweather.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.lsb.lweather.R;
import com.lsb.lweather.models.OneWeeWeather.OneWeeWeather;

import java.util.List;


/**
 * Created by L on 2017-09-26.
 */

public class OneWeekListWeatherAdapter extends BaseAdapter {

    private final List<com.lsb.lweather.models.OneWeeWeather.List> mListWeather;
    private List<OneWeeWeather> mWeatherList;


    public OneWeekListWeatherAdapter(List<OneWeeWeather> weatherList, List<com.lsb.lweather.models.OneWeeWeather.List> listWeather) {
        mWeatherList = weatherList;
        mListWeather = listWeather;


    }

    @Override
    public int getCount() {
        return mListWeather.size();
    }

    @Override
    public Object getItem(int i) {
        return mListWeather.get(i);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_one_week_wether, viewGroup, false);
            holder.image = view.findViewById(R.id.one_week_image_view);
            holder.temp = view.findViewById(R.id.one_week_temp_text_view);
            holder.max = view.findViewById(R.id.one_week_max_temp_text_view);
            holder.min = view.findViewById(R.id.one_week_mim_temp_text_view);
            holder.weather = view.findViewById(R.id.one_week_weather_view);
            holder.time = view.findViewById(R.id.one_week_time_view);

            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();
        }

        com.lsb.lweather.models.OneWeeWeather.List weatherList = mListWeather.get(i);
        String iconUrl = "http://openweathermap.org/img/w/" +
                weatherList.getWeather().get(0).getIcon() + ".png";
        Glide.with(viewGroup.getContext()).load(iconUrl).into(holder.image);
        holder.temp.setText("" + weatherList.getMain().getTemp());
        holder.min.setText("" + weatherList.getMain().getTempMin());
        holder.max.setText("" + weatherList.getMain().getTempMax());
        holder.weather.setText("" + weatherList.getWeather().get(0).getMain());
        holder.time.setText("" + weatherList.getDtTxt());

        return view;


    }

    public void add(OneWeeWeather oneWeeWeather) {
        mWeatherList.add(oneWeeWeather);
    }

    private static class ViewHolder {
        ImageView image;

        TextView name;
        TextView temp;
        TextView min;
        TextView max;
        TextView weather;
        TextView time;
    }
}
