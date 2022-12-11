package com.example.onepoint_ourtree.api.models;

import android.content.Context;
import android.content.Intent;

import com.example.onepoint_ourtree.activities.details.DescriptionActivity;

public class TreeViewModel {


    private Tree model;

    public TreeViewModel(Tree model) {
        this.model = model;
    }

    public void goToDetail(Context context) {
        Intent intent = new Intent(context, DescriptionActivity.class);
        intent.putExtra("TREE", model);
        context.startActivity(intent);
    }

    public String getTitre() {
        return model.getNom();
    }
}
