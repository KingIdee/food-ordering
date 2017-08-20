package com.androidbytes.foodordering.restaurantlist;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.androidbytes.foodordering.AppComponent;
import com.androidbytes.foodordering.AppController;
import com.androidbytes.foodordering.BuildConfig;
import com.androidbytes.foodordering.DaggerAppComponent;
import com.androidbytes.foodordering.modules.NetworkModule;

import java.util.ArrayList;

import javax.inject.Inject;
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

    @Inject
    NetworkModule.WebService webService;

    @Inject
    public RestaurantListRepository(NetworkModule.WebService webService) {
        this.webService = webService;
    }

    public MutableLiveData<ArrayList<RestaurantModel>> getR() {
        final MutableLiveData<ArrayList<RestaurantModel>> mRestaurants = new MutableLiveData<>();
        Call<RestaurantModel> call = webService.makeRequest(BuildConfig.API_KEY);

        call.enqueue(new Callback<RestaurantModel>() {
            @Override
            public void onResponse(@NonNull Call<RestaurantModel> call, @NonNull Response<RestaurantModel> response) {

                //restaurants found = 99+38.
                Log.d(getClass().getName(), String.valueOf(response.message()));
                //mRestaurants.setValue(arrayList);

            }

            @Override
            public void onFailure(@NonNull Call<RestaurantModel> call, Throwable t) {
                Log.d(getClass().getSimpleName(), t.toString());

            }
        });

        return mRestaurants;

        /*return new NetworkBoundResource(){

            @Override
            protected void saveCallResult(@NonNull ArrayList<RestaurantModel> item) {
                Log.d(getClass().getSimpleName()+"saveCallResult",item.toString());
            }

            @Override
            protected boolean shouldFetch(@Nullable ArrayList<RestaurantModel> data) {
                Log.d(getClass().getSimpleName(),"shouldFetch");
                return data==null;
            }

            @NonNull
            @Override
            protected LiveData<ArrayList<RestaurantModel>> loadFromDb() {
                Log.d(getClass().getSimpleName(),"Load from DB");
                return null;
            }

            @NonNull
            @Override
            protected Call<ArrayList<RestaurantModel>> createCall() {
                Log.d(getClass().getSimpleName(),"Create call");
                return NetworkModule.providesWebService().makeRequest(BuildConfig.API_KEY);
            }

        }.asLiveData();*/

    }

}
