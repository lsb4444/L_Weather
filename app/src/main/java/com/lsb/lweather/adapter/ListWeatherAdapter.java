package com.lsb.lweather.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lsb.lweather.R;
import com.lsb.lweather.models.nowWeather.Lweather;

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
            holder.image = view.findViewById(R.id.item_image_view);
            holder.name = view.findViewById(R.id.city_name_text);
            holder.temp = view.findViewById(R.id.temp_text_view);
            holder.max = view.findViewById(R.id.max_temp_text_view);
            holder.min = view.findViewById(R.id.mim_temp_text_view);

            view.setTag(holder);
        } else {

            holder = (ViewHolder) view.getTag();
        }

        Lweather weatherList = (Lweather) getItem(i);
        String iconUrl = "http://openweathermap.org/img/w/" +
                weatherList.getWeather().get(0).getIcon() + ".png";
        Glide.with(viewGroup.getContext()).load(iconUrl).into(holder.image);
        holder.name.setText("" + weatherList.getName());
        holder.temp.setText("" + weatherList.getMain().getTemp());
        holder.min.setText("" + weatherList.getMain().getTemp_Min());
        holder.max.setText("" + weatherList.getMain().getTemp_Max());

        return view;


    }

    private static class ViewHolder {
        ImageView image;

        TextView name;
        TextView temp;
        TextView min;
        TextView max;
    }
}
