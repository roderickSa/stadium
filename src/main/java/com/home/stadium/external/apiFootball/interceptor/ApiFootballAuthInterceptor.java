package com.home.stadium.external.apiFootball.interceptor;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiFootballAuthInterceptor implements Interceptor {
    private final String apiKey;

    public ApiFootballAuthInterceptor(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request originalRequest = chain.request();
        HttpUrl originalUrl = originalRequest.url();

        HttpUrl newUrl = originalUrl.newBuilder()
                .addQueryParameter("APIkey", apiKey)
                .build();

        Request newRequest = originalRequest.newBuilder()
                .url(newUrl)
                .build();

        return chain.proceed(newRequest);
    }
}
