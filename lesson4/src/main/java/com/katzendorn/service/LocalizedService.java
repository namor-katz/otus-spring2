package com.katzendorn.service;

import com.katzendorn.config.AppProps;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocalizedService {
    private final MessageSource messageSource;
    private final AppProps props;

    public String getLocalizedMessage(String propertyName){
        return messageSource.getMessage(propertyName, new String[]{}, props.getLocale());
    }
}
