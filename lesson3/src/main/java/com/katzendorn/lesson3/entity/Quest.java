package com.katzendorn.lesson3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Quest {
    private final int id;
    private final String question;
    private List<String> versions;
    private final int answer;
}
