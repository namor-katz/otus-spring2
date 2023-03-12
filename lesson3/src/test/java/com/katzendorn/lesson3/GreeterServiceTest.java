package com.katzendorn.lesson3;

import com.katzendorn.lesson3.services.GreeterService;
import com.katzendorn.lesson3.services.IOService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class GreeterServiceTest {
    private GreeterService greeterService;
    private InputStream sysIn;
    private ByteArrayInputStream in;
    private final String str = "Roman";

    @BeforeEach
    void init(){
        IOService ioService = new IOService();
        greeterService = new GreeterService(ioService);
        sysIn = System.in;
        in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
    }

    @Test
    void isBeanExists(){
        assertNotNull(greeterService);
    }

    @Test
    void testUserInput(){
        assertEquals(greeterService.whoAmi(), str);
    }
}
