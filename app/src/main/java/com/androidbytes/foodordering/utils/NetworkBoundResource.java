package com.androidbytes.foodordering.utils;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;

import com.androidbytes.foodordering.restaurantlist.RestaurantModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by idee on 8/12/17.
 */

/**
 * Adapted from google's documentation https://developer.android.com/topic/libraries/architecture/guide.html#addendum
 * TODO: This class has to be generified
 */

// ResultType: Type for the Resource data
// RequestType: Type for the API response
public abstract class NetworkBoundResource {

    private final MediatorLiveData<Resource<ArrayList<RestaurantModel>>> result = new MediatorLiveData<>();

    @MainThread
    public NetworkBoundResource() {
        result.setValue(Resource.<ArrayList<RestaurantModel>>loading(null));
        final LiveData<ArrayList<RestaurantModel>> dbSource = loadFromDb();

        fetchFromNetwork(dbSource);

        /*result.addSource(dbSource, new Observer<ArrayList<RestaurantModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<RestaurantModel> resultType) {

                result.removeSource(dbSource);
                if (shouldFetch(resultType)) {
                    fetchFromNetwork(dbSource);
                } else {

                    result.addSource(dbSource, new Observer<ArrayList<RestaurantModel>>() {
                        @Override
                        public void onChanged(@Nullable ArrayList<RestaurantModel> resultType) {
                            result.setValue(Resource.success(resultType));
                        }
                    });


                }


            }
        });*/

    }

    private void fetchFromNetwork(final LiveData<ArrayList<RestaurantModel>> dbSource) {
        //final LiveData<ApiResponse<RequestType>> apiResponse = createCall();
        final Call<ArrayList<RestaurantModel>> apiResponse = createCall();
        // we re-attach dbSource as a new source,
        // it will dispatch its latest value quickly

       /* result.addSource(dbSource, new Observer<ArrayList<RestaurantModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<RestaurantModel> resultType) {
                result.setValue(Resource.loading(resultType));
            }
        });*/




        result.addSource(null, new Observer<ArrayList<RestaurantModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<RestaurantModel> restaurantModel) {

                //result.removeSource(apiResponse);
                result.removeSource(dbSource);
                //noinspection ConstantConditions
                apiResponse.enqueue(new Callback<ArrayList<RestaurantModel>>() {
                    @Override
                    public void onResponse(@NonNull Call<ArrayList<RestaurantModel>> call, @NonNull Response<ArrayList<RestaurantModel>> response) {
                        saveCallResult(response.body());
                        Log.d(getClass().getSimpleName(), response.body().toString());
                    }

                    @Override
                    public void onFailure(@NonNull Call<ArrayList<RestaurantModel>> call, @NonNull final Throwable t) {

                        onFetchFailed();
                        result.addSource(dbSource, new Observer<ArrayList<RestaurantModel>>() {
                            @Override
                            public void onChanged(@Nullable ArrayList<RestaurantModel> resultType) {

                                result.setValue(Resource.error(t.getLocalizedMessage(), resultType));

                            }
                        });

                    }
                });


            }
        });

    }


    // Called to save the result of the API response into the database
    @WorkerThread
    protected abstract void saveCallResult(@NonNull ArrayList<RestaurantModel> item);

    // Called with the data in the database to decide whether it should be
    // fetched from the network.
    @MainThread
    protected abstract boolean shouldFetch(@Nullable ArrayList<RestaurantModel> data);

    // Called to get the cached data from the database
    @NonNull
    @MainThread
    protected abstract LiveData<ArrayList<RestaurantModel>> loadFromDb();

    // Called to create the API call.

    //@NonNull
    //@MainThread
    //protected abstract LiveData<ApiResponse<RequestType>> createCall();

    // Called when the fetch fails. The child class may want to reset components
    // like rate limiter.
    @MainThread
    protected void onFetchFailed() {
    }

    // returns a LiveData that represents the resource
    public LiveData<Resource<ArrayList<RestaurantModel>>> asLiveData() {
        return result;
    }

    @NonNull
    @MainThread
    protected abstract Call<ArrayList<RestaurantModel>> createCall();


}