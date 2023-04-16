package com.katzendorn.shell;

import com.katzendorn.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsCommands {
    private final CalculateService calculateService;
    private final LocalizedService localizedService;
    private final MainService mainService;
    private final CacheService cache;
    @ShellMethod(value = "What is your name?", key = {"l", "login", "MyNameIs"})
    public String setUserName(@ShellOption(defaultValue = "Anon", help = "What is your name?") String userName){
        cache.setValue("login", userName);
        return "Привет " + userName;//TODO i18n
    }

    @ShellMethod(value = "get saved Name", key = {"getName"})
    public void getUserName(){
        System.out.println(cache.getValue("login"));
    }

    @ShellMethod(value = "Add two integers together.", key = {"s", "sum"})
    public int add(int a, int b) {
        return calculateService.calculate(a, b);
    }

    @ShellMethod(value = "Start!")
    public void start(){
        System.out.println("Как тебя звать? используй команду l моёИмя");
    }

    @ShellMethod(value = "Quests", key = {"q", "-q", "--q", "quests"})
    public void askQuests(){
        mainService.queste();
    }
}
