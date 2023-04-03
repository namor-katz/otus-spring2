package com.katzendorn.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * храним разделяемые текстовые переменные.
 */
@Service
public class CacheService {
    private final Map<String, String> cache = new HashMap<>();

    public void setValue(String key, String value){
        cache.put(key, value);
    }

    public String getValue(String key){
        return cache.get(key);
    }
}
