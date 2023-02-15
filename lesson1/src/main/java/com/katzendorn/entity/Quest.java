package com.katzendorn.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Quest {
    private final int id;
    private final String question;
    private List<String> versions = new LinkedList<>();
    private final int answer;

    @Deprecated
    public Quest(String source){
        String[] array = source.split(";");
        this.id = Integer.parseInt(array[0]);
        this.question = array[1];

        for(int i=2; i<5; i++){
            versions.add(array[i]);
        }

        answer = Integer.parseInt(array[array.length-1]);
    }

    @SuppressWarnings("unchecked")
    public Quest(Object[] source){
        this.id = (Integer) source[0];
        this.question = (String) source[1];
        this.versions = (List<String>) source[2];
        this.answer = (Integer) source[3];
    }
}
