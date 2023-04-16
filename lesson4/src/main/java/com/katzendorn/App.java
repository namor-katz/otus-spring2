package com.katzendorn;

import com.katzendorn.service.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		var ctx = SpringApplication.run(App.class, args);
		var mainService = ctx.getBean(MainService.class);
		mainService.queste();
	}
}
