package com.katzendorn.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.katzendorn.interfaces.Constants.*;

@Getter
@Setter
public class Quest {
    private final int id;
    private final String question;
    private List<String> versions;
    private final int answer;

    public Quest(Map<String, Object> sourceMap){
        this.id = (int) sourceMap.get(ID);
        this.question = (String) sourceMap.get(QUEST);
        this.versions = (List<String>) sourceMap.get(VERSIONS);
        this.answer = (int) sourceMap.get(ANSWER);
    }
}
