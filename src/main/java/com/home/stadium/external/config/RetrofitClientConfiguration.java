package com.home.stadium.external.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.stadium.external.apiFootball.client.ApiFootballClient;
import com.home.stadium.external.apiFootball.interceptor.ApiFootballAuthInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitClientConfiguration {
    private final RetrofitProperties properties;
    private final ObjectMapper objectMapper;

    public RetrofitClientConfiguration(ObjectMapper objectMapper, RetrofitProperties properties) {
        this.objectMapper = objectMapper;
        this.properties = properties;
    }

    private Retrofit retrofitClient(RetrofitProperties.RetrofitConnector connectorProperties) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(connectorProperties.getReadTimeout(), TimeUnit.MILLISECONDS)
                .connectTimeout(connectorProperties.getConnectionTimeout(), TimeUnit.MILLISECONDS)
                .addInterceptor(new ApiFootballAuthInterceptor(connectorProperties.getApiKey()))
                //.addInterceptor(loggingInterceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(connectorProperties.getUrl())
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(client)
                .build();
    }

    @Bean
    public ApiFootballClient apiFootballClient() {
        return retrofitClient(properties.getApiFootballConnector()).create(ApiFootballClient.class);
    }
}
