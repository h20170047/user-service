package com.svj.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.svj.annotations.ExcludeAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@ExcludeAop
public class UserConfig {

    @Bean
    public ObjectMapper getObjectMapper(Jackson2ObjectMapperBuilder builder){
        return builder.build();
    }
}
