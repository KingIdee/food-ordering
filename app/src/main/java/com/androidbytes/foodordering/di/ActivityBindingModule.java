package com.androidbytes.foodordering.di;

import com.androidbytes.foodordering.modules.NetworkModule;
import com.androidbytes.foodordering.restaurantlist.RestaurantListActivity;
import com.androidbytes.foodordering.restaurantlist.RestaurantModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by idee on 8/18/17.
 */

@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = {RestaurantModule.class, NetworkModule.class})
    abstract RestaurantListActivity restaurantListActivity();
}
