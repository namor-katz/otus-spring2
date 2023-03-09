package com.katzendorn.lesson3.repository;

import com.katzendorn.lesson3.entity.Quest;
import com.katzendorn.lesson3.interfaces.SourceData;
import com.katzendorn.lesson3.utils.Util;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import static com.katzendorn.lesson3.interfaces.Constants.*;

@Getter
@Setter
@Component
@AllArgsConstructor
public class SourceDataImpl implements SourceData {
    private final Util util;

    @Override
    public List<Quest> getQuests(){
        List<Quest> quests = new LinkedList<>();
        String[] content = getAllContent();
        for(String s : content){
            quests.add(getOneQuestOfSource(s));
        }
        return quests;
    }

    private String[] getAllContent() {
        byte[] bytes = null;
        try {
            Resource resource = util.loadCsvFileByPath();
            InputStream inputStream = resource.getInputStream();
            bytes = FileCopyUtils.copyToByteArray(inputStream);
        }catch (IOException ioe){
            throw new RuntimeException("resource don't parse or not exist");
        }
        String result = new String(bytes, StandardCharsets.UTF_8);
        return result.split("\n");
    }

    private Quest getOneQuestOfSource(String sourceStringOfCsv){
        String[] sourceAsArray = sourceStringOfCsv.split(";");
        int length = sourceAsArray.length;
        List<String> ll = new LinkedList<>();
        for(int i=2; i<5; i++){
            ll.add(sourceAsArray[i]);
        }
        int id = Integer.parseInt(sourceAsArray[0]);
        String question = sourceAsArray[1];
        int answerNumber = Integer.parseInt(sourceAsArray[length-1]);
        return new Quest(id, question, ll, answerNumber);
    }
}
