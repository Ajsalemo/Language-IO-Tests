package com.language.iotests.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    String message = "Language-IO-Tests-Java";

    @GetMapping("/")
    public String index() {
        return message;
    }
}
