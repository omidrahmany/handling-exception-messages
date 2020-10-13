package com.example.exceptionhandling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class BeanConfiguration {

    @Bean
    public File[] getRepositoryFile() {
        File[] files = new File[]{
                new File(getClass().getClassLoader().getResource("messages_fa.properties").getFile()),
                new File("/root/config/messages_fa.properties")
        };
        return files;
    }
}
