package com.katzendorn.service;

import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

import org.jline.utils.AttributedString;
@Component
public class CustomPromptProvider implements PromptProvider {
    @Override
    public AttributedString getPrompt(){
        return new AttributedString("input# ", AttributedStyle.DEFAULT.background(AttributedStyle.GREEN));
    }
}
