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

    public Quest(int id, String question, List<String> versions, int answer){
        this.id = id;
        this.question = question;
        this.versions = versions;
        this.answer = answer;
    }
}
