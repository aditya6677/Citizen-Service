package com.app.adi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {

    @Bean
    public String connect(){
        return "Connected to Adi";
    }

    @Bean
    public String disconnect(){
        return "Disconnected from Adi";
    }
}
