package com.svj.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class UserConfig {

    @Bean
    public ObjectMapper getObjectMapper(Jackson2ObjectMapperBuilder builder){
        return builder.build();
    }
}
