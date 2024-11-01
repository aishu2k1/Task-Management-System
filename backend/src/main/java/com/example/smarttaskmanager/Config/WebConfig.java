package com.example.smarttaskmanager.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://localhost:4000", "http://localhost:3000", "http://host.docker.internal:4000", "http://host.docker.internal:3000") // Your React app's URL
                .allowedMethods("*") // Specify allowed methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // If you want to allow credentials
    }
}

