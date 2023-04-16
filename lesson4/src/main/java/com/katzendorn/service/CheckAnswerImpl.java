package com.katzendorn.service;

import com.katzendorn.entity.Quest;
import com.katzendorn.interfaces.CheckAnswer;
import org.springframework.stereotype.Service;

@Service
public class CheckAnswerImpl implements CheckAnswer {
    private int rightAnswer = 0;
    private final IOService io;

    public CheckAnswerImpl(IOService io){
        this.io = io;
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
    public int getResult(){
        return rightAnswer;
    }
}
