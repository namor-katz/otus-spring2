package com.katzendorn.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Quest {
    private final int id;
    private final String question;
    private final List<String> versions = new ArrayList<>();
    private final int answer;

    public Quest(String source){
        String[] array = source.split(";");
        this.id = Integer.parseInt(array[0]);
        this.question = array[1];
        for(int i=2; i<5; i++){
            versions.add(array[i]);
        }
        answer = Integer.parseInt(array[array.length-1]);
    }
}
