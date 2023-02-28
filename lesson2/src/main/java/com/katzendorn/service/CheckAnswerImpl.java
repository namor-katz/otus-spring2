package com.katzendorn.service;

import com.katzendorn.entity.Quest;
import com.katzendorn.entity.SourceDataImpl;
import com.katzendorn.interfaces.CheckAnswer;
import com.katzendorn.interfaces.SourceData;

import java.util.Scanner;

public class CheckAnswerImpl implements CheckAnswer {
    private int rightAnswer = 0;
    private final IOService io;

    public CheckAnswerImpl(IOService io){
        this.io = io;
    }

    @Override
    public void printQuestions(Quest quest){
        io.printQuestions(quest);//у нас есть объявленный интерфейс, которым уже пользуются 1.5 землекопа. мы не имеем права обмануть их ожидания.
    }

    @Override
    public void checkAnswer(Quest q, String answer){
        int number;
        boolean result = false;
        if(answer == null || answer.isEmpty()) {
            printAnswer(result, q);
            return;
        }
        try {
            number = Integer.parseInt(answer);
        }catch (NumberFormatException nfe){
            number = -20;
        }
        if (number == q.getAnswer()+1){
            result = true;
        }
        printAnswer(result, q);
    }

    private void printAnswer(boolean result, Quest q){
        if(result) rightAnswer++;
        io.printAnswer(result, q);
    }

    @Override
    public String getInput() {
       return io.getInput();
    }

    @Override
    public int getResult(){
        return rightAnswer;
    }
}
