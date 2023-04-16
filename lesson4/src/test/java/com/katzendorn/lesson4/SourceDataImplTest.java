package com.katzendorn.lesson4;

import com.katzendorn.entity.Quest;
import com.katzendorn.repository.SourceDataImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = "spring.shell.interactive.enabled=false")//при  тестировании запрещаем запускаться шеллу.
public class SourceDataImplTest {
    @Autowired
    private SourceDataImpl sourceData;

    @Test
    public void isQuestsExist(){
        assertNotNull(sourceData.getQuests());
    }

    @Test
    public void isFive(){
        assertEquals(5, sourceData.getQuests().size());
    }

    @Test
    public void isRightAnswer(){
        boolean isRight = true;
        List<Quest> quests = sourceData.getQuests();
        for(Quest q : quests){
            if(q.getAnswer() != 2){
                isRight = false;
            }
        }
        assertTrue(isRight);
    }
}
