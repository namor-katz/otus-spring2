package com.katzendorn;

import com.katzendorn.service.GreeterService;
import com.katzendorn.service.MainService;
import com.sun.tools.javac.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args){
        var ctx = new AnnotationConfigApplicationContext(Configure.class);
        MainService mainService = ctx.getBean(MainService.class);
        mainService.queste();
    }
}
