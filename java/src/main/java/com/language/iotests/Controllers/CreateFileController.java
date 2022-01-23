package com.language.iotests.Controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateFileController {
    @Value("${FILE_DIR:Files}")
    private String dir;

    @GetMapping("/file/create")
    public ResponseEntity<String> createFile() {
        final String id = UUID.randomUUID().toString();
        final String fileName = "log-rotate-" + id + ".txt";
        String content = "This is a logfile written with id: " + id;
        try {
            File directory = new File(dir);
            File file = new File(directory.getAbsolutePath() + File.separator + fileName);
            try (Writer writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(content);
                return ResponseEntity.status(200).body("Creating logfile with id: " + id);
            } 
        } catch (IOException e) {
            System.out.println(e.toString());
            return ResponseEntity.status(500).body(e.toString());
        }
    }
}
