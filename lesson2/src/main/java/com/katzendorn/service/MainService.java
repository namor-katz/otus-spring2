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
    private final GreeterService greeterService;
    private String name = "Anonimous";//он никогда не будет анонимусом.

    public MainService(SourceData csv, CheckAnswer checkAnswer, IOService io, GreeterService gs){
        this.csv = csv;
        this.checkAnswer = checkAnswer;
        this.ioService = io;
        this.greeterService = gs;
    }

    public void queste(){
        String name = greeterService.whoAmi();
        this.name = name;
        ioService.simplePrint("hallo " + name);
        String [] content = csv.getAllContent();
        for(String s : content){
            quests.add(new Quest(csv.getQuestionSource(s)));
        }
        if(!quests.isEmpty()){
            ioService.simplePrint("Read next question, and print number right answer");
            for(Quest q : quests){
                ioService.printQuestions(q);
                String v = checkAnswer.getInput();
                checkAnswer.checkAnswer(q, v);
            }
        }
    }

    public int getResult(){
        return checkAnswer.getResult();
    }

    public String getName(){
        return name;
    }
}
