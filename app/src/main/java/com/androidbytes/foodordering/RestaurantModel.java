package com.androidbytes.foodordering;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by idee on 8/10/17.
 */

public class RestaurantModel {

    /**
     * This class was generated using http://www.jsonschema2pojo.org/
     */

    @SerializedName("address") @Expose public Address address;
    @SerializedName("restaurants") @Expose public ArrayList<Restaurant> restaurants = null;

    public class Address {

        @SerializedName("apiKey") @Expose public Object apiKey;
        @SerializedName("streetAddress") @Expose public String streetAddress;
        @SerializedName("latitude") @Expose public double latitude;
        @SerializedName("longitude") @Expose public double longitude;
        @SerializedName("city")
        @Expose
        public String city;
        @SerializedName("state")
        @Expose
        public String state;
        @SerializedName("zip")
        @Expose
        public String zip;
        @SerializedName("aptNumber")
        @Expose
        public Object aptNumber;
    }

    public class Hours {

        @SerializedName("Monday") @Expose public ArrayList<String> monday = null;
        @SerializedName("Saturday") @Expose public ArrayList<String> saturday = null;
        @SerializedName("Sunday") @Expose public ArrayList<String> sunday = null;
        @SerializedName("Wednesday") @Expose public ArrayList<String> wednesday = null;
        @SerializedName("Tuesday") @Expose public ArrayList<String> tuesday = null;
        @SerializedName("Friday") @Expose public ArrayList<String> friday = null;
        @SerializedName("Thursday") @Expose public ArrayList<String> thursday = null;

    }

    public class Restaurant {

        @SerializedName("apiKey")
        @Expose
        public String apiKey;
        @SerializedName("deliveryMin")
        @Expose
        public double deliveryMin;
        @SerializedName("deliveryPrice")
        @Expose
        public double deliveryPrice;
        @SerializedName("logoUrl")
        @Expose
        public String logoUrl;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("streetAddress")
        @Expose
        public String streetAddress;
        @SerializedName("city")
        @Expose
        public String city;
        @SerializedName("state")
        @Expose
        public String state;
        @SerializedName("zip")
        @Expose
        public String zip;
        @SerializedName("foodTypes")
        @Expose
        public ArrayList<String> foodTypes = null;
        @SerializedName("phone")
        @Expose
        public String phone;


        @SerializedName("latitude") @Expose public double latitude;
        @SerializedName("longitude") @Expose public double longitude;
        @SerializedName("minFreeDelivery")
        @Expose
        public int minFreeDelivery;
        @SerializedName("taxRate")
        @Expose
        public double taxRate;
        @SerializedName("acceptsCash")
        @Expose
        public boolean acceptsCash;
        @SerializedName("acceptsCard")
        @Expose
        public boolean acceptsCard;
        @SerializedName("offersPickup")
        @Expose
        public boolean offersPickup;
        @SerializedName("offersDelivery")
        @Expose
        public boolean offersDelivery;
        @SerializedName("isTestRestaurant")
        @Expose
        public boolean isTestRestaurant;
        @SerializedName("minWaitTime")
        @Expose
        public int minWaitTime;
        @SerializedName("maxWaitTime")
        @Expose
        public int maxWaitTime;
        @SerializedName("open")
        @Expose
        public boolean open;
        @SerializedName("url") @Expose public String url;
        @SerializedName("hours") @Expose public Hours hours;
        @SerializedName("timezone") @Expose public String timezone;

    }

}
