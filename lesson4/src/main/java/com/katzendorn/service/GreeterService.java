package com.katzendorn.service;

import com.katzendorn.config.AppProps;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;


@Setter
//@RequiredArgsConstructor
@Service
public class GreeterService {
    private int counter;
    private final IOService ioService;
    private final String whoami;
    private final AppProps props;
    private final MessageSource messageSource;
    private String whoamiLocal;

    public GreeterService(MessageSource messageSource, AppProps props, @Value("${application.message}") String whoami, IOService ioService){
        this.messageSource = messageSource;
        this.props = props;
        this.whoami = whoami;
        this.ioService = ioService;
    }

    public String whoAmi() {
        String whoamiLocal = messageSource.getMessage("user.ask", new String[]{"i"}, props.getLocale());
        ioService.simplePrint(whoamiLocal);
        String answer = ioService.getInputNew();
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
