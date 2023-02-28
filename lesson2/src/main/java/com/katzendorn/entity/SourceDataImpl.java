package com.katzendorn.entity;

import com.katzendorn.interfaces.SourceData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import static com.katzendorn.interfaces.Constants.*;

@Getter
@Setter
public class SourceDataImpl implements SourceData {
    private Resource resource;
    @Override
    public String[] getAllContent() {
        byte[] bytes = null;
        try {
            InputStream inputStream = resource.getInputStream();
            bytes = FileCopyUtils.copyToByteArray(inputStream);
        }catch (IOException ioe){
            throw new RuntimeException("resource don't parse or not exist");
        }
        String result = new String(bytes, StandardCharsets.UTF_8);
        return result.split("\n");
    }

    @Override
    public Map<String, Object> getQuestionSource(String sourceStringOfCsv){
        Map<String, Object> fromQuest = new HashMap<>();

        String[] sourceAsArray = sourceStringOfCsv.split(";");
        int length = sourceAsArray.length;
        fromQuest.put(ID, Integer.parseInt(sourceAsArray[0]));
        fromQuest.put(QUEST, sourceAsArray[1]);
        List<String> ll = new LinkedList<>();
        for(int i=2; i<5; i++){
            ll.add(sourceAsArray[i]);
        }
        fromQuest.put(VERSIONS, ll);
        fromQuest.put(ANSWER, Integer.parseInt(sourceAsArray[length-1])) ;
        return fromQuest;
    }
}
