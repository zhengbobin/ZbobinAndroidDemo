package com.zbobin.androiddemo.app;

import android.app.Application;


public class BaseApplication extends Application {

    private static BaseApplication mInstance = null;

    public static BaseApplication getApplacation() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

}
