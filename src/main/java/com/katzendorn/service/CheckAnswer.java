package com.katzendorn.service;

import com.katzendorn.entity.Quest;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class CheckAnswer {
    public void printQuestions(Quest quest){
        System.out.println(quest.getQuestion());
        quest.getVersions().forEach(System.out::println);
        System.out.println("-----------");
    }

    public void checkAnswer(Quest q, String answer){
        int number;
        boolean result = false;
        if(answer == null || answer.isEmpty()) {
            printAnswer(result, q);
            return;
        }
        try {
            number = Integer.parseInt(answer);
        }catch (NumberFormatException nfe){
            number = -20;
        }
        if (number == q.getAnswer()+1){
            result = true;
        }
        printAnswer(result, q);
    }

    private void printAnswer(boolean result, Quest q){
        if (result){
            System.out.println("All good!");
            System.out.println();
        }else {
            System.out.println("No. correct answer - " + q.getVersions().get(q.getAnswer()));
            System.out.println();
        }
    }

    public static String getInput() {
        StringBuilder sb = new StringBuilder();
        final Scanner scanner = new Scanner(System.in);
        for (String line = scanner.nextLine(); !line.isEmpty(); line = scanner.nextLine()) {
            sb.append(line);
        }
        return sb.length() == 0 ? null : sb.toString();
    }
}
