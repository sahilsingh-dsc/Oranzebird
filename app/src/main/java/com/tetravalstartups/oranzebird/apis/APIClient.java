package com.tetravalstartups.oranzebird.apis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofitRest;
    private static final String BASE_URL = "http://103.145.50.28/Ashish_dubey/orangebird/";

    public static Retrofit getRetrofitInstance() {
        if (retrofitRest == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofitRest = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofitRest;
    }

}
