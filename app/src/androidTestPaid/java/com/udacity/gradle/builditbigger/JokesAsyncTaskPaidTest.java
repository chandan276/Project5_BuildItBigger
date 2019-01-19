package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.asynctask.JokesAsyncTaskPaid;
import com.udacity.gradle.builditbigger.fragment.MainActivityFragmentPaid;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class JokesAsyncTaskPaidTest {

    @Test
    public void testJokesAsyncTask() throws Exception {
        MainActivityFragmentPaid fragment = new MainActivityFragmentPaid();
        fragment.enableTest = true;

        new JokesAsyncTaskPaid().execute(fragment);
        Thread.sleep(5000);
        assertTrue("Error: Fetched Joke = " + fragment.jokeString, fragment.jokeString != null);
    }

}
