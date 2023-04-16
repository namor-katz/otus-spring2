package com.katzendorn.config;

import com.katzendorn.interfaces.ResourceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties(prefix = "application")//это имя файла...
public class AppProps implements ResourceProvider {
    private String message;
    private Locale locale;

    @Value("${application.resources.data-file}")//почему-то эту строку нельзя передать в рукописный конструктор для создания ресурса. на этом этапе она почему-то пустая.
    private String pathToCsvFile;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public String getResources() {
        return pathToCsvFile;
    }
}
