package com.lsb.lweather;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.lsb.lweather.adapter.ListWeatherAdapter;
import com.lsb.lweather.models.RealmCityName;
import com.lsb.lweather.models.nowWeather.Lweather;
import com.lsb.lweather.retrofit.WeatherUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchWeatherFragment extends Fragment {


    @BindView(R.id.image_view)
    ImageView mImageView;
    @BindView(R.id.search_edit_text)
    EditText mSearchEditText;
    @BindView(R.id.search_fragment_button)
    Button mSearchFragmentButton;
    @BindView(R.id.list_view)
    ListView mListView;

    Unbinder unbinder;
    private WeatherUtil mWeatherUtil;

    private List<Lweather> mWeatherList = new ArrayList<>();
    private ListWeatherAdapter mAdapter;

    private Realm mRealm;

    public SearchWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_weather, container, false);
        unbinder = ButterKnife.bind(this, view);
        mWeatherUtil = new WeatherUtil();

        mRealm=Realm.getDefaultInstance();

        mAdapter = new ListWeatherAdapter(mWeatherList);
        mListView.setAdapter(mAdapter);


        ClickCityName();


        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                return false;
            }
        });


        RealmCheck();

        kyboard_search();
        return view;

    }

    private void RealmCheck() {
        if (mRealm != null) {
            RealmResults<RealmCityName> realmCity = mRealm.where(RealmCityName.class).findAll();
            for (int i = 1; i < realmCity.size()+1; i++) {

                RealmCityName realmCity2 = mRealm.where(RealmCityName.class).equalTo("Id", i).findFirst();
                String city_name = realmCity2.getCityName();

                mWeatherUtil.getmApiService().getLweather(city_name).enqueue(new Callback<Lweather>() {

                    @Override
                    public void onResponse(Call<Lweather> call, Response<Lweather> response) {

                        Lweather lweather = response.body();
                        mWeatherList.add(lweather);
                    }

                    @Override
                    public void onFailure(Call<Lweather> call, Throwable t) {
                        Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    private void ClickCityName() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //지역 이름 가져오기
                String city = String.valueOf(((Lweather) mAdapter.getItem(i)).getId());

                Intent intent = new Intent(getActivity(), NewActivity.class);

                intent.putExtra("city", city);

                startActivity(intent);

            }
        });
    }


    private void kyboard_search() {
        mSearchEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                if (keyCode == KeyEvent.KEYCODE_ENTER
                        && keyEvent.getAction() == KeyEvent.ACTION_UP) {
                    // 검색버튼을 땔 때
                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(mSearchEditText.getWindowToken(), 0);

                    search(mSearchEditText.getText().toString());

                    return true;
                }
                return false;
            }
        });
    }

    private void search(final String cityName) {

        mWeatherUtil.getmApiService().getLweather(cityName).enqueue(new Callback<Lweather>() {

            @Override
            public void onResponse(Call<Lweather> call, Response<Lweather> response) {

                Lweather lweather = response.body();
                mWeatherList.add(lweather);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Lweather> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number currentIdNum = realm.where(RealmCityName.class).max("Id");
                final int firstId = 1;
                int Id;

                if (currentIdNum == null) {
                    Id = firstId;
                } else {
                    Id = currentIdNum.intValue() + 1;
                }

                RealmCityName name = realm.createObject(RealmCityName.class, Id);
                name.setCityName(cityName);
            }
        });


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.search_fragment_button)
    public void onViewClicked() {
        search(mSearchEditText.getText().toString());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }
}

