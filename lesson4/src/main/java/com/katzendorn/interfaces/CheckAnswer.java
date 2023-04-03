package com.katzendorn.interfaces;

import com.katzendorn.entity.Quest;

public interface CheckAnswer {
    void checkAnswer(Quest quest, String answer);

    int getResult();
}
