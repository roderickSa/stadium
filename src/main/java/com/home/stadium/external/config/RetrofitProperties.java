package com.home.stadium.external.config;

import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "retrofit")
public class RetrofitProperties {
    private static final int DEFAULT_CONNECTION_TIMEOUT = 1000;
    private static final int DEFAULT_READ_TIMEOUT = 5000;
    private RetrofitConnector ApiFootballConnector;

    public static class RetrofitConnector {

        private String url;
        private String apiKey;
        private Integer readTimeout;
        private Integer connectionTimeout;

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getApiKey() {
            return this.apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public Integer getReadTimeout() {
            return Optional.ofNullable(this.readTimeout).orElse(DEFAULT_READ_TIMEOUT);
        }

        public void setReadTimeout(Integer readTimeout) {
            this.readTimeout = readTimeout;
        }

        public Integer getConnectionTimeout() {
            return Optional.ofNullable(this.connectionTimeout).orElse(DEFAULT_CONNECTION_TIMEOUT);
        }

        public void setConnectionTimeout(Integer connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
        }
    }
}
