package com.androidbytes.foodordering.restaurantlist;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.androidbytes.foodordering.AppController;
import com.androidbytes.foodordering.DaggerAppComponent;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by idee on 8/10/17.
 */

public class RestaurantListViewModel extends ViewModel {

    private MutableLiveData<ArrayList<RestaurantModel>> listLiveData;

    @Inject
    public RestaurantListViewModel(RestaurantListRepository repository) {
        init(repository);
    }

    private void init(RestaurantListRepository repository){
        if (listLiveData==null){
            listLiveData = repository.getR();
        } else {
            Log.d(getClass().getSimpleName(),"ViewModel in action");
        }

    }

    MutableLiveData<ArrayList<RestaurantModel>> getRestaurants(){
        return listLiveData;
    }

    /**
     * This method is only for testing purposes
     */
    void nullify(){
        listLiveData = null;
    }

}