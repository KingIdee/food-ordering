package com.androidbytes.foodordering.restaurantlist;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.androidbytes.foodordering.ViewModelFactory;
import com.androidbytes.foodordering.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by idee on 8/18/17.
 */

@Module
public abstract class RestaurantModule {

    @Binds
    @IntoMap
    @ViewModelKey(RestaurantListViewModel.class)
    abstract ViewModel bindRepoViewModel(RestaurantListViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}