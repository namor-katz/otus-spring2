package com.katzendorn.lesson3;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

public class MyBean {

    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}