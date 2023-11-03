package com.base.jsonusers;

import android.app.Application;

public class MyApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UserDatabase.getDatabase(this);
    }
}
