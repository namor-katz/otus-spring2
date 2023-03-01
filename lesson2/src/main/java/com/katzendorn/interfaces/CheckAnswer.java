package com.katzendorn.interfaces;

import com.katzendorn.entity.Quest;

public interface CheckAnswer {
    void checkAnswer(Quest quest, String answer);

    String getInput();
    int getResult();
}
