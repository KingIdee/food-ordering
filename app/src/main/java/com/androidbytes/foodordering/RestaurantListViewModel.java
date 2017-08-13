package com.androidbytes.foodordering;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by idee on 8/10/17.
 */

public class RestaurantListViewModel extends ViewModel {

    private final RestaurantListRepository repo = new RestaurantListRepository();
    private LiveData<ArrayList<RestaurantModel>> listLiveData;

    public RestaurantListViewModel() {

    }

    void init(){
        if (listLiveData==null){
            listLiveData = repo.getR();
        } else {
            Log.d(getClass().getSimpleName(),"ViewModel in action");
        }

    }

    LiveData<ArrayList<RestaurantModel>> getRestaurants(){
        return listLiveData;
    }

    /**
     * This method is only for testing purposes
     */
    void nullify(){
        listLiveData = null;
    }

}
