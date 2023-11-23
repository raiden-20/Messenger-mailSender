package ru.vsu.cs.sheina.mailsender.util;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FileReader {
    private final ResourceLoader resourceLoader;

    public String readFile(String fileName) {
        try {
            Resource resource = resourceLoader.getResource("classpath:/static/" + fileName);
            byte[] fileData = FileCopyUtils.copyToByteArray(resource.getInputStream());
            return new String(fileData, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
