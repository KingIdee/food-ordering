package com.androidbytes.foodordering;

import android.app.Application;

import com.androidbytes.foodordering.di.ActivityBindingModule;
import com.androidbytes.foodordering.modules.NetworkModule;
import com.androidbytes.foodordering.restaurantlist.RestaurantListRepository;
import com.androidbytes.foodordering.restaurantlist.RestaurantListViewModel;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by idee on 8/17/17.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityBindingModule.class,NetworkModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Override void inject(DaggerApplication instance);

    void inject(RestaurantListRepository restaurantListRepository);
    void inject(RestaurantListViewModel restaurantListViewModel);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);
        AppComponent build();
    }

}
