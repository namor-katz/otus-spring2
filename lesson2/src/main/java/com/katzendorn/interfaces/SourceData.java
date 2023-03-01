package com.katzendorn.interfaces;

import com.katzendorn.entity.Quest;

import java.util.Map;

public interface SourceData {
    String[] getAllContent();
    Quest getOneQuestOfSource(String source);
}
