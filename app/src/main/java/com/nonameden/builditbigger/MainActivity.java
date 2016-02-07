package com.nonameden.builditbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nonameden.builditbigger.infrastructure.tasks.GetJokeAsyncTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetJokeAsyncTask().execute();
    }
}
