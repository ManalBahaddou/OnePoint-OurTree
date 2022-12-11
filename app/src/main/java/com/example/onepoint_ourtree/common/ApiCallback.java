package com.example.onepoint_ourtree.common;

public interface ApiCallback<T> {
    void onSuccess(T data);
    void onFailed(String error);
}
