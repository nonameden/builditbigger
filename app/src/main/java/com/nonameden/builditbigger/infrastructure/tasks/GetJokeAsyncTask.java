package com.nonameden.builditbigger.infrastructure.tasks;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.nonameden.builditbigger.backend.myApi.MyApi;
import com.nonameden.builditbigger.backend.myApi.model.Joke;

import java.io.IOException;

/**
 * Created by nonameden on 6/02/16.
 */
public class GetJokeAsyncTask extends AsyncTask<Void, Void, String> {

    private final MyApi apiService;

    public GetJokeAsyncTask() {
        apiService = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("https://built-it-bigger-1202.appspot.com/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                })
                .build();
    }

    @Override
    protected String doInBackground(Void[] params) {
        Joke joke = null;
        try {
            joke = apiService.randomJoke().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return joke == null ? "" : joke.getJoke();
    }
}
