package com.bw.movie.utils;

import android.app.Application;
import android.content.Context;

/**
 * Describe：MainApplication
 * Author：fan
 * Data：2019/11/7
 * Time:9:13
 */

public class MainApplication extends Application {
    private static MainApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static Context getInstance() {
        return sInstance;
    }
}
