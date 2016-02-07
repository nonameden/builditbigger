package com.nonameden.builditbigger.lib;

import com.nonameden.builditbigger.lib.models.Joke;
import com.nonameden.builditbigger.lib.models.RemoteResponse;

import retrofit.http.GET;

/**
 * Created by nonameden on 6/02/16.
 */
public interface JokeService {

    @GET("/random")
    RemoteResponse<Joke> randomJoke();
}
