package com.katzendorn;

import com.katzendorn.entity.Quest;
import com.katzendorn.entity.SourceData;
import com.katzendorn.service.CheckAnswer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private final static List<Quest> ql = new ArrayList<>();

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        SourceData csv = ctx.getBean("csv", SourceData.class);
        CheckAnswer checkAnswer = ctx.getBean(CheckAnswer.class);//объект единственный, можно получать напрямую.
        try{
            String[] aa = csv.getAll();
            for(String s : aa){
                ql.add(new Quest(s));
            }
        }catch (IOException ioex){
            throw new RuntimeException("all broken (");
        }
        if(ql.size() != 0){
            System.out.println("Read next questions, and print number right answer");
            for(Quest q : ql){
                checkAnswer.printQuestions(q);
                String v = CheckAnswer.getInput();
                checkAnswer.checkAnswer(q, v);
            }
        }
    }
}
