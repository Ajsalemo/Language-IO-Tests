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
public class AppendFileController {
    @Value("${FILE_DIR:Files}")
    private String dir;

    @GetMapping("/file/append")
    public ResponseEntity<String> appendFile() {
        final String id = UUID.randomUUID().toString();
        final String fileName = "log-append.txt";
        String content = "This logfile is appended with id: " + id + "\n";
        try {
            File directory = new File(dir);
            File file = new File(directory.getAbsolutePath() + File.separator + fileName);
            try (Writer writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(content);
                return ResponseEntity.status(200).body("Appending to log-append.txt");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            return ResponseEntity.status(500).body(e.toString());
        }
    }
}
