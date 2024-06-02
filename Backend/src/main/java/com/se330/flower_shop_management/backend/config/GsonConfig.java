package com.se330.flower_shop_management.backend.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Configuration
public class GsonConfig {

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        gsonHttpMessageConverter.setGson(gson);
        return gsonHttpMessageConverter;
    }
}
