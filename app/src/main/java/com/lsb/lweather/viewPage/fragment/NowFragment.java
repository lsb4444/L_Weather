package com.lsb.lweather.viewPage.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lsb.lweather.R;

import org.w3c.dom.Text;


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

    public NowFragment() {
        // Required empty public constructor


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



    }
}
