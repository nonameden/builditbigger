package com.nonameden.builditbigger.lib.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by nonameden on 8/02/16.
 */
public class JokeActivity extends AppCompatActivity {

    private static final String EXTRA_JOKE_TEXT = "extra-joke-text";
    private TextView jokeTextView;

    public static Intent getLaunchIntent(@NonNull Context context, @NonNull String jokeText) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(EXTRA_JOKE_TEXT, jokeText);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configureActionBar();
        setContentView(R.layout.activity_joke);

        String jokeText = getIntent().getStringExtra(EXTRA_JOKE_TEXT);
        jokeTextView = (TextView) findViewById(R.id.jokeText);
        jokeTextView.setText(jokeText);
    }

    private void configureActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
