package com.katzendorn.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {
    public int calculate(int a, int b){
        System.out.println("Я, так-то, из сервиса!");
        return a + b;
    }
}
