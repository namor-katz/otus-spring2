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
        GreeterService gs = ctx.getBean(GreeterService.class);
        String name = gs.whoAmi();
        System.out.println("Hello " + name);
        MainService mainService = ctx.getBean(MainService.class);
        mainService.queste();
        System.out.println(name + " you have " + mainService.getResult() + " correct answers of 5");
    }
}
