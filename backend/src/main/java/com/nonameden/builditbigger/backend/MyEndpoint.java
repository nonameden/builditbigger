/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.nonameden.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.nonameden.builditbigger.lib.JokeProvider;
import com.nonameden.builditbigger.lib.models.Joke;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.builditbigger.nonameden.com",
    ownerName = "backend.builditbigger.nonameden.com",
    packagePath=""
  )
)
public class MyEndpoint {

    private final JokeProvider jokeProvider = new JokeProvider();

    @ApiMethod(name = "randomJoke")
    public Joke randomJoke() {
        return jokeProvider.getRandomJoke();
    }
}
