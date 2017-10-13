package com.lsb.lweather;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class NowWeatherFragment extends Fragment {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    Unbinder unbinder;

    public NowWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_now_weather, container, false);
        unbinder = ButterKnife.bind(this, view);

        mViewPager.setAdapter(new MyViewPager(getFragmentManager()));


        return view;


    }

    private static class MyViewPager extends FragmentPagerAdapter {

        public static final int PAGE_NUM = 2;

        public MyViewPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return PAGE_NUM;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
