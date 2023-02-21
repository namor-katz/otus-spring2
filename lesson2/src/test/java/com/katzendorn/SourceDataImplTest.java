package com.katzendorn;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SourceDataImplTest {
    private String content;

    @BeforeEach
    void init() throws IOException {
        Resource resource = new ClassPathResource("one.csv");
        File file = resource.getFile();
        content = new String(Files.readAllBytes(file.toPath()));
    }

    @Test
    void isContentExists(){
        assertNotNull(content);
    }

    @Test
    void checkCountQuests(){
        assert(content.split("\n").length == 5);
    }

    @Test
    void checkOneQuest(){
        String[] arr = content.split("\n");
        String[] expected1 = "1;what color can the car be?;1) white;2) black;3) fatherland manufacter;2".split(";");
        assert(arr.length == 5);
        assertEquals(6, arr[0].split(";").length);
        assertArrayEquals(expected1, arr[0].split(";"));
        System.out.println("file success readed");
    }

    @Test
    void ff(){

    }
}
