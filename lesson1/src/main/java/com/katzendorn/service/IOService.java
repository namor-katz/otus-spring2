package com.katzendorn.service;

import com.katzendorn.entity.Quest;

import java.io.PrintStream;
import java.util.Scanner;

public class IOService {
    private final PrintStream out = System.out;

    public void printQuestions(Quest quest){
        out.println(quest.getQuestion());
        quest.getVersions().forEach(System.out::println);
        out.println("-----------");
    }

    public void printAnswer(boolean result, Quest q){
        if (result){
            out.println("All good!");
            out.println();
        }else {
           out.println("No. correct answer - " + q.getVersions().get(q.getAnswer()));
           out.println();
        }
    }
    public String getInput(){
        StringBuilder sb = new StringBuilder();
        final Scanner scanner = new Scanner(System.in);
        for (String line = scanner.nextLine(); !line.isEmpty(); line = scanner.nextLine()) {
            sb.append(line);
        }
        return sb.length() == 0 ? null : sb.toString();
    }
}
