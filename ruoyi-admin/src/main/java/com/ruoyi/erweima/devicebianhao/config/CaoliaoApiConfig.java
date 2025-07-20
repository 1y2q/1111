package com.ruoyi.erweima.devicebianhao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaoliaoApiConfig {
    @Value("${caoliao.api.url}")
    private String url;

    @Value("${caoliao.api.token}")
    private String token;

    public String getUrl() {
        return url;
    }

    public String getToken() {
        return token;
    }
}