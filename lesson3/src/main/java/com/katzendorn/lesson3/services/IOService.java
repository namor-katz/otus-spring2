package com.katzendorn.lesson3.services;

import com.katzendorn.lesson3.entity.Quest;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOService {

    private final PrintStream out = System.out;
    private final Scanner scanner = new Scanner(System.in);

//    public IOService(PrintStream ps, Scanner sc){
//        this.out = System.out;
//        this.scanner = sc;
//    }

    public void simplePrint(String s){
        out.println(s);
    }
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

    @Deprecated
    public String getInput(){
        StringBuilder sb = new StringBuilder();
        for (String line = scanner.nextLine(); !line.isEmpty(); line = scanner.nextLine()) {
            sb.append(line);
        }
        return sb.length() == 0 ? null : sb.toString();
    }

    @SneakyThrows
    public String getInputNew() {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do{
            sb.append(br.readLine());
        }while (false);//мы будем читать значение лишь один раз.
        return sb.isEmpty() ? null : sb.toString();
    }
}
