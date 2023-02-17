package com.katzendorn.interfaces;

import com.katzendorn.entity.Quest;

public interface CheckAnswer {
    void printQuestions(Quest quest);
    void checkAnswer(Quest quest, String answer);
//    void printAnswer(boolean result, Quest q);

    String getInput();
}
