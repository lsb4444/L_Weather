package com.lsb.lweather.realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by L on 2017-10-27.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
//
//        RealmConfiguration.Builder config = new RealmConfiguration.Builder();
//        config.deleteRealmIfMigrationNeeded();
//
//        Realm realm = Realm.getInstance(config.build());

        RealmConfiguration.Builder config = new RealmConfiguration.Builder();
        config.deleteRealmIfMigrationNeeded();


        Realm.setDefaultConfiguration(config.build());
    }
}
