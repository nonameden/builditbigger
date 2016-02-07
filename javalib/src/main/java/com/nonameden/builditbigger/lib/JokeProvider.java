package com.nonameden.builditbigger.lib;

import com.nonameden.builditbigger.lib.models.Joke;

import retrofit.RestAdapter;


public class JokeProvider {
    private static final String CHUCK_NORRIS_JOKES_ENDPOINT = "http://api.icndb.com/jokes";
    private final JokeService service;

    public JokeProvider() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(CHUCK_NORRIS_JOKES_ENDPOINT)
                .build();

        service = adapter.create(JokeService.class);
    }

    public Joke getRandomJoke() {
        Joke joke = null;

        try {
            joke = service.randomJoke().getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return joke;
    }
}
