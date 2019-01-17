package com.udacity.gradle.builditbigger.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.fragment.MainActivityFragment;

import java.io.IOException;
import java.util.ArrayList;

public class JokesAsyncTask extends AsyncTask<MainActivityFragment, Void, String> {

    private static MyApi myApiService = null;
    private Context context;

    private MainActivityFragment mainActivityFragment;

    @Override
    protected String doInBackground(MainActivityFragment... mainActivityFragments) {

        mainActivityFragment = mainActivityFragments[0];
        context = mainActivityFragment.getActivity();

        if(myApiService == null) {
            MyApi.Builder builder = new
                    MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")

                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {

                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        try {
            return myApiService.sendJokes().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mainActivityFragment.jokeString = result;
        mainActivityFragment.openJokesListActivity();
    }
}
