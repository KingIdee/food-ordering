package com.androidbytes.foodordering;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by idee on 8/17/17.
 */

public class AppController extends DaggerApplication {

    private AppComponent appComponent;
    private static AppController appInstance;

    @Override
    public AndroidInjector<? extends DaggerApplication> applicationInjector() {
        initComponent();
        appComponent.inject(this);
        return appComponent;
    }

    public static AppController getInstance(){
        if (appInstance==null)
            appInstance = new AppController();
        return appInstance;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

    private void initComponent(){
        if (appComponent==null)
            appComponent = DaggerAppComponent.builder().application(this).build();
    }

}