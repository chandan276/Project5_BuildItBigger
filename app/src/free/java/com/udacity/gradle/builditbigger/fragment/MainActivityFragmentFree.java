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
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.asynctask.JokesAsyncTaskFree;

public class MainActivityFragmentFree extends Fragment {

    ProgressBar progressBar = null;
    public String jokeString = null;

    public boolean enableTest = false;

    public MainActivityFragmentFree() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_free, container, false);

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

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    public void getJoke() {
        new JokesAsyncTaskFree().execute(this);
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
