package com.nonameden.builditbigger.infrastructure.tasks;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

/**
 * Created by nonameden on 8/02/16.
 */
@RunWith(AndroidJUnit4.class)
public class GetJokeAsyncTaskTest {

    private GetJokeAsyncTask task;
    private GetJokeAsyncTask.OnJokeReceivedListener listener;

    @Before
    public void setUp() {
        listener = new GetJokeAsyncTask.OnJokeReceivedListener() {
            @Override
            public void onJokeReceived(String jokeText) {}
        };
        task = new GetJokeAsyncTask(listener);
    }

    @Test
    public void testTaskShouldAlwaysReturnNotNullString() {
        // We gonna check that AsyncTask.doInBackground() return not null
        String jokeText = null;
        try {
            jokeText = task.get();
        } catch (Exception e) {
            throw new RuntimeException("Test failed", e);
        }
        assertNotNull(jokeText);
    }
}
