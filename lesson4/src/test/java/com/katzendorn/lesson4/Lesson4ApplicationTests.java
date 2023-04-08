package com.katzendorn.lesson4;

import com.katzendorn.config.AppProps;
import com.katzendorn.service.CacheService;
import com.katzendorn.service.MainService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(properties = "spring.shell.interactive.enabled=false")//при  тестировании запрещаем запускаться шеллу.
class Lesson4ApplicationTests {
	@Autowired
	private AppProps props;//чё за фигня. почему только с аутовайред

	@Autowired
	private MainService mainService;
	@Autowired
	private CacheService cacheService;

	@Test
	void contextLoads() {}

	@Test
	void checkResourcePath(){
		assertNotNull(props.getResources());
	}

	@Test
	void isExistsCsv() throws IOException {
		Resource resource = new ClassPathResource(props.getResources());
		assertNotNull(resource.getInputStream().readAllBytes());
	}

	@ParameterizedTest
	@ValueSource(strings = {"3", "3", "3", "3", "3"})//очень неочевидный синтаксис. совершенно неясно сразу, почему оно будет их по одному подавать, а не сунет целиком, например.
	//а не, нихера оно их не прогоняет. оно пять раз запускает тест, и набивает валуе 5 таким образом. пиздец.
//	@MethodSource("provideStringsForIsBlank")
	void testOne(String arg){
		cacheService.setValue("login", "Vasja");
		ByteArrayInputStream in = new ByteArrayInputStream(arg.getBytes());
		System.setIn(in);
		mainService.queste();
	}

	@Deprecated
	private static Stream<String> provideStringsForIsBlank(){
		return Stream.of("3", "3", "3", "3", "3");
	}
}
