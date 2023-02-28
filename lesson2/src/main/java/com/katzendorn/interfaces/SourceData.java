package com.katzendorn.interfaces;

import java.util.Map;

public interface SourceData {
    String[] getAllContent();
    Map<String, Object> getQuestionSource(String source);
}
