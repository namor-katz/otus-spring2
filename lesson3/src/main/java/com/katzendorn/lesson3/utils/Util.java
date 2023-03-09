package com.katzendorn.lesson3.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class Util {
    public Resource loadCsvFileByPath(){
        return new ClassPathResource("one.csv");
    }
}
