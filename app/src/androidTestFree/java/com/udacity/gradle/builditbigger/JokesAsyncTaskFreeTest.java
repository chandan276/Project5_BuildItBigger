package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.asynctask.JokesAsyncTaskFree;
import com.udacity.gradle.builditbigger.fragment.MainActivityFragmentFree;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class JokesAsyncTaskFreeTest {

    @Test
    public void testJokesAsyncTask() throws Exception {
        MainActivityFragmentFree fragment = new MainActivityFragmentFree();
        fragment.enableTest = true;

        new JokesAsyncTaskFree().execute(fragment);
        Thread.sleep(5000);
        assertTrue("Error: Fetched Joke = " + fragment.jokeString, fragment.jokeString != null);
    }
}
