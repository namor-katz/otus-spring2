package com.katzendorn.lesson3;

import com.katzendorn.lesson3.config.Configure;
import com.katzendorn.lesson3.services.IOService;
import com.katzendorn.lesson3.services.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Lesson3Application {
	private Configure cf;//?????????????????????????????????? блядь, да какого хуя?


	public static void main(String[] args) {
		SpringApplication.run(Lesson3Application.class, args);

		var ctx = new AnnotationConfigApplicationContext(Configure.class);
		System.out.println("Pr");
		var blad = ctx.getBean(MainService.class);

		blad.queste();
//		mainBean.queste();
//		Predicate<String> predicate = s -> s.length() > 0;//TODO убрать строку, посмотреть чё они там делают в спринг по быстрому.
	}

}
