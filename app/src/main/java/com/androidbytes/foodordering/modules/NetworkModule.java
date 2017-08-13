package com.androidbytes.foodordering.modules;

import com.androidbytes.foodordering.RestaurantModel;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by idee on 8/12/17.
 */

/**
 * This is a module class for Dependency Injection
 */
public class NetworkModule {

    /**
     * Use http://www.vogella.com/tutorials/Retrofit/article.html (Interceptors for better implementation)
     * when API token is required
     */

    public interface WebService {
        @GET("/publicapi/v1/restaurant/search?method=both&street-address=316+W.+Washington+Ave.+Madison,+WI")
        Call<RestaurantModel> makeRequest(@Header("X-Access-Token") String authorization);
    }

    public static OkHttpClient providesOkHttpClientBuilder(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return httpClient.readTimeout(1200, TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS).build();

    }

    public static WebService providesWebService () {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.eatstreet.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder
                .client(providesOkHttpClientBuilder())
                .build();

        return retrofit.create(WebService.class);

    }

}
