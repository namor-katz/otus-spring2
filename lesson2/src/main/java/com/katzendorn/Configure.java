package com.katzendorn;

import com.katzendorn.repository.SourceDataImpl;
import com.katzendorn.interfaces.CheckAnswer;
import com.katzendorn.interfaces.SourceData;
import com.katzendorn.service.CheckAnswerImpl;
import com.katzendorn.service.GreeterService;
import com.katzendorn.service.IOService;
import com.katzendorn.service.MainService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:application.properties")//несмотря на все крики про автоконфигурируемость указывать путь к конф файлу придётся явно. возможно в буте это не так.
public class Configure {
    @Value("${file}")
    private String resourceCsv;

    @Bean
    public SourceData csv(){
        SourceDataImpl csv = new SourceDataImpl();
        Resource resource = new ClassPathResource(resourceCsv);
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
    public MainService mainService(SourceData csv, CheckAnswer check, IOService ioService, GreeterService gs){
        return new MainService(csv, check, ioService, gs);
    }

    @Bean
    public GreeterService greeterService(IOService ioService){
        return new GreeterService(ioService);
    }
}
