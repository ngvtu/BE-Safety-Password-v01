package com.example.besafetypassv1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping(path = "/api", consumes = {"application/json"})

public class AppController {
    private final Logger logger = LogManager.getLogger(AppController.class);

    @PostMapping("/pingNet")
    public String pingNet(){
        return "Ping done!";
    }

    @GetMapping("/pingGet")
    public String pingGet(){
        return "Ping get done!";
    }
}
