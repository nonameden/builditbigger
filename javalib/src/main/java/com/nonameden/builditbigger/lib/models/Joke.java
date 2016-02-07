package com.nonameden.builditbigger.lib.models;

/**
 * Created by nonameden on 6/02/16.
 */
public class Joke {
    private long id;
    private String joke;
    private String[] categories;

    public long getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }

    public String[] getCategories() {
        return categories;
    }

    public Joke() {
    }

    public Joke(String joke) {
        this.joke = joke;
    }
}
