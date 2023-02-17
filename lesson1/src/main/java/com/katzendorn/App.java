package com.katzendorn;

import com.katzendorn.service.MainService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        MainService mainService = ctx.getBean(MainService.class);
        mainService.queste();
    }
}
