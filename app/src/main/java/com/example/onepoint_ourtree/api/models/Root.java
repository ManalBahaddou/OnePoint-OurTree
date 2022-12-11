package com.example.onepoint_ourtree.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Root implements Serializable {

    @SerializedName("records")
    private ArrayList<Record> records;

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }
}
