package com.katzendorn.lesson3.interfaces;

import com.katzendorn.lesson3.entity.Quest;

public interface CheckAnswer {
    void checkAnswer(Quest quest, String answer);

    int getResult();
}
