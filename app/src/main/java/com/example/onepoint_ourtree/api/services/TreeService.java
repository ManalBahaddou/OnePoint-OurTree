package com.example.onepoint_ourtree.api.services;

import com.example.onepoint_ourtree.api.models.Root;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TreeService {

    @GET ("api/records/1.0/search/")
    Call<Root> getTrees(

            @Query("dataset") String dataset,
            @Query("start") int start,
            @Query("rows") int rows,
            @Query("facet") ArrayList<String> facet

    );


}
