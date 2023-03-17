package com.katzendorn.lesson3;

import com.katzendorn.lesson3.services.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson3Application {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(Lesson3Application.class, args);//упс, ничего с контекстом городить не нужно. он возвращается тут...
		var mainService = ctx.getBean(MainService.class);
		mainService.queste();
	}
}
