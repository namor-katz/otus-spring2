package com.katzendorn.lesson3.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(AppProps.class)
@ComponentScan(basePackages = "com.katzendorn.lesson3")//чё оно истерит то?
public class Configure {
}
