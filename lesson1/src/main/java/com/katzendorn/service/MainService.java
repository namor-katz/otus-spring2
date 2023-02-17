package com.katzendorn.service;

import com.katzendorn.entity.Quest;
import com.katzendorn.interfaces.CheckAnswer;
import com.katzendorn.interfaces.SourceData;

import java.util.LinkedList;
import java.util.List;

public class MainService {
    private final SourceData csv;
    private final CheckAnswer checkAnswer;
    private final IOService ioService;
    private final List<Quest> quests = new LinkedList<>();

    public MainService(SourceData csv, CheckAnswer checkAnswer, IOService io){
        this.csv = csv;
        this.checkAnswer = checkAnswer;
        this.ioService = io;
    }

    public void queste(){
        String [] content = csv.getAllContent();
        for(String s : content){
            quests.add(new Quest(csv.getQuestionSource(s)));
        }
        if(!quests.isEmpty()){
            System.out.println("Read next questions, and print number right answer");
            for(Quest q : quests){
                checkAnswer.printQuestions(q);
                String v = checkAnswer.getInput();
                checkAnswer.checkAnswer(q, v);
            }
        }
    }
}
