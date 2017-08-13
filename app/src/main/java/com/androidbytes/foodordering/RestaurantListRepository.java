package com.androidbytes.foodordering;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.androidbytes.foodordering.modules.NetworkModule;

import org.json.JSONObject;

import java.util.ArrayList;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by idee on 8/10/17.
 */

/**
 * This class will provide the view model with data, either from a remote source or sqlite Db
 */

@Singleton
public class RestaurantListRepository {

    //todo: use dependency injection to provide this
    private NetworkModule.WebService webService;

    public LiveData<ArrayList<RestaurantModel>> getR(){

        final MutableLiveData<ArrayList<RestaurantModel>> mRestaurants = new MutableLiveData<>();
        Call<RestaurantModel> call = NetworkModule.providesWebService().makeRequest(BuildConfig.API_KEY);

        call.enqueue(new Callback<RestaurantModel>() {
            @Override
            public void onResponse(@NonNull Call<RestaurantModel> call, @NonNull Response<RestaurantModel> response) {

                //restaurants found = 99+38.
                Log.d(getClass().getName(), String.valueOf(response.message()));
                //mRestaurants.setValue(arrayList);

            }

            @Override
            public void onFailure(@NonNull Call<RestaurantModel> call, Throwable t) {
                Log.d(getClass().getSimpleName(),t.toString());

            }
        });

        return mRestaurants;
    }

}
