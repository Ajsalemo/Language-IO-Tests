package com.language.iotests.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadFileController {
    @Value("${FILE_DIR:Files}")
    private String dir;
    private Object data;
    String line;

    @GetMapping("/file/read")
    public ResponseEntity<Object> readFile() {
        final String fileName = "log-append.txt";
        StringBuilder content = new StringBuilder();
        try {
            File directory = new File(dir);
            File file = new File(directory.getAbsolutePath() + File.separator + fileName);
            try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
                data = content.toString();
                return ResponseEntity.status(200).body(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.toString());
        }
    }
}
