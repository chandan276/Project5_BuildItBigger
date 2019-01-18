package com.chandan.android.jokedisplaylib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class JokesListActivity extends AppCompatActivity {

    private String jokeStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_list);

        getJokesData();
        initializeRecyclerView();
    }

    private void getJokesData() {
        Intent intent = getIntent();
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            jokeStr = intent.getStringExtra(Intent.EXTRA_TEXT);
        }
    }

    private void initializeRecyclerView() {
        RecyclerView mJokesRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_jokes);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mJokesRecyclerView.setLayoutManager(layoutManager);

        mJokesRecyclerView.setHasFixedSize(true);

        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(mJokesRecyclerView.getContext(),
                layoutManager.getOrientation());
        mJokesRecyclerView.addItemDecoration(mDividerItemDecoration);

        JokesListAdapter mAdapter = new JokesListAdapter(jokeStr);
        mJokesRecyclerView.setAdapter(mAdapter);
    }
}
