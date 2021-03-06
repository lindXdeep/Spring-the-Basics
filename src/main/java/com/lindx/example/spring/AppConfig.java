package com.lindx.example.spring;

import java.text.DateFormat;
import java.util.Date;

import com.lindx.example.beans.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
@Configuration
@PropertySource("classpath:client.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public Client client() {
        Client client = new Client();
                client.setId(environment.getRequiredProperty("id"));
                client.setFullName(environment.getRequiredProperty("name"));
                client.setGreeting(environment.getRequiredProperty("greeting"));

        return client;
    }

    @Bean
    public Date newDate() {
        return new Date();
    }

    @Bean
    public DateFormat dateFormat() {
        return DateFormat.getDateTimeInstance();
    }
}