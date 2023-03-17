package com.katzendorn.lesson3.services;

import com.katzendorn.lesson3.entity.Quest;
import com.katzendorn.lesson3.interfaces.CheckAnswer;
import com.katzendorn.lesson3.interfaces.SourceData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private final SourceData csv;
    private final CheckAnswer checkAnswer;
    private final IOService ioService;
    private final GreeterService greeterService;
    private final LocalizedService localizedUtils;

    public MainService(SourceData csv, CheckAnswer checkAnswer, IOService io, GreeterService gs, LocalizedService localizedUtils){
        this.csv = csv;
        this.checkAnswer = checkAnswer;
        this.ioService = io;
        this.greeterService = gs;
        this.localizedUtils = localizedUtils;
    }

    public void queste(){
        String name = greeterService.whoAmi();
        String hello = getLocaleMessage("user.hallo");
        ioService.simplePrint(hello + name);
        List<Quest> quests = csv.getQuests();
        if(!quests.isEmpty()){
            ioService.simplePrint(getLocaleMessage("user.offer"));
            for(Quest q : quests){
                ioService.printQuestions(q);
                String v = ioService.getInputNew();
                checkAnswer.checkAnswer(q, v);
            }
        }
        String duHast = getLocaleMessage("user.hat");
        String countAllAnswer = getLocaleMessage("user.allcount");
        ioService.simplePrint(name + duHast + getResult() + countAllAnswer);
    }

    public int getResult(){
        return checkAnswer.getResult();
    }

    private String getLocaleMessage(String nameLocalized){
        return localizedUtils.getLocalizedMessage(nameLocalized);
    }
}
