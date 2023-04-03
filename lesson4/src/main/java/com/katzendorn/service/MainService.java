package com.katzendorn.service;

import com.katzendorn.entity.Quest;
import com.katzendorn.interfaces.CheckAnswer;
import com.katzendorn.interfaces.SourceData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private final SourceData csv;
    private final CheckAnswer checkAnswer;
    private final IOService ioService;
    private final GreeterService greeterService;
    private final LocalizedService localizedUtils;
    private final CacheService cache;

    public MainService(SourceData csv, CheckAnswer checkAnswer, IOService io, GreeterService gs, LocalizedService localizedUtils,
                       CacheService cache){
        this.csv = csv;
        this.checkAnswer = checkAnswer;
        this.ioService = io;
        this.greeterService = gs;
        this.localizedUtils = localizedUtils;
        this.cache = cache;
    }

    public void queste(){
        String name = cache.getValue("login");
//        String name = greeterService.whoAmi();//сюда входим лишь после выхода из шелла. ( то бишь шелл, ко всему прочему, блокирует ожидаемую работу приложения.
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
