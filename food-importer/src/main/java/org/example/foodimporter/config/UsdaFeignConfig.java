package org.example.foodimporter.config;

import feign.RequestInterceptor;
import org.example.foodimporter.properties.UsdaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsdaFeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor(UsdaProperties props) {
        return requestTemplate -> requestTemplate.query("api_key", props.getApiKey());
    }
}
