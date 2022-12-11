package com.example.onepoint_ourtree.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Record implements Serializable {

    @SerializedName("fields")
    public Tree tree;

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}
