package com.katzendorn.lesson3.services;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@RequiredArgsConstructor
@Service
public class GreeterService {
    private int counter = 0;
    private final IOService ioService;
    private final String whoami = "What is your Name?";

    public String whoAmi(){
        ioService.simplePrint(whoami);
        String answer = ioService.getInput();
        if(answer != null && !answer.isEmpty()){
            return answer.trim();
        }else {
            if(counter < 3){
                counter++;
                whoAmi();
            }else {
                throw new RuntimeException("NoName");
            }
        }
        throw new RuntimeException();
    }
}
