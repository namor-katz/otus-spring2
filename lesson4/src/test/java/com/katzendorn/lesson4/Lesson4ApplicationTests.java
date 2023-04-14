package com.katzendorn.lesson4;

import com.katzendorn.config.AppProps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(properties = "spring.shell.interactive.enabled=false")//при  тестировании запрещаем запускаться шеллу.
class Lesson4ApplicationTests {
	@Autowired
	private AppProps props;//чё за фигня. почему только с аутовайред

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
}
