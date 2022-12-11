package com.example.onepoint_ourtree.activities.main;

import android.content.Context;
import android.util.Log;

import com.example.onepoint_ourtree.R;
import com.example.onepoint_ourtree.api.models.Record;
import com.example.onepoint_ourtree.api.models.Root;
import com.example.onepoint_ourtree.api.models.Tree;
import com.example.onepoint_ourtree.api.services.ApiService;
import com.example.onepoint_ourtree.api.services.TreeService;
import com.example.onepoint_ourtree.common.ApiCallback;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel {
    private static final String TAG = "MainViewModel";
    private final Context context;
    private final TreeService service;


    public MainViewModel(Context context) {
        this.context = context;
        this.service = ApiService.getRetrofit().create(TreeService.class);
    }

    public void getTrees(int count, ApiCallback<ArrayList<Tree>> callback) {
        ArrayList<String> facts = new ArrayList<>(Arrays.asList("hauteurenm", "libellefrancais", "espece", "circonferenceencm", "adresse"));
        service.getTrees("les-arbres", 0, count, facts).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                Log.d(TAG, "onResponse: URL : " + call.request().url().url());
                Log.d(TAG, "onResponse: " + response.body());

                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Record> records = response.body().getRecords();
                    if (records != null) {
                        ArrayList<Tree> trees = new ArrayList<>();
                        for (Record record : records) {
                            trees.add(record.getTree());
                        }
                        callback.onSuccess(trees);
                    } else {
                        callback.onFailed(context.getString(R.string.no_data));
                    }
                } else {
                    callback.onFailed(context.getString(R.string.system_error));
                }

            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                callback.onFailed(context.getString(R.string.system_error));
            }
        });

    }
}
