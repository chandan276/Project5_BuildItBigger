package com.udacity.gradle.builditbigger.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.chandan.android.jokedisplaylib.JokesListActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.asynctask.JokesAsyncTaskPaid;

public class MainActivityFragmentPaid extends Fragment {

    ProgressBar progressBar = null;
    public String jokeString = null;

    public boolean enableTest = false;

    public MainActivityFragmentPaid() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_paid, container, false);

        Button button = (Button) root.findViewById(R.id.button_joke_teller);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                getJoke();
            }
        });

        progressBar = (ProgressBar) root.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        return root;
    }

    public void getJoke() {
        new JokesAsyncTaskPaid().execute(this);
    }

    public void openJokesListActivity() {
        if (!enableTest) {
            Context context = getActivity();
            Intent intent = new Intent(context, JokesListActivity.class);
            intent.putExtra(Intent.EXTRA_TEXT, jokeString);
            context.startActivity(intent);
            progressBar.setVisibility(View.GONE);
        }
    }
}
