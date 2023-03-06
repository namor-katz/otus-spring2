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
    private final GreeterService greeterService;

    public MainService(SourceData csv, CheckAnswer checkAnswer, IOService io, GreeterService gs){
        this.csv = csv;
        this.checkAnswer = checkAnswer;
        this.ioService = io;
        this.greeterService = gs;
    }

    public void queste(){
        String name = greeterService.whoAmi();
        ioService.simplePrint("hallo " + name);
        List<Quest> quests = csv.getQuests();
        if(!quests.isEmpty()){
            ioService.simplePrint("Read next question, and print number right answer");
            for(Quest q : quests){
                ioService.printQuestions(q);
                String v = ioService.getInput();
                checkAnswer.checkAnswer(q, v);
            }
        }
        ioService.simplePrint(name + " you have " + getResult() + " correct answers of 5");
    }

    public int getResult(){
        return checkAnswer.getResult();
    }
}
