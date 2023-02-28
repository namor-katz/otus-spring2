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
        assertEquals(content.split("\n").length, 5);
    }
}
