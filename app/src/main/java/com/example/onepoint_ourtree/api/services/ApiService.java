package com.example.onepoint_ourtree.api.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static Retrofit retrofit;
    private static String BASE_URL = "https://opendata.paris.fr/ ";

    public static Retrofit getRetrofit() {
        if(retrofit==null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        } return retrofit;

    }

}
