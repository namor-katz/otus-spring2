package com.katzendorn.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Getter
@Setter
public class SourceData {
    private Resource resource;
    public String[] getAll() throws IOException {
        InputStream inputStream = resource.getInputStream();
        byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
        String result = new String(bytes, StandardCharsets.UTF_8);
        return result.split("\n");
    }
}
