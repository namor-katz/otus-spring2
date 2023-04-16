package com.katzendorn.lesson4;

import com.katzendorn.service.CacheService;
import com.katzendorn.service.GreeterService;
import com.katzendorn.service.IOService;
import com.katzendorn.service.MainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.shell.InputProvider;
import org.springframework.shell.ResultHandlerService;
import org.springframework.shell.Shell;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("тесты главного класса и команд шелл")
@SpringBootTest(properties = "spring.shell.interactive.enabled=false")//при  тестировании запрещаем запускаться шеллу.
public class MainServiceTest {
    private static final String DEFAULT_LOGIN = "AnyUser";
    private static final String CUSTOM_LOGIN = "Вася";
    private static final String COMMAND_LOGIN = "login";
    private static final String COMMAND_LOGIN_SHORT = "l";
    private static final String COMMAND_LOGIN_PATTERN = "%s %s";
    @SpyBean
    private ResultHandlerService resultHandlerService;



    @Autowired
    private Shell shell;


    private InputProvider inputProvider;

    @Mock
    private CacheService cacheService;
    private ArgumentCaptor<Object> argumentCaptor;

    private MainService mainService;

    @Autowired
    private GreeterService greeterService;

    @Autowired
    private IOService ioService;

    @ParameterizedTest
    @ValueSource(strings = {"3", "3", "3", "3", "3"})//очень неочевидный синтаксис. совершенно неясно сразу, почему оно будет их по одному подавать, а не сунет целиком, например.
    void testOne(String arg){
        cacheService.setValue("login", "Vasja");
        ByteArrayInputStream in = new ByteArrayInputStream(arg.getBytes());
        System.setIn(in);
        mainService.queste();
    }


    @BeforeEach
    void setUp() {
        inputProvider = mock(InputProvider.class);
        argumentCaptor = ArgumentCaptor.forClass(Object.class);
    }

    @DisplayName("Вход пользователя")
    @Test
    public void greeterTest() throws Exception {
        when(inputProvider.readInput()).thenReturn(() -> COMMAND_LOGIN)
                .thenReturn(() -> COMMAND_LOGIN_SHORT)
                .thenReturn(() -> String.format(COMMAND_LOGIN_PATTERN, COMMAND_LOGIN_SHORT, CUSTOM_LOGIN))
                .thenReturn(null);
        shell.run(inputProvider);
        verify(resultHandlerService, times(3)).handle(argumentCaptor.capture());
        List<Object> results = argumentCaptor.getAllValues();
    }

}
