package com.nonameden.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.nonameden.builditbigger.infrastructure.tasks.GetJokeAsyncTask;
import com.nonameden.builditbigger.lib.activity.JokeActivity;

abstract class BaseMainActivity extends AppCompatActivity implements GetJokeAsyncTask.OnJokeReceivedListener, View.OnClickListener {

    private ProgressBar progressView;
    private Button showJokeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressView = (ProgressBar) findViewById(R.id.progress);
        showJokeButton = (Button) findViewById(R.id.showJoke);
        showJokeButton.setOnClickListener(this);

        hideProgress();
    }

    @Override
    public void onJokeReceived(String jokeText) {
        hideProgress();
        navigateToNextActivity(jokeText);
    }

    private void showProgress() {
        showJokeButton.setVisibility(View.GONE);
        progressView.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        showJokeButton.setVisibility(View.VISIBLE);
        progressView.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.showJoke:
                showJoke();
                break;
        }
    }

    protected void showJoke() {
        showProgress();
        new GetJokeAsyncTask(this).execute();
    }

    private void navigateToNextActivity(String jokeText) {
        Intent intent = JokeActivity.getLaunchIntent(this, jokeText);
        startActivity(intent);
    }
}
