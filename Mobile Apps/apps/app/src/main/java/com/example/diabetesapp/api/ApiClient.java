// ApiClient.java
package com.example.diabetesapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://192.168.100.187:5051/api/";
    //private static final String BASE_URL = "http://ec2-3-107-178-245.ap-southeast-2.compute.amazonaws.com:5050/api/";
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
        }
        return retrofit;
    }
}
