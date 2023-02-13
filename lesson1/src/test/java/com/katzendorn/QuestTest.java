package com.katzendorn;

import static org.junit.jupiter.api.Assertions.*;
import com.katzendorn.entity.Quest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class QuestTest {
    private final List<Quest> qlist = new ArrayList<>();
    private final Quest quest = new Quest("1;what color can the car be?;1) white;2) black;3) fatherland manufacter;2");
    private final Quest quest2 = new Quest("3;The Answer to the Ultimate Question of Life;1) what?;2) Eat;3) 42;2");

    @BeforeEach
    void init(){
        qlist.add(quest);
        qlist.add(quest2);
    }

    @Test
    void checkSize(){
        assertEquals(qlist.size(), 2);
    }

    @Test
    void checkOneQuest(){
        assertNotNull(quest.getVersions());
    }
}
