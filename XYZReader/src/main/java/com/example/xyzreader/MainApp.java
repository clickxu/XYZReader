package com.example.xyzreader;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by t-xu on 2017/06/21.
 */

public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.uprootAll();
            Timber.plant(new Timber.DebugTree());
        }
    }
}
