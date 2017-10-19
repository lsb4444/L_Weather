package com.lsb.lweather;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsb.lweather.viewPage.fragment.NowFragment;
import com.lsb.lweather.viewPage.fragment.OneWeekFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class NowWeatherFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;


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
        // tabLayout과 ViewPager 연결
        mTabLayout.setupWithViewPager(mViewPager);


        return view;


    }

    private static class MyViewPager extends FragmentPagerAdapter {

        public static final int PAGE_NUM = 2;

        public MyViewPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new NowFragment();
                case 1:
                    return new OneWeekFragment();
            }


            return null;
        }

        @Override
        public int getCount() {
            return PAGE_NUM;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "현재 날씨";
                case 1:
                    return "주간 날씨";
            }

            return super.getPageTitle(position);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
