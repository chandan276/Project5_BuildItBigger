package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import com.chandan.android.joketellerlib.JokeTeller;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)

public class MyEndpoint {

    @ApiMethod(name = "sendJokes")
    public MyBean sendJokes() {
        MyBean response = new MyBean();

        JokeTeller jokeTeller = new JokeTeller();
        response.setData(jokeTeller.sendJokesToGCE());

        return response;
    }
}
