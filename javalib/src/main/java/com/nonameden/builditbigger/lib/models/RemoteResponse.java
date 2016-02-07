package com.nonameden.builditbigger.lib.models;

/**
 * Created by nonameden on 6/02/16.
 */
public class RemoteResponse<T> {

    private String type;
    private T value;

    public String getType() {
        return type;
    }

    public T getValue() {
        return value;
    }
}
