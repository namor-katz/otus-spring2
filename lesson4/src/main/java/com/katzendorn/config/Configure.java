package com.katzendorn.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(AppProps.class)
@ComponentScan(basePackages = "com.katzendorn")
public class Configure {
}
