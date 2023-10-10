package com.javatechie.report.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*") // Replace with your frontend's URL
//                .allowedOrigins("http://localhost") //not working: Replace with your frontend's URL
//                .allowedOrigins("http://localhost:63342/*") // not working : Replace with your frontend's URL
                .allowedMethods("GET", "POST") // Add more if needed
                .allowCredentials(true);
    }
}

