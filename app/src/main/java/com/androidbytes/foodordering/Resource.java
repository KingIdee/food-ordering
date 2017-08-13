package com.androidbytes.foodordering;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by idee on 8/12/17.
 */

/**
 * Adapted from google's documentation https://developer.android.com/topic/libraries/architecture/guide.html#addendum
 * @param <T>
 */

public class Resource<T> {

    @NonNull public final AsyncTask.Status status;
    @Nullable public final T data;
    @Nullable public final String message;
    private Resource(@NonNull AsyncTask.Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

   /* public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }*/

}
