package com.katzendorn.lesson3.utils;

import com.katzendorn.lesson3.config.AppProps;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocalizedUtils {
    private final MessageSource messageSource;
    private final AppProps props;

    public String getLocalizedMessage(String propertyName){
        return messageSource.getMessage(propertyName, new String[]{}, props.getLocale());
    }
}
