package com.example.onepoint_ourtree.activities.main;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.onepoint_ourtree.activities.BaseActivities;
import com.example.onepoint_ourtree.R;
import com.example.onepoint_ourtree.adapters.TreeAdapter;
import com.example.onepoint_ourtree.api.models.Tree;
import com.example.onepoint_ourtree.api.models.TreeViewModel;
import com.example.onepoint_ourtree.common.ApiCallback;
import com.example.onepoint_ourtree.configs.AppConfig;

import java.util.ArrayList;

public class MainActivity extends BaseActivities {

    private RecyclerView recyclerView;
    private ArrayList<TreeViewModel> items = new ArrayList<>();
    private TreeAdapter adapter;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(this);
        viewModel = new MainViewModel(context);
        findViews();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.loadData();
    }

    private void initData() {
        this.adapter = new TreeAdapter(this, items);
        this.recyclerView.setAdapter(adapter);
    }

    private void findViews() {
        recyclerView = findViewById(R.id.treeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }


    private void loadData() {
        this.showLoader();
        viewModel.getTrees(AppConfig.TREES_COUNT, new ApiCallback<ArrayList<Tree>>() {
            @Override
            public void onSuccess(ArrayList<Tree> data) {
                items.clear();
                if (data != null && !data.isEmpty()) {
                    for (Tree tree : data) {
                        items.add(new TreeViewModel(tree));
                    }
                }
                updateUI();
            }

            @Override
            public void onFailed(String error) {
                hideLoader();
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void updateUI() {
        hideLoader();
        adapter.notifyDataSetChanged();
    }


}