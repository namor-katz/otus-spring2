package com.katzendorn;

import com.katzendorn.entity.SourceDataImpl;
import com.katzendorn.interfaces.CheckAnswer;
import com.katzendorn.interfaces.SourceData;
import com.katzendorn.service.CheckAnswerImpl;
import com.katzendorn.service.GreeterService;
import com.katzendorn.service.IOService;
import com.katzendorn.service.MainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class Configure {

    @Bean
    public SourceData csv(){
        SourceDataImpl csv = new SourceDataImpl();
        Resource resource = new ClassPathResource("one.csv");
        csv.setResource(resource);
        return csv;
    }

    @Bean
    public IOService ioservice(){
        return new IOService();
    }

    @Bean
    public CheckAnswer check(IOService ioservice){
        return new CheckAnswerImpl(ioservice);
    }

    @Bean
    public MainService mainService(SourceData csv, CheckAnswer check, IOService ioService){
        return new MainService(csv, check, ioService);
    }

    @Bean
    public GreeterService greeterService(IOService ioService){
        return new GreeterService(ioService);
    }
}
