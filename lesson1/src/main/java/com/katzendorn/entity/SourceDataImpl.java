package com.katzendorn.entity;

import com.katzendorn.interfaces.SourceData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class SourceDataImpl implements SourceData {
    private Resource resource;
    private byte[] bytes = null;
    @Override
    public String[] getAllContent() {
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
    public Object[] getQuestionSource(String source) {
        String[] sourceAsArray = source.split(";");
        int length = sourceAsArray.length;
        Object[] result = new Object[length];

        result[0] = Integer.parseInt(sourceAsArray[0]);
        result[1] = sourceAsArray[1];
        List<String> ll = new LinkedList<>();
        for(int i=2; i<5; i++){
            ll.add(sourceAsArray[i]);
        }
        result[2] = ll;
        result[3] = Integer.parseInt(sourceAsArray[length-1]);

        return result;
    }
}
